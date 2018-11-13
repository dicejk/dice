package dice.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiceCallableStatement extends DicePreparedStatement implements
		CallableStatement
{
	private CallableStatement callStatement;
	private DiceConnection connection;

	public DiceCallableStatement(DiceConnection connection,
			CallableStatement statement) {
		super(connection, statement);
		this.callStatement = statement;
		this.connection = connection;
		Logger.getLogger("dice:callable").log(Level.INFO, "constructor");
	}

	@Override
	public Array getArray(int parameterIndex) throws SQLException
	{
		return callStatement.getArray(parameterIndex);
	}

	@Override
	public Array getArray(String parameterName) throws SQLException
	{
		return callStatement.getArray(parameterName);
	}

	@Override
	public BigDecimal getBigDecimal(int parameterIndex) throws SQLException
	{
		return callStatement.getBigDecimal(parameterIndex);
	}

	@Override
	public BigDecimal getBigDecimal(String parameterName) throws SQLException
	{
		return callStatement.getBigDecimal(parameterName);
	}

	@SuppressWarnings("deprecation")
	@Override
	public BigDecimal getBigDecimal(int parameterIndex, int scale)
			throws SQLException
	{
		return callStatement.getBigDecimal(parameterIndex, scale);
	}

	@Override
	public Blob getBlob(int parameterIndex) throws SQLException
	{
		return callStatement.getBlob(parameterIndex);
	}

	@Override
	public Blob getBlob(String parameterName) throws SQLException
	{
		return callStatement.getBlob(parameterName);
	}

	@Override
	public boolean getBoolean(int parameterIndex) throws SQLException
	{
		return callStatement.getBoolean(parameterIndex);
	}

	@Override
	public boolean getBoolean(String parameterName) throws SQLException
	{
		return callStatement.getBoolean(parameterName);
	}

	@Override
	public byte getByte(int parameterIndex) throws SQLException
	{
		return callStatement.getByte(parameterIndex);
	}

	@Override
	public byte getByte(String parameterIndex) throws SQLException
	{
		return callStatement.getByte(parameterIndex);
	}

	@Override
	public byte[] getBytes(int parameterIndex) throws SQLException
	{
		return callStatement.getBytes(parameterIndex);
	}

	@Override
	public byte[] getBytes(String parameterName) throws SQLException
	{
		return callStatement.getBytes(parameterName);
	}

	@Override
	public Reader getCharacterStream(int parameterIndex) throws SQLException
	{
		return callStatement.getCharacterStream(parameterIndex);
	}

	@Override
	public Reader getCharacterStream(String parameterName) throws SQLException
	{
		return callStatement.getCharacterStream(parameterName);
	}

	@Override
	public Clob getClob(int parameterIndex) throws SQLException
	{
		return callStatement.getClob(parameterIndex);
	}

	@Override
	public Clob getClob(String parameterName) throws SQLException
	{
		return callStatement.getClob(parameterName);
	}

	@Override
	public Date getDate(int parameterIndex) throws SQLException
	{
		return callStatement.getDate(parameterIndex);
	}

	@Override
	public Date getDate(String parameterName) throws SQLException
	{
		return callStatement.getDate(parameterName);
	}

	@Override
	public Date getDate(int parameterIndex, Calendar cal) throws SQLException
	{
		return callStatement.getDate(parameterIndex, cal);
	}

	@Override
	public Date getDate(String parameterName, Calendar cal) throws SQLException
	{
		return callStatement.getDate(parameterName, cal);
	}

	@Override
	public double getDouble(int parameterIndex) throws SQLException
	{
		return callStatement.getDouble(parameterIndex);
	}

	@Override
	public double getDouble(String parameterName) throws SQLException
	{
		return callStatement.getDouble(parameterName);
	}

	@Override
	public float getFloat(int parameterIndex) throws SQLException
	{
		return callStatement.getFloat(parameterIndex);
	}

	@Override
	public float getFloat(String parameterName) throws SQLException
	{
		return callStatement.getFloat(parameterName);
	}

	@Override
	public int getInt(int parameterIndex) throws SQLException
	{
		return callStatement.getInt(parameterIndex);
	}

	@Override
	public int getInt(String parameterName) throws SQLException
	{
		return callStatement.getInt(parameterName);
	}

	@Override
	public long getLong(int parameterIndex) throws SQLException
	{
		return callStatement.getLong(parameterIndex);
	}

	@Override
	public long getLong(String parameterName) throws SQLException
	{
		return callStatement.getLong(parameterName);
	}

	@Override
	public Reader getNCharacterStream(int parameterIndex) throws SQLException
	{
		return callStatement.getNCharacterStream(parameterIndex);
	}

	@Override
	public Reader getNCharacterStream(String parameterName) throws SQLException
	{
		return callStatement.getNCharacterStream(parameterName);
	}

	@Override
	public NClob getNClob(int parameterIndex) throws SQLException
	{
		return callStatement.getNClob(parameterIndex);
	}

	@Override
	public NClob getNClob(String parameterName) throws SQLException
	{
		return callStatement.getNClob(parameterName);
	}

	@Override
	public String getNString(int parameterIndex) throws SQLException
	{
		return callStatement.getNString(parameterIndex);
	}

	@Override
	public String getNString(String parameterName) throws SQLException
	{
		return callStatement.getNString(parameterName);
	}

	@Override
	public Object getObject(int parameterIndex) throws SQLException
	{
		return callStatement.getObject(parameterIndex);
	}

	@Override
	public Object getObject(String parameterName) throws SQLException
	{
		return callStatement.getObject(parameterName);
	}

	@Override
	public Object getObject(int parameterIndex, Map<String, Class<?>> map)
			throws SQLException
	{
		return callStatement.getObject(parameterIndex, map);
	}

	@Override
	public Object getObject(String parameterName, Map<String, Class<?>> map)
			throws SQLException
	{
		return callStatement.getObject(parameterName, map);
	}

	@Override
	public Ref getRef(int parameterIndex) throws SQLException
	{
		return callStatement.getRef(parameterIndex);
	}

	@Override
	public Ref getRef(String parameterName) throws SQLException
	{
		return callStatement.getRef(parameterName);
	}

	@Override
	public RowId getRowId(int parameterIndex) throws SQLException
	{
		return callStatement.getRowId(parameterIndex);
	}

	@Override
	public RowId getRowId(String parameterName) throws SQLException
	{
		return callStatement.getRowId(parameterName);
	}

	@Override
	public SQLXML getSQLXML(int parameterIndex) throws SQLException
	{
		return callStatement.getSQLXML(parameterIndex);
	}

	@Override
	public SQLXML getSQLXML(String parameterName) throws SQLException
	{
		return callStatement.getSQLXML(parameterName);
	}

	@Override
	public short getShort(int parameterIndex) throws SQLException
	{
		return callStatement.getShort(parameterIndex);
	}

	@Override
	public short getShort(String parameterName) throws SQLException
	{
		return callStatement.getShort(parameterName);
	}

	@Override
	public String getString(int parameterIndex) throws SQLException
	{
		return callStatement.getString(parameterIndex);
	}

	@Override
	public String getString(String parameterName) throws SQLException
	{
		return callStatement.getString(parameterName);
	}

	@Override
	public Time getTime(int parameterIndex) throws SQLException
	{
		return callStatement.getTime(parameterIndex);
	}

	@Override
	public Time getTime(String parameterName) throws SQLException
	{
		return callStatement.getTime(parameterName);
	}

	@Override
	public Time getTime(int parameterIndex, Calendar cal) throws SQLException
	{
		return callStatement.getTime(parameterIndex, cal);
	}

	@Override
	public Time getTime(String parameterName, Calendar cal) throws SQLException
	{
		return callStatement.getTime(parameterName, cal);
	}

	@Override
	public Timestamp getTimestamp(int parameterIndex) throws SQLException
	{
		return callStatement.getTimestamp(parameterIndex);
	}

	@Override
	public Timestamp getTimestamp(String parameterName) throws SQLException
	{
		return callStatement.getTimestamp(parameterName);
	}

	@Override
	public Timestamp getTimestamp(int parameterIndex, Calendar cal)
			throws SQLException
	{
		return callStatement.getTimestamp(parameterIndex, cal);
	}

	@Override
	public Timestamp getTimestamp(String parameterIndex, Calendar cal)
			throws SQLException
	{
		return callStatement.getTimestamp(parameterIndex, cal);
	}

	@Override
	public URL getURL(int parameterIndex) throws SQLException
	{
		return callStatement.getURL(parameterIndex);
	}

	@Override
	public URL getURL(String parameterName) throws SQLException
	{
		return callStatement.getURL(parameterName);
	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType)
			throws SQLException
	{
		callStatement.registerOutParameter(parameterIndex, sqlType);
	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType)
			throws SQLException
	{
		callStatement.registerOutParameter(parameterName, sqlType);
	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType, int scale)
			throws SQLException
	{
		callStatement.registerOutParameter(parameterIndex, sqlType, scale);
	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType,
			String typeName) throws SQLException
	{
		callStatement.registerOutParameter(parameterIndex, sqlType, typeName);
	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType,
			int scale) throws SQLException
	{
		callStatement.registerOutParameter(parameterName, sqlType, scale);
	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType,
			String typeName) throws SQLException
	{
		callStatement.registerOutParameter(parameterName, sqlType, typeName);
	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x)
			throws SQLException
	{
		callStatement.setAsciiStream(parameterName, x);

	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x, int length)
			throws SQLException
	{
		callStatement.setAsciiStream(parameterName, x, length);

	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x, long length)
			throws SQLException
	{
		callStatement.setAsciiStream(parameterName, x, length);
	}

	@Override
	public void setBigDecimal(String parameterName, BigDecimal x)
			throws SQLException
	{
		callStatement.setBigDecimal(parameterName, x);
	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x)
			throws SQLException
	{
		callStatement.setBinaryStream(parameterName, x);
	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x, int length)
			throws SQLException
	{
		callStatement.setBinaryStream(parameterName, x, length);
	}

	@Override
	public void setBinaryStream(String parameterIndex, InputStream x,
			long length) throws SQLException
	{
		callStatement.setBinaryStream(parameterIndex, x, length);

	}

	@Override
	public void setBlob(String parameterName, Blob x) throws SQLException
	{
		callStatement.setBlob(parameterName, x);
	}

	@Override
	public void setBlob(String parameterName, InputStream inputStream)
			throws SQLException
	{
		callStatement.setBlob(parameterName, inputStream);
	}

	@Override
	public void setBlob(String parameterIndex, InputStream inputStream,
			long length) throws SQLException
	{
		callStatement.setBlob(parameterIndex, inputStream, length);
	}

	@Override
	public void setBoolean(String parameterName, boolean x) throws SQLException
	{
		callStatement.setBoolean(parameterName, x);
	}

	@Override
	public void setByte(String parameterName, byte x) throws SQLException
	{
		callStatement.setByte(parameterName, x);
	}

	@Override
	public void setBytes(String parameterIndex, byte[] x) throws SQLException
	{
		callStatement.setBytes(parameterIndex, x);
	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader)
			throws SQLException
	{
		callStatement.setCharacterStream(parameterName, reader);
	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader,
			int length) throws SQLException
	{
		callStatement.setCharacterStream(parameterName, reader, length);

	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader,
			long length) throws SQLException
	{
		callStatement.setCharacterStream(parameterName, reader, length);
	}

	@Override
	public void setClob(String parameterName, Clob x) throws SQLException
	{
		callStatement.setClob(parameterName, x);

	}

	@Override
	public void setClob(String parameterName, Reader reader)
			throws SQLException
	{
		callStatement.setClob(parameterName, reader);
	}

	@Override
	public void setClob(String parameterName, Reader reader, long length)
			throws SQLException
	{
		callStatement.setClob(parameterName, reader, length);
	}

	@Override
	public void setDate(String parameterName, Date x) throws SQLException
	{
		callStatement.setDate(parameterName, x);
	}

	@Override
	public void setDate(String parameterName, Date x, Calendar cal)
			throws SQLException
	{
		callStatement.setDate(parameterName, x, cal);
	}

	@Override
	public void setDouble(String parameterName, double x) throws SQLException
	{
		callStatement.setDouble(parameterName, x);
	}

	@Override
	public void setFloat(String parameterName, float x) throws SQLException
	{
		callStatement.setFloat(parameterName, x);
	}

	@Override
	public void setInt(String parameterName, int x) throws SQLException
	{
		Long cipherText = connection.getSqlTransformer().transformInAttribute(new Long(x), null);
		Logger.getLogger("dice:callable").log(Level.INFO, "encrypted:"+cipherText);
		callStatement.setInt(parameterName, cipherText.intValue());
	}

	@Override
	public void setLong(String parameterName, long x) throws SQLException
	{
		Long cipherText = connection.getSqlTransformer().transformInAttribute(x, null);
		Logger.getLogger("dice:callable").log(Level.INFO, "encrypted:"+cipherText);
		callStatement.setLong(parameterName, cipherText);
	}

	@Override
	public void setNCharacterStream(String parameterName, Reader value)
			throws SQLException
	{
		callStatement.setNCharacterStream(parameterName, value);
	}

	@Override
	public void setNCharacterStream(String parameterName, Reader value,
			long length) throws SQLException
	{
		callStatement.setNCharacterStream(parameterName, value, length);
	}

	@Override
	public void setNClob(String parameterName, NClob value) throws SQLException
	{
		callStatement.setNClob(parameterName, value);
	}

	@Override
	public void setNClob(String parameterName, Reader reader)
			throws SQLException
	{
		callStatement.setNClob(parameterName, reader);
	}

	@Override
	public void setNClob(String parameterName, Reader reader, long length)
			throws SQLException
	{
		callStatement.setNClob(parameterName, reader, length);
	}

	@Override
	public void setNString(String parameterName, String value)
			throws SQLException
	{
		Logger.getLogger("dice:callable").log(Level.INFO, "setNString");
		callStatement.setNString(parameterName, value);
	}

	@Override
	public void setNull(String parameterName, int sqlType) throws SQLException
	{
		callStatement.setNull(parameterName, sqlType);
	}

	@Override
	public void setNull(String parameterName, int sqlType, String typeName)
			throws SQLException
	{
		callStatement.setNull(parameterName, sqlType, typeName);
	}

	@Override
	public void setObject(String parameterName, Object x) throws SQLException
	{
		Logger.getLogger("dice:callable").log(Level.INFO, "setObject");
		callStatement.setObject(parameterName, x);
	}

	@Override
	public void setObject(String parameterName, Object x, int targetSqlType)
			throws SQLException
	{
		Logger.getLogger("dice:callable").log(Level.INFO, "setObject");
		callStatement.setObject(parameterName, x, targetSqlType);
	}

	@Override
	public void setObject(String parameterName, Object x, int targetSqlType,
			int scale) throws SQLException
	{
		Logger.getLogger("dice:callable").log(Level.INFO, "setObject");
		callStatement.setObject(parameterName, x, targetSqlType, scale);
	}

	@Override
	public void setRowId(String parameterName, RowId x) throws SQLException
	{
		Logger.getLogger("dice:callable").log(Level.INFO, "setRowId");
		callStatement.setRowId(parameterName, x);
	}

	@Override
	public void setSQLXML(String parameterName, SQLXML xmlObject)
			throws SQLException
	{
		callStatement.setSQLXML(parameterName, xmlObject);
	}

	@Override
	public void setShort(String parameterName, short x) throws SQLException
	{
		Long cipherText = connection.getSqlTransformer().transformInAttribute(new Long(x), null);
		Logger.getLogger("dice:callable").log(Level.INFO, "encrypted:"+cipherText);
		callStatement.setShort(parameterName, cipherText.shortValue());
	}

	@Override
	public void setString(String parameterName, String x) throws SQLException
	{
		String cipherText = connection.getSqlTransformer().transformInAttribute(x, null);
		Logger.getLogger("dice:callable").log(Level.INFO, "encrypted:"+cipherText);
		callStatement.setString(parameterName, cipherText);
	}

	@Override
	public void setTime(String parameterName, Time x) throws SQLException
	{
		callStatement.setTime(parameterName, x);
	}

	@Override
	public void setTime(String parameterName, Time x, Calendar cal)
			throws SQLException
	{
		callStatement.setTime(parameterName, x, cal);
	}

	@Override
	public void setTimestamp(String parameterName, Timestamp x)
			throws SQLException
	{
		callStatement.setTimestamp(parameterName, x);
	}

	@Override
	public void setTimestamp(String parameterName, Timestamp x, Calendar cal)
			throws SQLException
	{
		callStatement.setTimestamp(parameterName, x, cal);
	}

	@Override
	public void setURL(String parameterName, URL val) throws SQLException
	{
		callStatement.setURL(parameterName, val);
	}

	@Override
	public boolean wasNull() throws SQLException
	{
		return callStatement.wasNull();
	}

	@Override
	public void closeOnCompletion() throws SQLException
	{
		callStatement.closeOnCompletion();
	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException
	{
		return callStatement.isCloseOnCompletion();
	}

	@Override
	public <T> T getObject(int arg0, Class<T> arg1) throws SQLException
	{
		return callStatement.getObject(arg0, arg1);
	}

	@Override
	public <T> T getObject(String arg0, Class<T> arg1) throws SQLException
	{
		return callStatement.getObject(arg0, arg1);
	}

}
