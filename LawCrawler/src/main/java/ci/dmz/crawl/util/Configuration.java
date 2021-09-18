/**
 * 
 */
package ci.dmz.crawl.util;

/**
 * @author 이동훈
 *
 */
public class Configuration {

	public String DB_USER_NAME;

	public String DB_PASSWORD;

	public String DB_URL;

	public String DB_DRIVER;

	public Integer DB_MAX_CONNECTIONS;

	public Configuration() {
		init();
	}

	private static Configuration configuration = new Configuration();

	public static Configuration getInstance() {
		return configuration;
	}

	private void init() {
		DB_USER_NAME = "crawl";
		DB_PASSWORD = "crawl";
		DB_URL = "jdbc:mariadb://127.0.0.1:3306/crawldb";
		DB_DRIVER = "org.mariadb.jdbc.Driver";
		DB_MAX_CONNECTIONS = 5;
	}

}
