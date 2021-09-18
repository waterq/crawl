/**
 * 
 */
package ci.dmz.crawl.law;

import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * @author 이동훈
 *
 */
public class LawCrawler {

	/**
	 * @param args
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, SQLException {
		LawCrawler lawCrawler = new LawCrawler();

		if (args.length != 0 && args[0].equals(null)) {
			// 부분 적재
			lawCrawler.runPartialCrawl();
		} else {
			// 일괄 적재
			lawCrawler.runFullCrawl();
		}
	}

	private void runFullCrawl() throws ParserConfigurationException, SAXException, SQLException {
		// 판례 목록 수집
//		LawSearchPrec searchPrec = new LawSearchPrec();
//		searchPrec.crawlFull(false);

		// 판례 본문 수집
//		LawServicePrec servicePrec = new LawServicePrec();
//		servicePrec.crawlFull(false);

		// 현행 법령 목록 수집
//		LawSearchLaword searchLaword = new LawSearchLaword();
//		searchLaword.crawlFull(false);

		// 현행 법령 본문 수집
//		LawServiceLaword serviceLaword = new LawServiceLaword();
//		serviceLaword.crawlFull(false);

		// 행정 규칙 목록 수집
//		LawSearchAdmrul searchAdmnul = new LawSearchAdmrul();
//		searchAdmnul.crawlFull(false);

		// 행정 규칙 본문 수집
//		LawServiceAdmrul serviceAdmrul = new LawServiceAdmrul();
//		serviceAdmrul.crawlFull(false);

		// 조약 목록
//		LawSearchTrty searchTrty = new LawSearchTrty();
//		searchTrty.crawlFull(false);

		// 조약 본문
//		LawServiceTrty serviceTrty = new LawServiceTrty();
//		serviceTrty.crawlFull(true);
	}

	private void runPartialCrawl() {
		// 판례 목록 수집
	}

}
