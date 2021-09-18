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
import ci.dmz.crawl.law.vo.Trty;
import ci.dmz.crawl.law.vo.TrtyAppnd;
import ci.dmz.crawl.law.vo.TrtyAttc;
import ci.dmz.crawl.law.vo.TrtyCnt;
import ci.dmz.crawl.law.vo.TrtyLst;
import ci.dmz.crawl.util.DataSource;

/**
 * @author 이동훈 조약 본문
 */
public class LawServiceTrty implements LawService<TrtyLst, Trty> {

	private String url;

	public LawServiceTrty() {
		this.url = new LawParam().getUrlService("trty");
	}

	@Override
	public void crawlPartial(boolean isDelete) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void crawlFull(boolean isDelete) throws ParserConfigurationException, SAXException, SQLException {
		System.out.println("조약본문 - 시작");

		// 데이터 삭제
		if (isDelete) {
			clearFullData();
		}

		// 데이터 삽입
		ArrayList<TrtyLst> listParent = getParentList();
		System.out.println("조약본문 - 데이터 생성 시작 : " + listParent.size());

		int i = 1;
		for (TrtyLst parent : listParent) {
			Trty child = crawlChildData(parent);
			System.out.println("조약본문 - 데이터 삽입 진행(" + i++ + "건)");
			insertData(child);
		}
		System.out.println("조약본문 - 종료");
	}

	@Override
	public void clearFullData() throws SQLException {
		Connection con = null;
		PreparedStatement psmtAttc = null;
		PreparedStatement psmtCnt = null;
		PreparedStatement psmtAppnd = null;
		PreparedStatement psmt = null;

		String sql;

		try {
			con = DataSource.getConnection();

			sql = "TRUNCATE TABLE law_trty_attc";
			psmtAttc = con.prepareStatement(sql.toString());
			psmtAttc.executeUpdate();

			sql = "TRUNCATE TABLE law_trty_cnt";
			psmtCnt = con.prepareStatement(sql.toString());
			psmtCnt.executeUpdate();

			sql = "TRUNCATE TABLE law_trty_appnd";
			psmtAppnd = con.prepareStatement(sql.toString());
			psmtAppnd.executeUpdate();

			sql = "TRUNCATE TABLE law_trty";
			psmt = con.prepareStatement(sql.toString());
			psmt.executeUpdate();

			con.commit();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw e1;
		} finally {
			try {
				psmtAttc.close();
				psmtCnt.close();
				psmtAppnd.close();
				psmt.close();
			} catch (SQLException e) {
				throw e;
			}
			DataSource.returnConnection(con);
		}
	}

	@Override
	public ArrayList<TrtyLst> getParentList() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();
//		sql.append("select * from trty_lst order by trty_sn desc limit 10");
//		sql.append("select * from trty_lst where trty_sn in ('009599')");
//		sql.append("select * from trty_lst where trty_sn in ('013470')");
//		sql.append("select * from trty_lst where trty_sn in ('001444', '006540')");
		sql.append("" //
				+ "SELECT * " //
				+ "  FROM law_trty_lst a " //
				+ " WHERE NOT EXISTS ( SELECT * " //
				+ "                      FROM law_trty b " //
				+ "                     WHERE a.trty_sn = b.trty_sn )" //
				+ " order by efft_dt asc"); //

