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
import ci.dmz.crawl.law.vo.PrcdntLst;
import ci.dmz.crawl.law.vo.Prcdnt;
import ci.dmz.crawl.util.DataSource;

/**
 * @author 이동훈
 *
 */
public class LawServicePrec implements LawService<PrcdntLst, Prcdnt> {

	private String url;

	public LawServicePrec() {
		this.url = new LawParam().getUrlService("prec");
	}

	@Override
	public void crawlPartial(boolean isDelete) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void crawlFull(boolean isDelete) throws ParserConfigurationException, SAXException, SQLException {
		System.out.println("판례본문 - 시작");

		// 데이터 삭제
		if (isDelete) {
			clearFullData();
		}

		// 데이터 삽입
		ArrayList<PrcdntLst> listParent = getParentList();
		System.out.println("판례목록 - 데이터 생성 시작 : " + listParent.size());

		ArrayList<Prcdnt> listChild = new ArrayList<Prcdnt>();
		final int dump = 100;
		int i = 1, j = 1;
		for (PrcdntLst parent : listParent) {
			listChild.add(crawlChildData(parent));
			if (i == dump) {
				insertFullData(listChild);
				System.out.println("판례본문 - 데이터 삽입 진행(" + (j++ * dump) + "건)");

				listChild.clear();
				i = 1;
			} else {
				i++;
			}
		}
		insertFullData(listChild);
		System.out.println("판례본문 - 데이터 삽입 : " + listParent.size());

		System.out.println("판례본문 - 종료");

	}

	@Override
	public void clearFullData() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("TRUNCATE TABLE prcdnt");

		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());
			psmt.executeUpdate();

			con.commit();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw e1;
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				throw e;
			}
			DataSource.returnConnection(con);
		}
	}

	@Override
	public ArrayList<PrcdntLst> getParentList() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();
//		sql.append("select * from law_prcdnt_lst where prcdnt_sn = '109427'");
//		sql.append("select * from law_prcdnt_lst order by adju_dt asc");
//		sql.append("select * from law_prcdnt_lst order by prcdnt_sn desc limit 555");
		sql.append("" //
				+ "SELECT * " //
				+ "  FROM law_prcdnt_lst a " //
				+ " WHERE NOT EXISTS ( SELECT * " //
				+ "                      FROM law_prcdnt b " //
				+ "                     WHERE a.prcdnt_sn = b.prcdnt_sn )" //
				+ " order by adju_dt asc"); //

		ArrayList<PrcdntLst> list = new ArrayList<PrcdntLst>();
		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());
			rs = psmt.executeQuery();

			String key;
			while (rs.next()) {
				key = rs.getString("prcdnt_sn");

				PrcdntLst vo = new PrcdntLst();
				vo.setPrcdntSn(key);

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
	public Prcdnt crawlChildData(PrcdntLst parent) throws ParserConfigurationException, SAXException {
		System.out.println(url + parent.getPrcdntSn());
		Document document = LawUtil.loadXML(url + parent.getPrcdntSn());
		Element root = document.getDocumentElement();
		NodeList nodes = root.getChildNodes();

		Prcdnt child = new Prcdnt();
		child.setPrcdntSn(parent.getPrcdntSn());
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			Node firstChild = node.getFirstChild();
			if (firstChild == null) {
				continue;
			}
			String value = LawUtil.replaceText(firstChild.getNodeValue());

			switch (node.getNodeName()) {
			case "사건번호":
				child.setIncdntNo(value);
				break;
			case "사건명":
				child.setIncdntNm(value);
				break;
			case "선고일자":
				child.setAdjuDt(value);
				break;
			case "선고":
				child.setAdju(value);
				break;
			case "법원명":
				child.setCourtNm(value);
				break;
			case "법원종류코드":
				child.setCourtCndCd(value);
				break;
			case "사건종류명":
				child.setIncdntCndNm(value);
				break;
			case "사건종류코드":
				child.setIncdntCndCd(value);
				break;
			case "판시유형":
				child.setJudmnTyp(value);
				break;
			case "판시사항":
				child.setJudmnPn(value);
				break;
			case "판결요지":
				child.setJudmnOl(value);
				break;
			case "참조조문":
				child.setRefDoc(value);
				break;
			case "참조판례":
				child.setRefPrcdnt(value);
				break;
			case "판례내용":
				child.setPrcdntCn(value);
				break;
			default:
			}
		}

		return child;
	}

	@Override
	public void insertFullData(ArrayList<Prcdnt> list) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO law_prcdnt").append("\n");
		sql.append("(prcdnt_sn, incdnt_no, incdnt_nm, adju_dt, adju, court_nm, court_cnd_cd, incdnt_cnd_nm, "
				+ "incdnt_cnd_cd, judmn_typ, judmn_pn, judmn_ol, ref_doc, ref_prcdnt, prcdnt_cn)").append("\n");
		sql.append("VALUES").append("\n");
		sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)").append("\n");

		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());

			int no;
			for (Prcdnt vo : list) {
				no = 1;
				psmt.setString(no++, vo.getPrcdntSn());
				psmt.setString(no++, vo.getIncdntNo());
				psmt.setString(no++, vo.getIncdntNm());
				psmt.setString(no++, vo.getAdjuDt());
				psmt.setString(no++, vo.getAdju());
				psmt.setString(no++, vo.getCourtNm());
				psmt.setString(no++, vo.getCourtCndCd());
				psmt.setString(no++, vo.getIncdntCndNm());
				psmt.setString(no++, vo.getIncdntCndCd());
				psmt.setString(no++, vo.getJudmnTyp());
				psmt.setString(no++, vo.getJudmnPn());
				psmt.setString(no++, vo.getJudmnOl());
				psmt.setString(no++, vo.getRefDoc());
				psmt.setString(no++, vo.getRefPrcdnt());
				psmt.setString(no++, vo.getPrcdntCn());

				psmt.addBatch();
				psmt.clearParameters();
			}
			psmt.executeBatch();

			con.commit();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw e1;
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				throw e;
			}
			DataSource.returnConnection(con);
		}
	}

	@Override
	public void insertData(Prcdnt child) {
		// TODO Auto-generated method stub
		
	}

}
