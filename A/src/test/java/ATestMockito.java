import java.io.IOException;
import java.io.Reader;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ATestMockito {

	A a = new A();
	@Mock
	private ResultSet rs;
	@Mock
	private Connection databaseConnection;
	@Mock
	private DatabaseMetaData metadata;
	@Mock
	private HttpsURLConnection urlConnection;
	@Mock
	private SSLSocketFactory sslFactory;
	@Mock
	private Socket createSocket;

	@Test
	public void TestisAutoIncrement() throws SQLException {
			Mockito.when(databaseConnection.getMetaData()).thenReturn(metadata);
			Mockito.when(metadata.getIndexInfo("", "", "", true, false)).thenReturn(rs);
			a.isAutoIncrement(databaseConnection);
	}

	@Test
	public void TestcreateSocket() throws IOException {
		Mockito.when(urlConnection.getSSLSocketFactory()).thenReturn(sslFactory);
		Mockito.when(sslFactory.createSocket("localhost", 8080)).thenReturn(createSocket);
		a.createSocket(urlConnection);
	}

}