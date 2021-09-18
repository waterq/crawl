/**
 * 
 */
package ci.dmz.crawl.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 이동훈
 *
 */
public class DataSource {
	
	static JdbcConnectionPool pool = new JdbcConnectionPool();

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = pool.getConnectionFromPool();
		return connection;
	}

	public static void returnConnection(Connection connection) {
		pool.returnConnectionToPool(connection);
	}

}
