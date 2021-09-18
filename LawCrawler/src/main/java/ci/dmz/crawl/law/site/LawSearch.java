/**
 * 
 */
package ci.dmz.crawl.law.site;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ci.dmz.crawl.law.vo.LawVO;

/**
 * @author 이동훈
 *
 */
public interface LawSearch<T extends LawVO> {

	void crawlPartial(boolean isDelete) throws ParserConfigurationException, SAXException;

	void crawlFull(boolean isDelete) throws ParserConfigurationException, SAXException, SQLException;

	void clearFullData() throws SQLException;

	void insertFullData(ArrayList<T> list) throws SQLException;

	ArrayList<T> createData(Document document);

	T createVO(Node node);
	
}
