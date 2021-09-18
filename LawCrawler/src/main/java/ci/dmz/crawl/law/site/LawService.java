/**
 * 
 */
package ci.dmz.crawl.law.site;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import ci.dmz.crawl.law.vo.LawVO;

/**
 * @author 이동훈
 *
 */
public interface LawService<P, C extends LawVO> {

	void crawlPartial(boolean isDelete) throws ParserConfigurationException, SAXException;

	void crawlFull(boolean isDelete) throws ParserConfigurationException, SAXException, SQLException;

	void clearFullData() throws SQLException;

	ArrayList<P> getParentList() throws SQLException;

	C crawlChildData(P parent) throws ParserConfigurationException, SAXException;

	void insertFullData(ArrayList<C> list) throws SQLException;

	void insertData(C child) throws SQLException;

}
