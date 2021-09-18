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
import ci.dmz.crawl.law.vo.Admrul;
import ci.dmz.crawl.law.vo.AdmrulAdrue;
import ci.dmz.crawl.law.vo.AdmrulAttc;
import ci.dmz.crawl.law.vo.AdmrulComp;
import ci.dmz.crawl.law.vo.AdmrulFile;
import ci.dmz.crawl.law.vo.AdmrulLst;
import ci.dmz.crawl.law.vo.AdmrulReviCnt;
import ci.dmz.crawl.law.vo.AdmrulReviRsn;
import ci.dmz.crawl.util.DataSource;

/**
 * @author 이동훈
 *
 */
public class LawServiceAdmrul implements LawService<AdmrulLst, Admrul> {

	private String url;

	public LawServiceAdmrul() {
		this.url = new LawParam().getUrlService("admrul");
	}

	@Override
	public void crawlPartial(boolean isDelete) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void crawlFull(boolean isDelete) throws ParserConfigurationException, SAXException, SQLException {
		System.out.println("행정규칙 본문 - 시작");

		// 데이터 삭제
		if (isDelete) {
			clearFullData();
		}

		// 데이터 삽입
		ArrayList<AdmrulLst> listParent = getParentList();
		System.out.println("행정규칙 본문 - 데이터 생성 시작 : " + listParent.size());

		int i = 1;
		for (AdmrulLst parent : listParent) {
			Admrul child = crawlChildData(parent);
			if(child.getAdmrulSn() == null) {
				System.out.println("행정규칙 본문 - 생성 실패(일치하는 행정규칙이 없습니다)");
				continue;
			}
			
			System.out.println("행정규칙 본문 - 데이터 삽입 진행(" + i++ + "건)");
			insertData(child);
		}
		System.out.println("행정규칙 본문 - 종료");
	}

	@Override
	public void clearFullData() throws SQLException {
		Connection con = null;
		PreparedStatement psmtAdrue = null;
		PreparedStatement psmtAttc = null;
		PreparedStatement psmtComp = null;
		PreparedStatement psmtFile = null;
		PreparedStatement psmtReviCnt = null;
		PreparedStatement psmtReviRsn = null;
		PreparedStatement psmt = null;

		String sql;

		try {
			con = DataSource.getConnection();

			sql = "TRUNCATE TABLE law_admrul_adrue";
			psmtAdrue = con.prepareStatement(sql.toString());
			psmtAdrue.executeUpdate();

			sql = "TRUNCATE TABLE law_admrul_attc";
			psmtAttc = con.prepareStatement(sql.toString());
			psmtAttc.executeUpdate();

			sql = "TRUNCATE TABLE law_admrul_comp";
			psmtComp = con.prepareStatement(sql.toString());
			psmtComp.executeUpdate();

			sql = "TRUNCATE TABLE law_admrul_file";
			psmtFile = con.prepareStatement(sql.toString());
			psmtFile.executeUpdate();

			sql = "TRUNCATE TABLE law_admrul_revi_cnt";
			psmtReviCnt = con.prepareStatement(sql.toString());
			psmtReviCnt.executeUpdate();

			sql = "TRUNCATE TABLE law_admrul_revi_rsn";
			psmtReviRsn = con.prepareStatement(sql.toString());
			psmtReviRsn.executeUpdate();

			sql = "TRUNCATE TABLE law_admrul";
			psmt = con.prepareStatement(sql.toString());
			psmt.executeUpdate();

			con.commit();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw e1;
		} finally {
			try {
				psmtAdrue.close();
				psmtAttc.close();
				psmtFile.close();
				psmtReviCnt.close();
				psmtReviRsn.close();
				psmtComp.close();
				psmt.close();
			} catch (SQLException e) {
				throw e;
			}
			DataSource.returnConnection(con);
		}
	}

	@Override
	public ArrayList<AdmrulLst> getParentList() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();
//		sql.append("select * from law_admrul_lst order by admrul_sn desc limit 10");
//		sql.append("select * from law_admrul_lst where admrul_sn in ('2100000204372')");
//		sql.append("select * from law_admrul_lst where admrul_sn in ('013470')");
//		sql.append("select * from law_admrul_lst where admrul_sn in ('2100000204371', '2100000204372')");
		sql.append("" //
				+ "SELECT * " //
				+ "  FROM law_admrul_lst a " //
				+ " WHERE NOT EXISTS ( SELECT * " //
				+ "                      FROM law_admrul b " //
				+ "                     WHERE a.admrul_sn = b.admrul_sn )" //
				+ " order by gnfd_dt asc"); //

