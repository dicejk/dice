package dice.sql;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import dice.cipher.Cipher;
import dice.info.DiceServer;

public class DiceDriver implements Driver
{
	private final String PREFIX = "jdbc:dice:";
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String DRIVER_NAME2 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String PREFIX_MS = "jdbc:sqlserver:";
	static
	{
		try
		{
			DriverManager.registerDriver(new DiceDriver());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException
	{
		return url.startsWith(PREFIX);
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException
	{
		if (acceptsURL(url))
		{
			try
			{
				String driver = DRIVER_NAME;
				if(url.startsWith(PREFIX+PREFIX_MS))
				{
					driver = DRIVER_NAME2;
				}
				Class.forName(driver);
				String registryURL = "rmi://localhost:1099/dice";
				DiceServer server = null;
				try
				{
					server = (DiceServer) Naming.lookup(registryURL);
				}
				catch(Exception e)
				{
					server = null;
				}
				
				Properties properties = new Properties();
				BufferedInputStream stream = new BufferedInputStream(new FileInputStream(System.getProperty("user.home")+System.getProperty("file.separator")+"dice.properties"));
				properties.load(stream);
				stream.close();
				String cipherClass = properties.getProperty("dice_cipher_class");
				Class<?> cl = Class.forName(cipherClass);
				@SuppressWarnings("unchecked")
				Class<Properties> [] params = new Class[1];
				params[0] = Properties.class;
				Cipher cipher = (Cipher)cl.getConstructor(params).newInstance(properties);
				//return new DiceConnection(DriverManager.getConnection(
				//		url.substring(PREFIX.length()), info),new CipherTransformer(cipher, server));
				return new DiceConnection(DriverManager.getConnection(
						url.substring(PREFIX.length()), info),new AntlrTransformer(cipher, null));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int getMajorVersion()
	{
		Logger.getLogger("dice:callable").log(Level.INFO, "DRIVER1");
		return 0;
	}

	@Override
	public int getMinorVersion()
	{
		Logger.getLogger("dice:callable").log(Level.INFO, "DRIVER2");
		return 0;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info)
			throws SQLException
	{
		Logger.getLogger("dice:callable").log(Level.INFO, "DRIVER3");
		return null;
	}

	@Override
	public boolean jdbcCompliant()
	{
		Logger.getLogger("dice:callable").log(Level.INFO, "DRIVER4");
		return false;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException
	{
		Logger.getLogger("dice:callable").log(Level.INFO, "DRIVER5");
		return null;
	}

}
