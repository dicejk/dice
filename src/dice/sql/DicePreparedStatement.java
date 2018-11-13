package dice.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DicePreparedStatement extends DiceStatement implements
		PreparedStatement
{
	private PreparedStatement prepStatement;
	private DiceConnection connection;

	public DicePreparedStatement(DiceConnection connection, PreparedStatement statement)
	{
		super(connection, statement);
		this.prepStatement = statement;
		this.connection = connection;
	}
	
	@Override
	public void addBatch() throws SQLException
	{
		prepStatement.addBatch();
	}

	@Override
	public void clearParameters() throws SQLException
	{
		prepStatement.clearParameters();
	}

	@Override
	public boolean execute() throws SQLException
	{
		//Logger.get//Logger("dice:prepare").log(Level.INFO, "execute");
		return prepStatement.execute();
	}

	@Override
	public ResultSet executeQuery() throws SQLException
	{
		//Logger.get//Logger("dice:prepare").log(Level.INFO, "executeQuery");
		ResultSet rs = prepStatement.executeQuery();
		if(rs != null)
			return new DiceResultSet(rs,connection);
		return null;
	}

	@Override
	public int executeUpdate() throws SQLException
	{
		return prepStatement.executeUpdate();
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException
	{
		return new DiceResultSetMetaData(prepStatement.getMetaData(),this.connection);
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException
	{
		return prepStatement.getParameterMetaData();
	}

	@Override
	public void setArray(int parameterIndex, Array x) throws SQLException
	{
		prepStatement.setArray(parameterIndex, x);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x)
			throws SQLException
	{
		prepStatement.setAsciiStream(parameterIndex, x);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length)
			throws SQLException
	{
		prepStatement.setAsciiStream(parameterIndex, x, length);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length)
			throws SQLException
	{
		prepStatement.setAsciiStream(parameterIndex, x, length);
	}
	
	@Override
	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws SQLException
	{
		prepStatement.setBigDecimal(parameterIndex, x);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x)
			throws SQLException
	{
		prepStatement.setBinaryStream(parameterIndex, x);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws SQLException
	{
		prepStatement.setBinaryStream(parameterIndex, x);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length)
			throws SQLException
	{
		prepStatement.setBinaryStream(parameterIndex, x, length);
	}

	@Override
	public void setBlob(int parameterIndex, Blob x) throws SQLException
	{
		prepStatement.setBlob(parameterIndex, x);
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream)
			throws SQLException
	{
		prepStatement.setBlob(parameterIndex, inputStream);
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length)
			throws SQLException
	{
		prepStatement.setBlob(parameterIndex, inputStream, length);
	}

	@Override
	public void setBoolean(int parameterIndex, boolean x) throws SQLException
	{
		prepStatement.setBoolean(parameterIndex, x);
	}

	@Override
	public void setByte(int parameterIndex, byte x) throws SQLException
	{
		prepStatement.setByte(parameterIndex, x);
	}

	@Override
	public void setBytes(int parameterIndex, byte[] x) throws SQLException
	{
		prepStatement.setBytes(parameterIndex, x);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader)
			throws SQLException
	{
		prepStatement.setCharacterStream(parameterIndex, reader);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length)
			throws SQLException
	{
		prepStatement.setCharacterStream(parameterIndex, reader, length);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader,
			long length) throws SQLException
	{
		prepStatement.setCharacterStream(parameterIndex, reader, length);
	}

	@Override
	public void setClob(int parameterIndex, Clob x) throws SQLException
	{
		prepStatement.setClob(parameterIndex, x);
	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException
	{
		prepStatement.setClob(parameterIndex, reader);
	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length)
			throws SQLException
	{
		prepStatement.setClob(parameterIndex, reader, length);
	}

	@Override
	public void setDate(int parameterIndex, Date x) throws SQLException
	{
		prepStatement.setDate(parameterIndex, x);
	}

	@Override
	public void setDate(int parameterIndex, Date x, Calendar cal)
			throws SQLException
	{
		prepStatement.setDate(parameterIndex, x);
	}

	@Override
	public void setDouble(int parameterIndex, double x) throws SQLException
	{
		prepStatement.setDouble(parameterIndex, x);
	}

	@Override
	public void setFloat(int parameterIndex, float x) throws SQLException
	{
		prepStatement.setFloat(parameterIndex, x);
	}

	@Override
	public void setInt(int parameterIndex, int x) throws SQLException
	{
		Long cipherText = connection.getSqlTransformer().transformInAttribute(new Long(x), null);
		//Logger.get//Logger("dice:callable").log(Level.INFO, "encrypted:"+cipherText);
		prepStatement.setInt(parameterIndex, cipherText.intValue());
	}

	@Override
	public void setLong(int parameterIndex, long x) throws SQLException
	{
		Long cipherText = connection.getSqlTransformer().transformInAttribute(x, null);
		//Logger.get//Logger("dice:callable").log(Level.INFO, "encrypted:"+cipherText);
		prepStatement.setLong(parameterIndex, cipherText);
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value)
			throws SQLException
	{
		prepStatement.setNCharacterStream(parameterIndex, value);
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value,
			long length) throws SQLException
	{
		prepStatement.setNCharacterStream(parameterIndex, value, length);
	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException
	{
		prepStatement.setNClob(parameterIndex, value);

	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException
	{
		prepStatement.setNClob(parameterIndex, reader);
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length)
			throws SQLException
	{
		prepStatement.setNClob(parameterIndex, reader, length);
	}

	@Override
	public void setNString(int parameterIndex, String value)
			throws SQLException
	{
		prepStatement.setNString(parameterIndex, value);
	}

	@Override
	public void setNull(int parameterIndex, int sqlType) throws SQLException
	{
		prepStatement.setNull(parameterIndex, sqlType);
	}

	@Override
	public void setNull(int parameterIndex, int sqlType, String typeName)
			throws SQLException
	{
		prepStatement.setNull(parameterIndex, sqlType, typeName);
	}

	@Override
	public void setObject(int parameterIndex, Object x) throws SQLException
	{
		Logger.getLogger("dice:prepared").log(Level.INFO, "setObect");
		prepStatement.setObject(parameterIndex, x);
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType)
			throws SQLException
	{
		//Logger.get//Logger("dice:prepared").log(Level.INFO, "setObect");
		prepStatement.setObject(parameterIndex, x, targetSqlType);
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType,
			int scaleOrLength) throws SQLException
	{
		//Logger.get//Logger("dice:prepared").log(Level.INFO, "setObect");
		prepStatement.setObject(parameterIndex, x, targetSqlType);
	}

	@Override
	public void setRef(int parameterIndex, Ref x) throws SQLException
	{
		prepStatement.setRef(parameterIndex, x);
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException
	{
		prepStatement.setRowId(parameterIndex, x);
	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject)
			throws SQLException
	{
		prepStatement.setSQLXML(parameterIndex, xmlObject);
	}

	@Override
	public void setShort(int parameterIndex, short x) throws SQLException
	{
		Long cipherText = connection.getSqlTransformer().transformInAttribute(new Long(x), null);
		//Logger.get//Logger("dice:callable").log(Level.INFO, "encrypted:"+cipherText);
		prepStatement.setShort(parameterIndex, cipherText.shortValue());
	}

	@Override
	public void setString(int parameterIndex, String x) throws SQLException
	{
		String cipherText = connection.getSqlTransformer().transformInAttribute(x, null);
		//Logger.get//Logger("dice:prepared").log(Level.INFO, "encrypted:"+cipherText);
		prepStatement.setString(parameterIndex, cipherText);
	}

	@Override
	public void setTime(int parameterIndex, Time x) throws SQLException
	{
		prepStatement.setTime(parameterIndex, x);
	}

	@Override
	public void setTime(int parameterIndex, Time x, Calendar cal)
			throws SQLException
	{
		prepStatement.setTime(parameterIndex, x);
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x)
			throws SQLException
	{
		prepStatement.setTimestamp(parameterIndex, x);
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
			throws SQLException
	{
		prepStatement.setTimestamp(parameterIndex, x, cal);
	}

	@Override
	public void setURL(int parameterIndex, URL x) throws SQLException
	{
		prepStatement.setURL(parameterIndex, x);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setUnicodeStream(int parameterIndex, InputStream x, int length)
			throws SQLException
	{
		prepStatement.setUnicodeStream(parameterIndex, x, length);
	}

}
