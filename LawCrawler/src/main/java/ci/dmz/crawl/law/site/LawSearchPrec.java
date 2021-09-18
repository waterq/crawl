/**
 * 
 */
package ci.dmz.crawl.law.site;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import ci.dmz.crawl.util.DataSource;

/**
 * @author 이동훈 판례 목록 수집
 */
public class LawSearchPrec implements LawSearch<PrcdntLst> {

	private String url;

	private String target = "prec";

	public LawSearchPrec() {
		this.url = new LawParam().getUrlSearch(target);
	}

	@Override
	public void crawlPartial(boolean isDelete) throws ParserConfigurationException, SAXException {
	}

	@Override
	public void crawlFull(boolean isDelete) throws ParserConfigurationException, SAXException, SQLException {
		System.out.println("판례목록 - 시작");

		// 건수 체크
		System.out.println("판례목록 - 데이터 삭제 시작");
		int totalCnt = LawUtil.getTotalCnt(url + "1");

		// 데이터 삭제
		if (isDelete && totalCnt > 0) {
			clearFullData();
		}

		// 데이터 삽입
		System.out.println("판례목록 - 데이터 읽기 시작 : " + totalCnt);
//		Document document = LawUtil.loadXML(url + totalCnt);
		Document document = LawUtil.loadXML("./sample/prec.xml");
		System.out.println("판례목록 - 데이터 생성 시작 : " + totalCnt);
		ArrayList<PrcdntLst> list = createData(document);
		System.out.println("판례목록 - 데이터 삽입 시작");
		insertFullData(list);

		System.out.println("판례목록 - 종료");
	}

	@Override
	public void clearFullData() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("TRUNCATE TABLE prcdnt_lst");

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
	public void insertFullData(ArrayList<PrcdntLst> list) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO law_prcdnt_lst").append("\n");
		sql.append("(prcdnt_sn, incdnt_nm, incdnt_no, adju_dt, court_nm, court_cnd_cd, "
				+ "incdnt_cnd_cd, incdnt_cnd_nm, judmn_typ, adju, prcdnt_lnk)").append("\n");
		sql.append("VALUES").append("\n");
		sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)").append("\n");

		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());

			int no, i = 1, j = 1, batchSize = 1000;
			for (PrcdntLst vo : list) {
				no = 1;
				psmt.setString(no++, vo.getPrcdntSn());
				psmt.setString(no++, vo.getIncdntNm());
				psmt.setString(no++, vo.getIncdntNo());
				psmt.setString(no++, vo.getAdjuDt());
				psmt.setString(no++, vo.getCourtNm());
				psmt.setString(no++, vo.getCourtCndCd());
				psmt.setString(no++, vo.getIncdntCndNm());
				psmt.setString(no++, vo.getIncdntCndCd());
				psmt.setString(no++, vo.getJudmnTyp());
				psmt.setString(no++, vo.getAdju());
				psmt.setString(no++, vo.getPrcdntLnk());

				psmt.addBatch();
				psmt.clearParameters();

				if (i == batchSize) {
					psmt.executeBatch();
					System.out.println("판례목록 - 데이터 삽입 진행(" + (j++ * batchSize) + "건)");
					i = 1;
				} else {
					i++;
				}
			}
			psmt.executeBatch();
			System.out.println("법령목록 - 데이터 삽입 진행(" + ((j - 1) * batchSize + (i - 1)) + "건)");

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
	public ArrayList<PrcdntLst> createData(Document document) {
		Element root = document.getDocumentElement();
		NodeList nodes = root.getChildNodes();

		// 판례 목록
		ArrayList<PrcdntLst> list = new ArrayList<PrcdntLst>();

		String sNodeName = target;
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE && sNodeName.equals(node.getNodeName())) {
				PrcdntLst listPrcdnt = createVO(node);
				list.add(listPrcdnt);
			}
		}

		return list;
	}

	@Override
	public PrcdntLst createVO(Node node) {
		Element element = (Element) node;

		PrcdntLst vo = new PrcdntLst();
		vo.setPrcdntSn(LawUtil.replaceText(element.getElementsByTagName("판례일련번호").item(0).getTextContent()));
		vo.setIncdntNm(LawUtil.replaceText(element.getElementsByTagName("사건명").item(0).getTextContent()));
		vo.setIncdntNo(LawUtil.replaceText(element.getElementsByTagName("사건번호").item(0).getTextContent()));
		vo.setAdjuDt(LawUtil.replaceText(element.getElementsByTagName("선고일자").item(0).getTextContent()));
		vo.setCourtNm(LawUtil.replaceText(element.getElementsByTagName("법원명").item(0).getTextContent()));
		vo.setCourtCndCd(LawUtil.replaceText(element.getElementsByTagName("법원종류코드").item(0).getTextContent()));
		vo.setIncdntCndNm(LawUtil.replaceText(element.getElementsByTagName("사건종류명").item(0).getTextContent()));
		vo.setIncdntCndCd(LawUtil.replaceText(element.getElementsByTagName("사건종류코드").item(0).getTextContent()));
		vo.setJudmnTyp(LawUtil.replaceText(element.getElementsByTagName("판결유형").item(0).getTextContent()));
		vo.setAdju(LawUtil.replaceText(element.getElementsByTagName("선고").item(0).getTextContent()));
		vo.setPrcdntLnk(LawUtil.replaceText(element.getElementsByTagName("판례상세링크").item(0).getTextContent()));

		return vo;
	}

}
