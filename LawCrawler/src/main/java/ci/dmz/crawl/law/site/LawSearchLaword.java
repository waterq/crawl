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
import ci.dmz.crawl.law.vo.LawordLst;
import ci.dmz.crawl.util.DataSource;

/**
 * @author 이동훈
 *
 */
public class LawSearchLaword implements LawSearch<LawordLst> {

	private String url;

	private String target = "law";

	public LawSearchLaword() {
		this.url = new LawParam().getUrlSearch(target);
	}

	@Override
	public void crawlPartial(boolean isDelete) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void crawlFull(boolean isDelete) throws ParserConfigurationException, SAXException, SQLException {
		System.out.println("법령목록 - 시작");

		// 건수 체크
		System.out.println("법령목록 - 데이터 삭제 시작");
		int totalCnt = LawUtil.getTotalCnt(url + "1");

		// 데이터 삭제
		if (isDelete && totalCnt > 0) {
			clearFullData();
		}

		// 데이터 삽입
		System.out.println("법령목록 - 데이터 읽기 시작");
		System.out.println(url + totalCnt);
		Document document = LawUtil.loadXML(url + totalCnt);
		System.out.println("법령목록 - 데이터 생성 시작 : " + totalCnt);
		ArrayList<LawordLst> list = createData(document);
		System.out.println("법령목록 - 데이터 삽입 시작");
		insertFullData(list);

		System.out.println("법령목록 - 종료");
	}

	@Override
	public void clearFullData() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("TRUNCATE TABLE laword_lst");

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
	public void insertFullData(ArrayList<LawordLst> list) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO law_laword_lst").append("\n");
		sql.append("(laword_sn, cur_hist_cd, laword_nm, laword_abrv, laword_id, "
				+ "prmg_dt, prmg_no, revi_typ_nm, jrsd_mof_nm, jrsd_mof_cd, "
				+ "laword_typ_nm, cnfdcr_dt, self_yn, laword_Lnk)").append("\n");
		sql.append("VALUES").append("\n");
		sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)").append("\n");

		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());

			int no, i = 1, j = 1, dump = 100;
			for (LawordLst vo : list) {
				no = 1;
				psmt.setString(no++, vo.getLawordSn());
				psmt.setString(no++, vo.getCurHistCd());
				psmt.setString(no++, vo.getLawordNm());
				psmt.setString(no++, vo.getLawordAbrv());
				psmt.setString(no++, vo.getLawordId());
				psmt.setString(no++, vo.getPrmgDt());
				psmt.setString(no++, vo.getPrmgNo());
				psmt.setString(no++, vo.getReviTypNm());
				psmt.setString(no++, vo.getJrsdMofNm());
				psmt.setString(no++, vo.getJrsdMofCd());
				psmt.setString(no++, vo.getLawordTypNm());
				psmt.setString(no++, vo.getCnfdcrDt());
				psmt.setString(no++, vo.getSelfYn());
				psmt.setString(no++, vo.getLawordLnk());

				psmt.addBatch();
				psmt.clearParameters();

				if (i == dump) {
					psmt.executeBatch();
					System.out.println("법령목록 - 데이터 삽입 진행(" + (j++ * dump) + "건)");
					i = 1;
				} else {
					i++;
				}
			}
			psmt.executeBatch();
			System.out.println("법령목록 - 데이터 삽입 진행(" + ((j - 1) * dump + (i - 1)) + "건)");

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
	public ArrayList<LawordLst> createData(Document document) {
		Element root = document.getDocumentElement();
		NodeList nodes = root.getChildNodes();

		// 법령 목록
		ArrayList<LawordLst> lists = new ArrayList<LawordLst>();

		String sNodeName = target;
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE && sNodeName.equals(node.getNodeName())) {
				LawordLst list = createVO(node);
				lists.add(list);
			}
		}

		return lists;
	}

	@Override
	public LawordLst createVO(Node node) {
		Element element = (Element) node;

		LawordLst vo = new LawordLst();
		vo.setLawordSn(element.getElementsByTagName("법령일련번호").item(0).getTextContent());
		vo.setCurHistCd(element.getElementsByTagName("현행연혁코드").item(0).getTextContent());
		vo.setLawordNm(element.getElementsByTagName("법령명한글").item(0).getTextContent());
		vo.setLawordAbrv(element.getElementsByTagName("법령약칭명").item(0).getTextContent());
		vo.setLawordId(element.getElementsByTagName("법령ID").item(0).getTextContent());
		vo.setPrmgDt(element.getElementsByTagName("공포일자").item(0).getTextContent());
		vo.setPrmgNo(element.getElementsByTagName("공포번호").item(0).getTextContent());
		vo.setReviTypNm(element.getElementsByTagName("제개정구분명").item(0).getTextContent());
		vo.setJrsdMofNm(element.getElementsByTagName("소관부처명").item(0).getTextContent());
		vo.setJrsdMofCd(element.getElementsByTagName("소관부처코드").item(0).getTextContent());
		vo.setLawordTypNm(element.getElementsByTagName("법령구분명").item(0).getTextContent());
		vo.setCnfdcrDt(element.getElementsByTagName("시행일자").item(0).getTextContent());
		vo.setSelfYn(element.getElementsByTagName("자법타법여부").item(0).getTextContent());
		vo.setLawordLnk(element.getElementsByTagName("법령상세링크").item(0).getTextContent());

		return vo;
	}

}
