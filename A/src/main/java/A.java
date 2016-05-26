import java.io.IOException;
import java.math.BigDecimal;
import java.net.Socket;
import java.net.URL;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class A {

		/*
	 * este metodo comprueba si la fecha es una semana anterior a la fecha
	 * actual
	 */
	public boolean dateGreaterThanAWeek(Date dateToCheck) {
		if (dateToCheck == null) {
			throw new IllegalArgumentException("The date passed to check is null");
		}
		long millisInAWeek = 1000 * 60 * 60 * 24 * 7;
		Date aWeekago = new Date(new Date().getTime() - millisInAWeek);
		if (dateToCheck.before(aWeekago)) {
			return true;
		}
		return false;
	}

	/*
	 * Este mmetodo comprueba dos fechas, si la fecha before es anterior a la
	 * fecha after devuelve true, sino, se lanza una excepción
	 * 
	 */
	public boolean dateBigIsGreaterThanSmall(Date dateBefore, Date dateAfter) {
		if (dateBefore.before(dateAfter)) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	/*
	 * este metodo devuelve el resto de la accion de dividir value entre number
	 */
	public static BigDecimal valueIsDivisibleByNumber(BigDecimal value, BigDecimal number) {
		return value.remainder(number);
	}

	public boolean isAutoIncrement(Connection con) throws SQLException {
		DatabaseMetaData metadata = con.getMetaData();
		ResultSet resultSet = metadata.getIndexInfo("", "", "", true, false);
		return resultSet.getMetaData().isAutoIncrement(0);
	}


	public int createSocket(HttpsURLConnection connection) throws IOException {
		SSLSocketFactory sslFactory = connection.getSSLSocketFactory();
		Socket createSocket = sslFactory.createSocket("localhost", 8080);
		return createSocket.getPort();
	}

	

}