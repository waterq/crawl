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
import ci.dmz.crawl.law.vo.TrtyLst;
import ci.dmz.crawl.util.DataSource;

/**
 * @author 이동훈
 *
 */
public class LawSearchTrty implements LawSearch<TrtyLst> {

	private String url;

	private String target = "trty";

	public LawSearchTrty() {
		this.url = new LawParam().getUrlSearch(target);
	}

	@Override
	public void crawlPartial(boolean isDelete) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void crawlFull(boolean isDelete) throws ParserConfigurationException, SAXException, SQLException {
		System.out.println("조약목록 - 시작");

		// 건수 체크
		System.out.println("조약목록 - 데이터 삭제 시작");
		int totalCnt = LawUtil.getTotalCnt(url + "1");

		// 데이터 삭제
		if (isDelete && totalCnt > 0) {
			clearFullData();
		}

		// 데이터 삽입
		System.out.println("조약목록 - 데이터 읽기 시작");
		System.out.println(url + totalCnt);
		Document document = LawUtil.loadXML(url + totalCnt);
		System.out.println("조약목록 - 데이터 생성 시작 : " + totalCnt);
		ArrayList<TrtyLst> list = createData(document);
		System.out.println("조약목록 - 데이터 삽입 시작");
		insertFullData(list);

		System.out.println("조약목록 - 종료");
	}

	@Override
	public void clearFullData() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("TRUNCATE TABLE trty_lst");

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
	public void insertFullData(ArrayList<TrtyLst> list) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO law_trty_lst").append("\n");
		sql.append("(trty_sn, trty_nm, trty_typ_cd, trty_typ_nm, efft_dt, sign_dt"
				+ ", ofctt_opn_dt, trty_no, natn_no, trty_lnk)").append("\n");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());

			int no, i = 1, j = 1, dump = 100;
			for (TrtyLst vo : list) {
				no = 1;
				psmt.setString(no++, vo.getTrtySn());
				psmt.setString(no++, vo.getTrtyNm());
				psmt.setString(no++, vo.getTrtyTypCd());
				psmt.setString(no++, vo.getTrtyTypNm());
				psmt.setString(no++, vo.getEfftDt());
				psmt.setString(no++, vo.getSignDt());
				psmt.setString(no++, vo.getOfcttOpnDt());
				psmt.setString(no++, vo.getTrtyNo());
				psmt.setString(no++, vo.getNatnNo());
				psmt.setString(no++, vo.getTrtyLnk());

				psmt.addBatch();
				psmt.clearParameters();

				if (i == dump) {
					psmt.executeBatch();
					System.out.println("조약목록 - 데이터 삽입 진행(" + (j++ * dump) + "건)");
					i = 1;
				} else {
					i++;
				}
			}
			psmt.executeBatch();
			System.out.println("조약목록 - 데이터 삽입 진행(" + ((j - 1) * dump + (i - 1)) + "건)");

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
	public ArrayList<TrtyLst> createData(Document document) {
		Element root = document.getDocumentElement();
		NodeList nodes = root.getChildNodes();

		// 조약 목록
		ArrayList<TrtyLst> lists = new ArrayList<TrtyLst>();

//		String sNodeName = target;
		String sNodeName = "Trty";
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE && sNodeName.equals(node.getNodeName())) {
				TrtyLst list = createVO(node);
				lists.add(list);
			}
		}

		return lists;
	}

	@Override
	public TrtyLst createVO(Node node) {
		Element element = (Element) node;

		TrtyLst vo = new TrtyLst();
		vo.setTrtySn(element.getElementsByTagName("조약일련번호").item(0).getTextContent());
		vo.setTrtyNm(element.getElementsByTagName("조약명").item(0).getTextContent());
		vo.setTrtyTypCd(element.getElementsByTagName("조약구분코드").item(0).getTextContent());
		vo.setTrtyTypNm(element.getElementsByTagName("조약구분명").item(0).getTextContent());
		vo.setEfftDt(element.getElementsByTagName("발효일자").item(0).getTextContent());
		vo.setSignDt(element.getElementsByTagName("서명일자").item(0).getTextContent());
		vo.setOfcttOpnDt(element.getElementsByTagName("관보게제일자").item(0).getTextContent());
		vo.setTrtyNo(element.getElementsByTagName("조약번호").item(0).getTextContent());
		vo.setNatnNo(element.getElementsByTagName("국가번호").item(0).getTextContent());
		vo.setTrtyLnk(element.getElementsByTagName("조약상세링크").item(0).getTextContent());

		return vo;
	}

}