		ArrayList<AdmrulLst> list = new ArrayList<AdmrulLst>();
		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());
			rs = psmt.executeQuery();

			String key;
			while (rs.next()) {
				key = rs.getString("admrul_sn");

				AdmrulLst vo = new AdmrulLst();
				vo.setAdmrulId(key);

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
	public Admrul crawlChildData(AdmrulLst parent) throws ParserConfigurationException, SAXException {
		System.out.println(url + parent.getAdmrulId());
		Document document = LawUtil.loadXML(url + parent.getAdmrulId());
//		Document document = LawUtil.loadXML(url + "009599");
//		Document document = LawUtil.loadXML("./sample/law.xml");
		Element root = document.getDocumentElement();
		NodeList nodes = root.getChildNodes();

		Admrul child = new Admrul();
		for (int i = 0, j = 1, k = 1; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
//			System.out.println((i + 1) + ". " + node.getNodeName());
			switch (node.getNodeName()) {
			case "행정규칙기본정보":
				makeAdmrul(node, child);
				break;
			case "조문내용":
				makeAdmrulComp(node, child, j++);
				break;
			case "부칙":
				makeAdmrulAdrue(node, child, k++);
				break;
			case "별표":
				makeAdmrulAttc(node, child);
				break;
			case "개정문":
				makeAdmrulReviCnt(node, child);
				break;
			case "제개정이유":
				makeAdmrulReviRsn(node, child);
				break;
			case "첨부파일":
				makeAdmrulFile(node, child);
				break;
			default:
			}
		}

		return child;
	}

	private void makeAdmrulFile(Node root, Admrul child) {
		NodeList nodes = root.getChildNodes();

		AdmrulFile vo = null;
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println(" " + (i + 1) + ") " + node.getNodeName());
			switch (node.getNodeName()) {
			case "첨부파일명":
				if (vo != null) {
					child.getAdmrulFiles().add(vo);
				}
				vo = new AdmrulFile();
				vo.setAdmrulSn(child.getAdmrulSn());
				vo.setAttcKey(i);
				vo.setAttcNm(value);
				break;
			case "첨부파일링크":
				vo.setAttcLnk(value);
				break;
			default:
			}
		}
		if (vo != null) {
			child.getAdmrulFiles().add(vo);
		}
	}

	private void makeAdmrulReviRsn(Node root, Admrul child) {
		NodeList nodes = root.getChildNodes();

		AdmrulReviRsn vo = new AdmrulReviRsn();
		vo.setAdmrulSn(child.getAdmrulSn());
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

		child.setAdmrulReviRsn(vo);
	}

	private void makeAdmrulReviCnt(Node root, Admrul child) {
		NodeList nodes = root.getChildNodes();

		AdmrulReviCnt vo = new AdmrulReviCnt();
		vo.setAdmrulSn(child.getAdmrulSn());
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

		child.setAdmrulReviCnt(vo);
	}

	private void makeAdmrulAttc(Node root, Admrul child) {
		NodeList nodes = root.getChildNodes();

		for (int i = 0, j = 1; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
//			System.out.println(" " + (i + 1) + ") " + node.getNodeName());
			switch (node.getNodeName()) {
			case "별표단위":
				child.getAdmrulAttcs().add(getAdmrulAttc(node, child, j++));
				break;
			default:
			}
		}
	}

	private AdmrulAttc getAdmrulAttc(Node root, Admrul child, int key) {
		NodeList nodes = root.getChildNodes();

		AdmrulAttc vo = new AdmrulAttc();
		vo.setAdmrulSn(child.getAdmrulSn());
		vo.setAttcKey(key);
		vo.setAttcKey2(root.getAttributes().item(0).getFirstChild().getNodeValue());
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
			case "별표서식파일링크":
				vo.setAttcFileLnk(value);
				break;
			default:
			}
		}

		return vo;
	}

	private void makeAdmrulAdrue(Node root, Admrul child, int key) {
		NodeList nodes = root.getChildNodes();

		AdmrulAdrue vo = new AdmrulAdrue();
		vo.setAdmrulSn(child.getAdmrulSn());
		vo.setAdrueKey(key);
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("  - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "부칙공포일자":
				vo.setAdruePrmgDt(value);
				break;
			case "부칙공포번호":
				vo.setAdruePrmgNo(value);
				break;
			case "부칙내용":
				vo.setAdrueCnt(value);
				break;
			default:
			}
		}

		child.getAdmrulAdrues().add(vo);
	}

	private void makeAdmrulComp(Node root, Admrul child, int key) {
		AdmrulComp vo = new AdmrulComp();
		vo.setAdmrulSn(child.getAdmrulSn());
		vo.setCompKey(key);
		vo.setCompCnt(root.getFirstChild().getNodeValue());
//		System.out.println(root.getFirstChild().getNodeValue());

		child.getAdmrulComps().add(vo);
	}

	private void makeAdmrul(Node root, Admrul child) {
		NodeList nodes = root.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println(" - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "행정규칙일련번호":
				child.setAdmrulSn(value);
				break;
			case "행정규칙명":
				child.setAdmrulNm(value);
				break;
			case "행정규칙종류":
				child.setAdmrulTyp(value);
				break;
			case "행정규칙종류코드":
				child.setAdmrulTypCd(value);
				break;
			case "발령일자":
				child.setGnfdDt(value);
				break;
			case "발령번호":
				child.setGnfdNo(value);
				break;
			case "제개정구분명":
				child.setReviTypNm(value);
				break;
			case "제개정구분코드":
				child.setReviTypCd(value);
				break;
			case "조문형식여부":
				child.setCompTypYn(value);
				break;
			case "행정규칙ID":
				child.setAdmrulId(value);
				break;
			case "소관부처명":
				child.setJrsdMofNm(value);
				break;
			case "소관부처코드":
				child.setJrsdMofCd(value);
				break;
			case "담당부서기관코드":
				child.setChrgMofCd(value);
				break;
			case "담당부서기관명":
				child.setChrgMofNm(value);
				break;
			case "담당자명":
				child.setChrger(value);
				break;
			case "전화번호":
				child.setTelno(value);
				break;
			case "현행여부":
				child.setCurYn(value);
				break;
			case "시행일자":
				child.setCnfdcrDt(value);
				break;
			case "생성일자":
				child.setCreatDt(value);
				break;
			default:
			}
		}
	}

	@Override
	public void insertFullData(ArrayList<Admrul> list) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertData(Admrul child) throws SQLException {
		Connection con = null;

		PreparedStatement psmt = null;
		PreparedStatement psmtAdrue = null;
		PreparedStatement psmtAttc = null;
		PreparedStatement psmtComp = null;
		PreparedStatement psmtFile = null;
		PreparedStatement psmtReviCnt = null;
		PreparedStatement psmtReviRsn = null;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO law_admrul").append("\n");
		sql.append("(admrul_sn, admrul_nm, admrul_typ, admrul_typ_cd, gnfd_dt, gnfd_no" //
				+ ", revi_typ_nm, revi_typ_cd, comp_typ_yn, admrul_id, jrsd_mof_Nm" //
				+ ", jrsd_mof_Cd, chrg_mof_Cd, chrg_mof_Nm, chrger, telno, cur_yn" //
				+ ", cnfdcr_dt, creat_dt)").append("\n");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		StringBuilder sqlAdrue = new StringBuilder();
		sqlAdrue.append("INSERT INTO law_admrul_adrue").append("\n");
		sqlAdrue.append("(admrul_sn, adrue_key, adrue_prmg_no, adrue_prmg_dt, adrue_cnt)").append("\n");
		sqlAdrue.append("VALUES(?, ?, ?, ?, ?)");
		
		StringBuilder sqlAttc = new StringBuilder();
		sqlAttc.append("INSERT INTO law_admrul_attc").append("\n");
		sqlAttc.append("(admrul_sn, attc_key, attc_key2, attc_no, attc_brnc_no, attc_typ, attc_nm, attc_file_lnk)").append("\n");
		sqlAttc.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
		
		StringBuilder sqlComp = new StringBuilder();
		sqlComp.append("INSERT INTO law_admrul_comp").append("\n");
		sqlComp.append("(admrul_sn, comp_key, comp_cnt)").append("\n");
		sqlComp.append("VALUES(?, ?, ?)");
		
		StringBuilder sqlFile = new StringBuilder();
		sqlFile.append("INSERT INTO law_admrul_file").append("\n");
		sqlFile.append("(admrul_sn, attc_key, attc_nm, attc_lnk)").append("\n");
		sqlFile.append("VALUES(?, ?, ?, ?)");
		
		StringBuilder sqlReviCnt = new StringBuilder();
		sqlReviCnt.append("INSERT INTO law_admrul_revi_cnt").append("\n");
		sqlReviCnt.append("(admrul_sn, revi_typ_cnt)").append("\n");
		sqlReviCnt.append("VALUES(?, ?)");
		
		StringBuilder sqlReviRsn = new StringBuilder();
		sqlReviRsn.append("INSERT INTO law_admrul_revi_rsn").append("\n");
		sqlReviRsn.append("(admrul_sn, revi_typ_rsn)").append("\n");
		sqlReviRsn.append("VALUES(?, ?)");

		int no;
		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());
			psmtAdrue = con.prepareStatement(sqlAdrue.toString());
			psmtAttc = con.prepareStatement(sqlAttc.toString());
			psmtComp = con.prepareStatement(sqlComp.toString());
			psmtFile = con.prepareStatement(sqlFile.toString());
			psmtReviCnt = con.prepareStatement(sqlReviCnt.toString());
			psmtReviRsn = con.prepareStatement(sqlReviRsn.toString());

			no = 1;
			psmt.setString(no++, child.getAdmrulSn());
			psmt.setString(no++, child.getAdmrulNm());
			psmt.setString(no++, child.getAdmrulTyp());
			psmt.setString(no++, child.getAdmrulTypCd());
			psmt.setString(no++, child.getGnfdDt());
			psmt.setString(no++, child.getGnfdNo());
			psmt.setString(no++, child.getReviTypNm());
			psmt.setString(no++, child.getReviTypCd());
			psmt.setString(no++, child.getCompTypYn());
			psmt.setString(no++, child.getAdmrulId());
			psmt.setString(no++, child.getJrsdMofNm());
			psmt.setString(no++, child.getJrsdMofCd());
			psmt.setString(no++, child.getChrgMofCd());
			psmt.setString(no++, child.getChrgMofNm());
			psmt.setString(no++, child.getChrger());
			psmt.setString(no++, child.getTelno());
			psmt.setString(no++, child.getCurYn());
			psmt.setString(no++, child.getCnfdcrDt());
			psmt.setString(no++, child.getCreatDt());

			psmt.executeUpdate();

			ArrayList<AdmrulAdrue> adrues = child.getAdmrulAdrues();
			for (AdmrulAdrue adrue : adrues) {
				no = 1;
				psmtAdrue.setString(no++, adrue.getAdmrulSn());
				psmtAdrue.setInt(no++, adrue.getAdrueKey());
				psmtAdrue.setString(no++, adrue.getAdruePrmgNo());
				psmtAdrue.setString(no++, adrue.getAdruePrmgDt());
				psmtAdrue.setString(no++, adrue.getAdrueCnt());
				
				psmtAdrue.executeUpdate();
			}

			ArrayList<AdmrulAttc> attcs = child.getAdmrulAttcs();
			for (AdmrulAttc attc : attcs) {
				no = 1;
				psmtAttc.setString(no++, attc.getAdmrulSn());
				psmtAttc.setInt(no++, attc.getAttcKey());
				psmtAttc.setString(no++, attc.getAttcKey2());
				psmtAttc.setString(no++, attc.getAttcNo());
				psmtAttc.setString(no++, attc.getAttcBrncNo());
				psmtAttc.setString(no++, attc.getAttcTyp());
				psmtAttc.setString(no++, attc.getAttcNm());
				psmtAttc.setString(no++, attc.getAttcFileLnk());
				
				psmtAttc.executeUpdate();
			}

			ArrayList<AdmrulComp> comps = child.getAdmrulComps();
			for (AdmrulComp comp : comps) {
				no = 1;
				psmtComp.setString(no++, comp.getAdmrulSn());
				psmtComp.setInt(no++, comp.getCompKey());
				psmtComp.setString(no++, comp.getCompCnt());
				
				psmtComp.executeUpdate();
			}

			ArrayList<AdmrulFile> files = child.getAdmrulFiles();
			for (AdmrulFile file : files) {
				no = 1;
				psmtFile.setString(no++, file.getAdmrulSn());
				psmtFile.setInt(no++, file.getAttcKey());
				psmtFile.setString(no++, file.getAttcNm());
				psmtFile.setString(no++, file.getAttcLnk());
				
				psmtFile.executeUpdate();
			}

			AdmrulReviCnt reviCnt = child.getAdmrulReviCnt();
			if (reviCnt != null) {
				no = 1;
				psmtReviCnt.setString(no++, reviCnt.getAdmrulSn());
				psmtReviCnt.setString(no++, reviCnt.getReviTypCnt());
				
				psmtReviCnt.executeUpdate();
			}

			AdmrulReviRsn reviRsn = child.getAdmrulReviRsn();
			if (reviRsn != null) {
				no = 1;
				psmtReviRsn.setString(no++, reviRsn.getAdmrulSn());
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
				psmtFile.close();
				psmtReviCnt.close();
				psmtReviRsn.close();
			} catch (SQLException e) {
				throw e;
			}
			DataSource.returnConnection(con);
		}
	}

}