		ArrayList<TrtyLst> list = new ArrayList<TrtyLst>();
		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());
			rs = psmt.executeQuery();

			String key;
			while (rs.next()) {
				key = rs.getString("trty_sn");

				TrtyLst vo = new TrtyLst();
				vo.setTrtySn(key);

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
	public Trty crawlChildData(TrtyLst parent) throws ParserConfigurationException, SAXException {
		System.out.println(url + parent.getTrtySn());
		Document document = LawUtil.loadXML(url + parent.getTrtySn());
//		Document document = LawUtil.loadXML(url + "009599");
//		Document document = LawUtil.loadXML("./sample/law.xml");
		Element root = document.getDocumentElement();
		NodeList nodes = root.getChildNodes();

		Trty child = new Trty();
		for (int i = 0, j = 1, k = 1, l = 1; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
//			System.out.println((i + 1) + ". " + node.getNodeName());
			switch (node.getNodeName()) {
			case "조약기본정보":
				makeTrty(node, child);
				break;
			case "추가정보":
				makeTrtyAppnd(node, child, j++);
				break;
			case "조약내용":
				makeTrtyCnt(node, child, k++);
				break;
			case "첨부파일":
				makeTrtyFile(node, child, l++);
				break;
			default:
			}
		}

		return child;
	}

	private void makeTrtyFile(Node root, Trty child, int key) {
		NodeList nodes = root.getChildNodes();

		TrtyAttc vo = new TrtyAttc();
		vo.setTrtySn(child.getTrtySn());
		vo.setAttcKey(key);
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("  - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "첨부파일명":
				vo.setAttcNm(value);
				break;
			case "첨부파일링크":
				vo.setAttcLnk(value);
				break;
			default:
			}
		}

		child.getTrtyAttcs().add(vo);
	}

	private void makeTrtyCnt(Node root, Trty child, int key) {
		NodeList nodes = root.getChildNodes();

		TrtyCnt vo = new TrtyCnt();
		vo.setTrtySn(child.getTrtySn());
		vo.setCntKey(key);
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("  - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "조약내용":
				vo.setTrtyCnt(value);
				break;
			default:
			}
		}

		child.getTrtyCnts().add(vo);
	}

	private void makeTrtyAppnd(Node root, Trty child, int key) {
		NodeList nodes = root.getChildNodes();

		TrtyAppnd vo = new TrtyAppnd();
		vo.setTrtySn(child.getTrtySn());
		vo.setAppndKey(key);
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println("  - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "체결대상국가":
				vo.setCnclsNatn(value);
				break;
			case "체결대상국가한글":
				vo.setCnclsNatnKr(value);
				break;
			case "우리측국내절차완료통보":
				vo.setComptDspthInDt(value);
				break;
			case "상대국측국내절차완료통보":
				vo.setComptDspthOutDt(value);
				break;
			case "양자조약분야코드":
				vo.setTrtyCd(value);
				break;
			case "양자조약분야명":
				vo.setTrtyNm(value);
				break;
			case "제2외국어종류":
				vo.setLangTyp(value);
				break;
			case "국가코드":
				vo.setNatnCd(value);
				break;
			default:
			}
		}

		child.getTrtyAppnds().add(vo);
	}

	private void makeTrty(Node root, Trty child) {
		NodeList nodes = root.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeName().equals("#text")) {
				continue;
			}
			String value = LawUtil.extractText(node);
