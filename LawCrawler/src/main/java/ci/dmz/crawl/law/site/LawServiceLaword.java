/**
 * 
 */
package ci.dmz.crawl.law.site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ci.dmz.crawl.law.LawParam;
import ci.dmz.crawl.law.LawUtil;
import ci.dmz.crawl.law.vo.Laword;
import ci.dmz.crawl.law.vo.LawordAdrue;
import ci.dmz.crawl.law.vo.LawordAttc;
import ci.dmz.crawl.law.vo.LawordComp;
import ci.dmz.crawl.law.vo.LawordCompHang;
import ci.dmz.crawl.law.vo.LawordCompHangHo;
import ci.dmz.crawl.law.vo.LawordLst;
import ci.dmz.crawl.law.vo.LawordReviCnt;
import ci.dmz.crawl.law.vo.LawordReviRsn;
import ci.dmz.crawl.util.DataSource;

/**
 * @author 이동훈
 *
 */
public class LawServiceLaword implements LawService<LawordLst, Laword> {

	private String url;

	public LawServiceLaword() {
		this.url = new LawParam().getUrlService("law");
	}

	@Override
	public void crawlPartial(boolean isDelete) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void crawlFull(boolean isDelete) throws ParserConfigurationException, SAXException, SQLException {
		System.out.println("법령본문 - 시작");

		// 데이터 삭제
		if (isDelete) {
			clearFullData();
		}

		// 데이터 삽입
		ArrayList<LawordLst> listParent = getParentList();
		System.out.println("법령본문 - 데이터 생성 시작 : " + listParent.size());

		int i = 1;
		for (LawordLst parent : listParent) {
			Laword child = crawlChildData(parent);
			System.out.println("법령본문 - 데이터 삽입 진행(" + i++ + "건)");
			insertData(child);
		}
		System.out.println("법령본문 - 종료");
	}

	@Override
	public void clearFullData() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		PreparedStatement psmtAdrue = null;
		PreparedStatement psmtAttc = null;
		PreparedStatement psmtComp = null;
		PreparedStatement psmtCompHang = null;
		PreparedStatement psmtCompHangHo = null;
		PreparedStatement psmtReviCnt = null;
		PreparedStatement psmtReviRsn = null;

		String sql;

		try {
			con = DataSource.getConnection();

			sql = "TRUNCATE TABLE law_laword_comp_hang_ho";
			psmtCompHangHo = con.prepareStatement(sql.toString());
			psmtCompHangHo.executeUpdate();

			sql = "TRUNCATE TABLE law_laword_comp_hang";
			psmtCompHang = con.prepareStatement(sql.toString());
			psmtCompHang.executeUpdate();

			sql = "TRUNCATE TABLE law_laword_comp";
			psmtComp = con.prepareStatement(sql.toString());
			psmtComp.executeUpdate();

			sql = "TRUNCATE TABLE law_laword_attc";
			psmtAttc = con.prepareStatement(sql.toString());
			psmtAttc.executeUpdate();

			sql = "TRUNCATE TABLE law_laword_adrue";
			psmtAdrue = con.prepareStatement(sql.toString());
			psmtAdrue.executeUpdate();

			sql = "TRUNCATE TABLE law_laword_revi_cnt";
			psmtReviCnt = con.prepareStatement(sql.toString());
			psmtReviCnt.executeUpdate();

			sql = "TRUNCATE TABLE law_laword_revi_rsn";
			psmtReviRsn = con.prepareStatement(sql.toString());
			psmtReviRsn.executeUpdate();

			sql = "TRUNCATE TABLE law_laword";
			psmt = con.prepareStatement(sql.toString());
			psmt.executeUpdate();

			con.commit();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw e1;
		} finally {
			try {
				psmtCompHangHo.close();
				psmtCompHang.close();
				psmtComp.close();
				psmtAttc.close();
				psmtAdrue.close();
				psmtReviCnt.close();
				psmtReviRsn.close();
				psmt.close();
			} catch (SQLException e) {
				throw e;
			}
			DataSource.returnConnection(con);
		}
	}

	@Override
	public ArrayList<LawordLst> getParentList() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();
