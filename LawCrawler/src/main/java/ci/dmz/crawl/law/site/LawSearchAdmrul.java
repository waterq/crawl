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
import ci.dmz.crawl.law.vo.AdmrulLst;
import ci.dmz.crawl.util.DataSource;

/**
 * @author 이동훈
 *
 */
public class LawSearchAdmrul implements LawSearch<AdmrulLst> {

	private String url;

	private String target = "admrul";

	public LawSearchAdmrul() {
		this.url = new LawParam().getUrlSearch(target);
	}

	@Override
	public void crawlPartial(boolean isDelete) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void crawlFull(boolean isDelete) throws ParserConfigurationException, SAXException, SQLException {
		System.out.println("행정규칙목록 - 시작");

		// 건수 체크
		System.out.println("행정규칙목록 - 데이터 삭제 시작");
		int totalCnt = LawUtil.getTotalCnt(url + "1");

		// 데이터 삭제
		if (isDelete && totalCnt > 0) {
			clearFullData();
		}

		// 데이터 삽입
		System.out.println("행정규칙목록 - 데이터 읽기 시작");
		System.out.println(url + totalCnt);
		
		Document document = LawUtil.loadXML(url + totalCnt);
		System.out.println("행정규칙목록 - 데이터 생성 시작 : " + totalCnt);
		ArrayList<AdmrulLst> list = createData(document);
		System.out.println("행정규칙목록 - 데이터 삽입 시작");
		insertFullData(list);

		System.out.println("행정규칙목록 - 종료");
	}

	@Override
	public void clearFullData() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("TRUNCATE TABLE law_admrul_lst");

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
	public void insertFullData(ArrayList<AdmrulLst> list) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO law_admrul_lst").append("\n");
		sql.append("(admrul_sn, admrul_nm, admrul_typ_nm, gnfd_dt, gnfd_no, jrsd_mof_Nm" //
				+ ", cur_hist_typ, revi_typ_cd, revi_typ_nm, admrul_id, admrul_lnk" //
				+ ", cnfdcr_dt, creat_dt)").append("\n");
		sql.append("VALUES").append("\n");
		sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		try {
			con = DataSource.getConnection();
			psmt = con.prepareStatement(sql.toString());

			int no, i = 1, j = 1, dump = 100;
			for (AdmrulLst vo : list) {
				no = 1;
				psmt.setString(no++, vo.getAdmrulSn());
				psmt.setString(no++, vo.getAdmrulNm());
				psmt.setString(no++, vo.getAdmrulTypNm());
				psmt.setString(no++, vo.getGnfdDt());
				psmt.setString(no++, vo.getGnfdNo());
				psmt.setString(no++, vo.getJrsdMofNm());
				psmt.setString(no++, vo.getCurHistTyp());
				psmt.setString(no++, vo.getReviTypCd());
				psmt.setString(no++, vo.getReviTypNm());
				psmt.setString(no++, vo.getAdmrulId());
				psmt.setString(no++, vo.getAdmrulLnk());
				psmt.setString(no++, vo.getCnfdcrDt());
				psmt.setString(no++, vo.getCreatDt());

				psmt.addBatch();
				psmt.clearParameters();

				if (i == dump) {
					psmt.executeBatch();
					System.out.println("행정규칙목록 - 데이터 삽입 진행(" + (j++ * dump) + "건)");
					i = 1;
				} else {
					i++;
				}
			}
			psmt.executeBatch();
			System.out.println("행정규칙목록 - 데이터 삽입 진행(" + ((j - 1) * dump + (i - 1)) + "건)");

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
	public ArrayList<AdmrulLst> createData(Document document) {
		Element root = document.getDocumentElement();
		NodeList nodes = root.getChildNodes();

		// 행정규칙 목록
		ArrayList<AdmrulLst> lists = new ArrayList<AdmrulLst>();

		String sNodeName = target;
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE && sNodeName.equals(node.getNodeName())) {
				AdmrulLst list = createVO(node);
				lists.add(list);
			}
		}

		return lists;
	}

	@Override
	public AdmrulLst createVO(Node node) {
		Element element = (Element) node;

		AdmrulLst vo = new AdmrulLst();
		vo.setAdmrulSn(element.getElementsByTagName("행정규칙일련번호").item(0).getTextContent());
		vo.setAdmrulNm(element.getElementsByTagName("행정규칙명").item(0).getTextContent());
		vo.setAdmrulTypNm(element.getElementsByTagName("행정규칙종류").item(0).getTextContent());
		vo.setGnfdDt(element.getElementsByTagName("발령일자").item(0).getTextContent());
		vo.setGnfdNo(element.getElementsByTagName("발령번호").item(0).getTextContent());
		vo.setJrsdMofNm(element.getElementsByTagName("소관부처명").item(0).getTextContent());
		vo.setCurHistTyp(element.getElementsByTagName("현행연혁구분").item(0).getTextContent());
		vo.setReviTypCd(element.getElementsByTagName("제개정구분코드").item(0).getTextContent());
		vo.setReviTypNm(element.getElementsByTagName("제개정구분명").item(0).getTextContent());
		vo.setAdmrulId(element.getElementsByTagName("행정규칙ID").item(0).getTextContent());
		vo.setAdmrulLnk(element.getElementsByTagName("행정규칙상세링크").item(0).getTextContent());
		vo.setCnfdcrDt(element.getElementsByTagName("시행일자").item(0).getTextContent());
		vo.setCreatDt(element.getElementsByTagName("생성일자").item(0).getTextContent());

		return vo;
	}

}