//			System.out.println(" - " + node.getNodeName() + " : " + value);
			switch (node.getNodeName()) {
			case "조약일련번호":
				child.setTrtySn(value);
				break;
			case "조약명_한글":
				child.setTrtyNm(value);
				break;
			case "조약명_영문":
				child.setTrtyNmEn(value);
				break;
			case "조약구분코드":
				child.setTrtyTypCd(value);
				break;
			case "대통령재가일자":
				child.setPrsdtApprDt(value);
				break;
			case "발효일자":
				child.setEfftDt(value);
				break;
			case "조약번호":
				child.setTrtyNo(value);
				break;
			case "관보게재일자":
				child.setOfcttOpnDt(value);
				break;
			case "국무회의심의일자":
				child.setNatnDlbrtDt(value);
				break;
			case "국무회의심의회차":
				child.setNatnDlbrtNo(value);
				break;
			case "국회비준동의여부":
				child.setAsmbAgrYn(value);
				break;
			case "국회비준동의일자":
				child.setAsmbAgrDt(value);
				break;
			case "서명일자":
				child.setSignDt(value);
				break;
			case "서명장소":
				child.setSignPlc(value);
				break;
			case "비고":
				child.setRmk(value);
				break;
			default:
			}
		}
	}

	@Override
	public void insertFullData(ArrayList<Trty> list) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertData(Trty child) throws SQLException {
		Connection con = null;

		PreparedStatement psmt = null;
		PreparedStatement psmtAppnd = null;
		PreparedStatement psmtCnt = null;
		PreparedStatement psmtAttc = null;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO law_trty").append("\n");
		sql.append("(trty_sn, trty_nm, trty_nm_en, trty_typ_cd, prsdt_appr_dt, efft_dt" //
				+ ", trty_no, ofctt_opn_dt, natn_dlbrt_dt, natn_dlbrt_no, asmb_agr_yn" //
				+ ", asmb_agr_dt, sign_dt, sign_plc, rmk)").append("\n");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		StringBuilder sqlAppnd = new StringBuilder();
		sqlAppnd.append("INSERT INTO law_trty_appnd").append("\n");
		sqlAppnd.append("(trty_sn, appnd_key, cncls_natn, cncls_natn_kr, compt_dspth_in_dt" //
				+ ", compt_dspth_out_dt, trty_cd, trty_nm, lang_typ, natn_cd)").append("\n");
		sqlAppnd.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		StringBuilder sqlCnt = new StringBuilder();
		sqlCnt.append("INSERT INTO law_trty_cnt").append("\n");
		sqlCnt.append("(trty_sn, cnt_key, trty_cnt)").append("\n");
		sqlCnt.append("VALUES(?, ?, ?)");

		StringBuilder sqlAttc = new StringBuilder();
		sqlAttc.append("INSERT INTO law_trty_attc").append("\n");
		sqlAttc.append("(trty_sn, attc_key, attc_nm, attc_lnk)").append("\n");
		sqlAttc.append("VALUES(?, ?, ?, ?)");

		int no = 1;
		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());
			psmtAppnd = con.prepareStatement(sqlAppnd.toString());
			psmtCnt = con.prepareStatement(sqlCnt.toString());
			psmtAttc = con.prepareStatement(sqlAttc.toString());

			no = 1;
			psmt.setString(no++, child.getTrtySn());
			psmt.setString(no++, child.getTrtyNm());
			psmt.setString(no++, child.getTrtyNmEn());
			psmt.setString(no++, child.getTrtyTypCd());
			psmt.setString(no++, child.getPrsdtApprDt());
			psmt.setString(no++, child.getEfftDt());
			psmt.setString(no++, child.getTrtyNo());
			psmt.setString(no++, child.getOfcttOpnDt());
			psmt.setString(no++, child.getNatnDlbrtDt());
			psmt.setString(no++, child.getNatnDlbrtNo());
			psmt.setString(no++, child.getAsmbAgrYn());
			psmt.setString(no++, child.getAsmbAgrDt());
			psmt.setString(no++, child.getSignDt());
			psmt.setString(no++, child.getSignPlc());
			psmt.setString(no++, child.getRmk());

			psmt.executeUpdate();

			ArrayList<TrtyAppnd> appnds = child.getTrtyAppnds();
			for (TrtyAppnd appnd : appnds) {
				no = 1;
				psmtAppnd.setString(no++, appnd.getTrtySn());
				psmtAppnd.setInt(no++, appnd.getAppndKey());
				psmtAppnd.setString(no++, appnd.getCnclsNatn());
				psmtAppnd.setString(no++, appnd.getCnclsNatnKr());
				psmtAppnd.setString(no++, appnd.getComptDspthInDt());
				psmtAppnd.setString(no++, appnd.getComptDspthOutDt());
				psmtAppnd.setString(no++, appnd.getTrtyCd());
				psmtAppnd.setString(no++, appnd.getTrtyNm());
				psmtAppnd.setString(no++, appnd.getLangTyp());
				psmtAppnd.setString(no++, appnd.getNatnCd());

				psmtAppnd.executeUpdate();
			}

			ArrayList<TrtyCnt> cnts = child.getTrtyCnts();
			for (TrtyCnt cnt : cnts) {
				no = 1;
				psmtCnt.setString(no++, cnt.getTrtySn());
				psmtCnt.setInt(no++, cnt.getCntKey());
				psmtCnt.setString(no++, cnt.getTrtyCnt());

				psmtCnt.executeUpdate();
			}

			ArrayList<TrtyAttc> attcs = child.getTrtyAttcs();
			for (TrtyAttc attc : attcs) {
				no = 1;
				psmtAttc.setString(no++, attc.getTrtySn());
				psmtAttc.setInt(no++, attc.getAttcKey());
				psmtAttc.setString(no++, attc.getAttcNm());
				psmtAttc.setString(no++, attc.getAttcLnk());

				psmtAttc.executeUpdate();
			}

			con.commit();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw e1;
		} finally {
			try {
				psmt.close();
				psmtAppnd.close();
				psmtCnt.close();
				psmtAttc.close();
			} catch (SQLException e) {
				throw e;
			}
			DataSource.returnConnection(con);
		}
	}

}