//		sql.append("select * from law_laword_lst order by laword_id desc limit 200");
//		sql.append("select * from law_laword_lst where laword_id in ('009599')");
//		sql.append("select * from law_laword_lst where laword_id in ('013470')");
//		sql.append("select * from law_laword_lst where laword_id in ('001444', '006540')");
		sql.append("" //
				+ "SELECT * " //
				+ "  FROM law_laword_lst a " //
				+ " WHERE NOT EXISTS ( SELECT * " //
				+ "                      FROM law_laword b " //
				+ "                     WHERE a.laword_id = b.laword_id )" //
				+ " order by cnfdcr_dt asc"); //

		ArrayList<LawordLst> list = new ArrayList<LawordLst>();
		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());
			rs = psmt.executeQuery();

			String key;
			while (rs.next()) {
				key = rs.getString("laword_id");

				LawordLst vo = new LawordLst();
				vo.setLawordId(key);

				list.add(vo);
			}

			con.commit();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw e1;
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				throw e;
			}
			try {
				psmt.close();
			} catch (SQLException e) {
				throw e;
			}
			DataSource.returnConnection(con);
		}

		return list;
	}

	@Override
	public Laword crawlChildData(LawordLst parent) throws ParserConfigurationException, SAXException {
		System.out.println(url + parent.getLawordId());
		Document document = LawUtil.loadXML(url + parent.getLawordId());
//		Document document = LawUtil.loadXML(url + "009599");
//		Document document = LawUtil.loadXML("./sample/law.xml");
		Element root = document.getDocumentElement();
		NodeList nodes = root.getChildNodes();

		Laword child = new Laword();
		child.setLawordKey(root.getAttributes().item(0).getFirstChild().getNodeValue());
		child.setLawordId(parent.getLawordId());
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
//			System.out.println((i + 1) + ". " + node.getNodeName());
			switch (node.getNodeName()) {
			case "기본정보":
				makeLaword(node, child);
				break;
			case "조문":
				makeLawordComp(node, child);
				break;
			case "부칙":
				makeLawordAdrue(node, child);
				break;
			case "별표":
				makeLawordAttc(node, child);
				break;
			case "개정문":
				makeLawordReviCnt(node, child);
				break;
			case "제개정이유":
				makeLawordReviRsn(node, child);
				break;
			default:
			}
		}

		return child;
	}

	private void makeLaword(Node root, Laword child) {
		NodeList nodes = root.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println(" - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "법령ID":
				child.setLawordId(value);
				break;
			case "공포일자":
				child.setPrmgDt(value);
				break;
			case "공포번호":
				child.setPrmgNo(value);
				break;
			case "언어":
				child.setLangTyp(value);
				break;
			case "법종구분":
				child.setLawkndTyp(value);
				break;
			case "법종구분코드":
				child.setLawkndCd(value);
				break;
			case "법령명_한글":
				child.setLawordNm(value);
				break;
			case "법령명_한자":
				child.setLawordNmCh(value);
				break;
			case "법령명약칭":
				child.setLawordAbrv(value);
				break;
			case "제명변경여부":
				child.setTtlChgYn(value);
				break;
			case "한글법령여부":
				child.setKorLawordYn(value);
				break;
			case "편장절관":
				child.setCompSn(value);
				break;
			case "소관부처코드":
				child.setJrsdMofCd(value);
				break;
			case "소관부처":
				child.setJrsdMofNm(value);
				break;
			case "전화번호":
				child.setTelNo(value);
				break;
			case "시행일자":
				child.setCnfdcrDt(value);
				break;
			case "제개정구분":
				child.setReviTypNm(value);
				break;
			case "별표시행일자문자열":
				child.setAttcCnfdcrDtStr(value);
				break;
			case "별표편집여부":
				child.setAttcEdtYn(value);
				break;
			case "공포법령여부":
				child.setPrmgEdtYn(value);
				break;
			default:
			}
		}
	}

	private void makeLawordComp(Node root, Laword child) {
		NodeList nodes = root.getChildNodes();

		for (int i = 0, j = 1; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
//			System.out.println(" " + j + ") " + node.getNodeName());
			switch (node.getNodeName()) {
			case "조문단위":
				child.getLawordComps().add(getLawordCompChild(node, child, j++));
				break;
			default:
			}
		}
	}

	private LawordComp getLawordCompChild(Node root, Laword child, int key) {
		NodeList nodes = root.getChildNodes();

		LawordComp vo = new LawordComp();
		vo.setLawordKey(child.getLawordKey());
		vo.setCompKey(key);
		vo.setCompKey2(root.getAttributes().item(0).getFirstChild().getNodeValue());
		for (int i = 0, j = 1; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("  - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "조문번호":
				vo.setCompNo(value);
				break;
			case "조문여부":
				vo.setCompYn(value);
				break;
			case "조문제목":
				vo.setCompNm(value);
				break;
			case "조문시행일자":
				vo.setCompCnfDt(value);
				break;
			case "조문제개정유형":
				vo.setCompRvsTyp(value);
				break;
			case "조문이동이전":
				vo.setCompMvmBf(value);
				break;
			case "조문이동이후":
				vo.setCompMvmAf(value);
				break;
			case "조문변경여부":
				vo.setCompChnYn(value);
				break;
			case "조문내용":
				vo.setCompCnt(value);
				break;
			case "항":
				vo.getLawordCompHangs().add(getLawordCompHang(node, vo, j++));
				break;
			default:
			}
		}

		return vo;
	}

	private LawordCompHang getLawordCompHang(Node root, LawordComp child, int key) {
		NodeList nodes = root.getChildNodes();

		LawordCompHang vo = new LawordCompHang();
		vo.setLawordKey(child.getLawordKey());
		vo.setCompKey(child.getCompKey());
		vo.setHangKey(key);
		for (int i = 0, j = 1; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("   - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "항번호":
				vo.setHangNo(value);
				break;
			case "항제개정유형":
				vo.setHangReviTyp(value);
				break;
			case "항제개정일자문자열":
				vo.setHangReviDt(value);
				break;
			case "항내용":
				vo.setHangCnt(value);
				break;
			case "호":
				vo.getLawordCompHangHos().add(getLawordCompHangHo(node, vo, j++));
				break;
			default:
			}
		}

		return vo;
	}

	private LawordCompHangHo getLawordCompHangHo(Node root, LawordCompHang child, int key) {
		NodeList nodes = root.getChildNodes();

		LawordCompHangHo vo = new LawordCompHangHo();
		vo.setLawordKey(child.getLawordKey());
		vo.setCompKey(child.getCompKey());
		vo.setHangKey(child.getHangKey());
		vo.setHoKey(key);
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("    - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "호번호":
				vo.setHoNo(value);
				break;
			case "호내용":
				vo.setHoCnt(value);
				break;
			default:
			}
		}

		return vo;
	}

	private void makeLawordAdrue(Node root, Laword child) {
		NodeList nodes = root.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
//			System.out.println(" " + (i + 1) + ") " + node.getNodeName());
			switch (node.getNodeName()) {
			case "부칙단위":
				child.getLawordAdrues().add(getLawordAdrue(node, child));
				break;
			default:
			}
		}
	}

	private LawordAdrue getLawordAdrue(Node root, Laword child) {
		NodeList nodes = root.getChildNodes();

		LawordAdrue vo = new LawordAdrue();
		vo.setLawordKey(child.getLawordKey());
		vo.setAdrueKey(root.getAttributes().item(0).getFirstChild().getNodeValue());
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("  - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "부칙공포번호":
				vo.setAdruePrmgno(value);
				break;
			case "부칙공포일자":
				vo.setAdruePrmgDt(value);
				break;
			case "부칙내용":
				vo.setAdrueCnt(value);
				break;
			default:
			}
		}

		return vo;
	}

	private void makeLawordAttc(Node root, Laword child) {
		NodeList nodes = root.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
//			System.out.println(" " + (i + 1) + ") " + node.getNodeName());
			switch (node.getNodeName()) {
			case "별표단위":
				child.getLawordAttcs().add(getLawordAttc(node, child));
				break;
			default:
			}
		}
	}

	private LawordAttc getLawordAttc(Node root, Laword child) {
		NodeList nodes = root.getChildNodes();

		LawordAttc vo = new LawordAttc();
		vo.setLawordKey(child.getLawordKey());
		vo.setAttcKey(root.getAttributes().item(0).getFirstChild().getNodeValue());
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("    - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "별표번호":
				vo.setAttcNo(value);
				break;
			case "별표가지번호":
				vo.setAttcBrncNo(value);
				break;
			case "별표구분":
				vo.setAttcTyp(value);
				break;
			case "별표제목":
				vo.setAttcNm(value);
				break;
			case "별표시행일자":
				vo.setAttcCnfdcrDt(value);
				break;
			case "별표서식파일링크":
				vo.setAttcFileLnk(value);
				break;
			case "별표HWP파일명":
				vo.setAttcHwpNm(value);
				break;
			case "별표서식PDF파일링크":
				vo.setAttcPdfLnk(value);
				break;
			case "별표PDF파일명":
				vo.setAttcPdfNm(value);
				break;
			case "별표이미지파일명":
				vo.setAttcImgNm(value);
				break;
			case "별표내용":
				vo.setAttcCnt(value);
				break;
			default:
			}
		}

		return vo;
	}

	private void makeLawordReviCnt(Node root, Laword child) {
		NodeList nodes = root.getChildNodes();

		LawordReviCnt vo = new LawordReviCnt();
		vo.setLawordKey(child.getLawordKey());
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("  - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "개정문내용":
				vo.setReviTypCnt(value);
				break;
			default:
			}
		}

		child.setLawordReviCnt(vo);
	}

	private void makeLawordReviRsn(Node root, Laword child) {
		NodeList nodes = root.getChildNodes();

		LawordReviRsn vo = new LawordReviRsn();
		vo.setLawordKey(child.getLawordKey());
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("  - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "제개정이유내용":
				vo.setReviRsnCnt(value);
				break;
			default:
			}
		}

		child.setLawordReviRsn(vo);
	}

	@Override
	public void insertFullData(ArrayList<Laword> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertData(Laword child) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		PreparedStatement psmtAdrue = null;
		PreparedStatement psmtAttc = null;
		PreparedStatement psmtComp = null;
		PreparedStatement psmtCompHang = null;
		PreparedStatement psmtCompHangHo = null;
		PreparedStatement psmtReviCnt = null;
		PreparedStatement psmtReviRsn = null;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO law_laword").append("\n");
		sql.append("(laword_key, laword_id, prmg_dt, prmg_no, lang_typ, lawknd_typ, lawknd_cd, " //
				+ "laword_nm, laword_nm_ch, laword_abrv, comp_sn, jrsd_mof_cd, jrsd_mof_nm, tel_no, " //
				+ "cnfdcr_dt, revi_typ_nm, attc_edt_yn, prmg_edt_yn, attc_cnfdcr_dt_str, ttl_chg_yn, " //
				+ "kor_laword_yn)").append("\n");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)").append("\n");

		StringBuilder sqlAdrue = new StringBuilder();
		sqlAdrue.append("INSERT INTO law_laword_adrue").append("\n");
		sqlAdrue.append("(laword_key, adrue_key, adrue_prmg_dt, adrue_prmg_no, adrue_cnt)").append("\n");
		sqlAdrue.append("VALUES(?, ?, ?, ?, ?)");

		StringBuilder sqlAttc = new StringBuilder();
		sqlAttc.append("INSERT INTO law_laword_attc").append("\n");
		sqlAttc.append("(laword_key, attc_key, attc_no, attc_brnc_no, attc_typ, attc_nm, " //
				+ "attc_cnfdcr_Dt, attc_file_lnk, attc_hwp_nm, attc_pdf_lnk, attc_pdf_nm, " //
				+ "attc_img_nm, attc_cnt)").append("\n");
		sqlAttc.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		StringBuilder sqlComp = new StringBuilder();
		sqlComp.append("INSERT INTO law_laword_comp").append("\n");
		sqlComp.append("(laword_key, comp_key, comp_key2, comp_no, comp_yn, comp_nm, comp_cnf_dt, " //
				+ "comp_rvs_typ, comp_mvm_bf, comp_mvm_af, comp_chn_yn, comp_cnt)").append("\n");
		sqlComp.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		StringBuilder sqlCompHang = new StringBuilder();
		sqlCompHang.append("INSERT INTO law_laword_comp_hang").append("\n");
		sqlCompHang.append("(laword_key, comp_key, hang_key, hang_no, hang_revi_typ, hang_revi_dt, hang_cnt)")
				.append("\n");
		sqlCompHang.append("VALUES(?, ?, ?, ?, ?, ?, ?)");

		StringBuilder sqlCompHangHo = new StringBuilder();
		sqlCompHangHo.append("INSERT INTO law_laword_comp_hang_ho").append("\n");
		sqlCompHangHo.append("(laword_key, comp_key, hang_key, ho_key, ho_no, ho_cnt)").append("\n");
		sqlCompHangHo.append("VALUES(?, ?, ?, ?, ?, ?)");

		StringBuilder sqlReviCnt = new StringBuilder();
		sqlReviCnt.append("INSERT INTO law_laword_revi_cnt").append("\n");
		sqlReviCnt.append("(laword_key, revi_typ_cnt)").append("\n");
		sqlReviCnt.append("VALUES(?, ?)");

		StringBuilder sqlReviRsn = new StringBuilder();
		sqlReviRsn.append("INSERT INTO law_laword_revi_rsn").append("\n");
		sqlReviRsn.append("(laword_key, revi_rsn_cnt)").append("\n");
		sqlReviRsn.append("VALUES(?, ?)");

		int no;
		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());
			psmtAdrue = con.prepareStatement(sqlAdrue.toString());
			psmtAttc = con.prepareStatement(sqlAttc.toString());
			psmtComp = con.prepareStatement(sqlComp.toString());
			psmtCompHang = con.prepareStatement(sqlCompHang.toString());
			psmtCompHangHo = con.prepareStatement(sqlCompHangHo.toString());
			psmtReviCnt = con.prepareStatement(sqlReviCnt.toString());
			psmtReviRsn = con.prepareStatement(sqlReviRsn.toString());

			no = 1;
			psmt.setString(no++, child.getLawordKey());
			psmt.setString(no++, child.getLawordId());
			psmt.setString(no++, child.getPrmgDt());
			psmt.setString(no++, child.getPrmgNo());
			psmt.setString(no++, child.getLangTyp());
			psmt.setString(no++, child.getLawkndTyp());
			psmt.setString(no++, child.getLawkndCd());
			psmt.setString(no++, child.getLawordNm());
			psmt.setString(no++, child.getLawordNmCh());
			psmt.setString(no++, child.getLawordAbrv());
			psmt.setString(no++, child.getTtlChgYn());
			psmt.setString(no++, child.getKorLawordYn());
			psmt.setString(no++, child.getCompSn());
			psmt.setString(no++, child.getJrsdMofCd());
			psmt.setString(no++, child.getJrsdMofNm());
			psmt.setString(no++, child.getTelNo());
			psmt.setString(no++, child.getCnfdcrDt());
			psmt.setString(no++, child.getReviTypNm());
			psmt.setString(no++, child.getAttcCnfdcrDtStr());
			psmt.setString(no++, child.getAttcEdtYn());
			psmt.setString(no++, child.getPrmgEdtYn());

			psmt.executeUpdate();

			ArrayList<LawordAdrue> adrues = child.getLawordAdrues();
			for (LawordAdrue adrue : adrues) {
				no = 1;
				psmtAdrue.setString(no++, adrue.getLawordKey());
				psmtAdrue.setString(no++, adrue.getAdrueKey());
				psmtAdrue.setString(no++, adrue.getAdruePrmgDt());
				psmtAdrue.setString(no++, adrue.getAdruePrmgno());
				psmtAdrue.setString(no++, adrue.getAdrueCnt());

				psmtAdrue.executeUpdate();
			}

			ArrayList<LawordAttc> attcs = child.getLawordAttcs();
			for (LawordAttc attc : attcs) {
				no = 1;
				psmtAttc.setString(no++, attc.getLawordKey());
				psmtAttc.setString(no++, attc.getAttcKey());
				psmtAttc.setString(no++, attc.getAttcNo());
				psmtAttc.setString(no++, attc.getAttcBrncNo());
				psmtAttc.setString(no++, attc.getAttcTyp());
				psmtAttc.setString(no++, attc.getAttcNm());
				psmtAttc.setString(no++, attc.getAttcCnfdcrDt());
				psmtAttc.setString(no++, attc.getAttcFileLnk());
				psmtAttc.setString(no++, attc.getAttcHwpNm());
				psmtAttc.setString(no++, attc.getAttcPdfLnk());
				psmtAttc.setString(no++, attc.getAttcPdfNm());
				psmtAttc.setString(no++, attc.getAttcImgNm());
				psmtAttc.setString(no++, attc.getAttcCnt());

				psmtAttc.executeUpdate();
			}

			ArrayList<LawordComp> comps = child.getLawordComps();

			for (LawordComp comp : comps) {
				no = 1;
				psmtComp.setString(no++, comp.getLawordKey());
				psmtComp.setInt(no++, comp.getCompKey());
				psmtComp.setString(no++, comp.getCompKey2());
				psmtComp.setString(no++, comp.getCompNo());
				psmtComp.setString(no++, comp.getCompYn());
				psmtComp.setString(no++, comp.getCompNm());
				psmtComp.setString(no++, comp.getCompCnfDt());
				psmtComp.setString(no++, comp.getCompRvsTyp());
				psmtComp.setString(no++, comp.getCompMvmBf());
				psmtComp.setString(no++, comp.getCompMvmAf());
				psmtComp.setString(no++, comp.getCompChnYn());
				psmtComp.setString(no++, comp.getCompCnt());

				psmtComp.executeUpdate();

				ArrayList<LawordCompHang> compHangs = comp.getLawordCompHangs();
				for (LawordCompHang compHang : compHangs) {
					no = 1;
					psmtCompHang.setString(no++, compHang.getLawordKey());
					psmtCompHang.setInt(no++, compHang.getCompKey());
					psmtCompHang.setInt(no++, compHang.getHangKey());
					psmtCompHang.setString(no++, compHang.getHangNo());
					psmtCompHang.setString(no++, compHang.getHangReviTyp());
					psmtCompHang.setString(no++, compHang.getHangReviDt());
					psmtCompHang.setString(no++, compHang.getHangCnt());

					psmtCompHang.executeUpdate();

					ArrayList<LawordCompHangHo> compHangHos = compHang.getLawordCompHangHos();
					for (LawordCompHangHo compHangHo : compHangHos) {
						no = 1;
						psmtCompHangHo.setString(no++, compHangHo.getLawordKey());
						psmtCompHangHo.setInt(no++, compHangHo.getCompKey());
						psmtCompHangHo.setInt(no++, compHangHo.getHangKey());
						psmtCompHangHo.setInt(no++, compHangHo.getHoKey());
						psmtCompHangHo.setString(no++, compHangHo.getHoNo());
						psmtCompHangHo.setString(no++, compHangHo.getHoCnt());

						psmtCompHangHo.executeUpdate();
					}
				}
			}

			LawordReviCnt reviCnt = child.getLawordReviCnt();
			if (reviCnt != null) {
				no = 1;
				psmtReviCnt.setString(no++, reviCnt.getLawordKey());
				psmtReviCnt.setString(no++, reviCnt.getReviTypCnt());
				psmtReviCnt.executeUpdate();
			}

			LawordReviRsn reviRsn = child.getLawordReviRsn();
			if (reviRsn != null) {
				no = 1;
				psmtReviRsn.setString(no++, reviRsn.getLawordKey());
				psmtReviRsn.setString(no++, reviRsn.getReviRsnCnt());
				psmtReviRsn.executeUpdate();
			}

			con.commit();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw e1;
		} finally {
			try {
				psmt.close();
				psmtAdrue.close();
				psmtAttc.close();
				psmtComp.close();
				psmtCompHang.close();
				psmtCompHangHo.close();
				psmtReviCnt.close();
				psmtReviRsn.close();
			} catch (SQLException e) {
				throw e;
			}
			DataSource.returnConnection(con);
		}
	}

}
