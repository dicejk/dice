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
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiceResultSet implements ResultSet
{

	private ResultSet resultSet;
	private DiceConnection connection;

	public DiceResultSet(ResultSet resultSet, DiceConnection connection) 
	{
		this.resultSet = resultSet;
		this.connection = connection;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException
	{
		return resultSet.isWrapperFor(iface);
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException
	{
		return resultSet.unwrap(iface);
	}

	@Override
	public boolean absolute(int row) throws SQLException
	{
		return resultSet.absolute(row);
	}

	@Override
	public void afterLast() throws SQLException
	{
		resultSet.afterLast();
	}

	@Override
	public void beforeFirst() throws SQLException
	{
		resultSet.beforeFirst();
	}

	@Override
	public void cancelRowUpdates() throws SQLException
	{
		resultSet.cancelRowUpdates();
	}

	@Override
	public void clearWarnings() throws SQLException
	{
		resultSet.clearWarnings();
	}

	@Override
	public void close() throws SQLException
	{
		resultSet.close();
	}

	@Override
	public void deleteRow() throws SQLException
	{
		resultSet.deleteRow();
	}

	@Override
	public int findColumn(String columnLabel) throws SQLException
	{
		String col = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.findColumn(col);
	}

	@Override
	public boolean first() throws SQLException
	{
		return resultSet.first();
	}

	@Override
	public Array getArray(int columnIndex) throws SQLException
	{
		return resultSet.getArray(columnIndex);
	}

	@Override
	public Array getArray(String arg0) throws SQLException
	{
		return resultSet.getArray(arg0);
	}

	@Override
	public InputStream getAsciiStream(int columnIndex) throws SQLException
	{
		return resultSet.getAsciiStream(columnIndex);
	}

	@Override
	public InputStream getAsciiStream(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getAsciiStream(columnLabel);
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex) throws SQLException
	{
		return resultSet.getBigDecimal(columnIndex);
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getBigDecimal(columnLabel);
	}

	@SuppressWarnings("deprecation")
	@Override
	public BigDecimal getBigDecimal(int columnIndex, int scale)
			throws SQLException
	{
		return resultSet.getBigDecimal(columnIndex, scale);
	}

	@SuppressWarnings("deprecation")
	@Override
	public BigDecimal getBigDecimal(String columnLabel, int scale)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getBigDecimal(columnLabel, scale);
	}

	@Override
	public InputStream getBinaryStream(int columnIndex) throws SQLException
	{
		return resultSet.getBinaryStream(columnIndex);
	}

	@Override
	public InputStream getBinaryStream(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getBinaryStream(columnLabel);
	}

	@Override
	public Blob getBlob(int columnIndex) throws SQLException
	{
		return resultSet.getBlob(columnIndex);
	}

	@Override
	public Blob getBlob(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getBlob(columnLabel);
	}

	@Override
	public boolean getBoolean(int columnIndex) throws SQLException
	{
		return resultSet.getBoolean(columnIndex);
	}

	@Override
	public boolean getBoolean(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getBoolean(columnLabel);
	}

	@Override
	public byte getByte(int columnIndex) throws SQLException
	{
		return resultSet.getByte(columnIndex);
	}

	@Override
	public byte getByte(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getByte(columnLabel);
	}

	@Override
	public byte[] getBytes(int columnIndex) throws SQLException
	{
		return resultSet.getBytes(columnIndex);
	}

	@Override
	public byte[] getBytes(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getBytes(columnLabel);
	}

	@Override
	public Reader getCharacterStream(int columnIndex) throws SQLException
	{
		return resultSet.getCharacterStream(columnIndex);
	}

	@Override
	public Reader getCharacterStream(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getCharacterStream(columnLabel);
	}

	@Override
	public Clob getClob(int columnIndex) throws SQLException
	{
		return resultSet.getClob(columnIndex);
	}

	@Override
	public Clob getClob(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getClob(columnLabel);
	}

	@Override
	public int getConcurrency() throws SQLException
	{
		return resultSet.getConcurrency();
	}

	@Override
	public String getCursorName() throws SQLException
	{
		return resultSet.getCursorName();
	}

	@Override
	public Date getDate(int columnIndex) throws SQLException
	{
		return resultSet.getDate(columnIndex);
	}

	@Override
	public Date getDate(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getDate(columnLabel);
	}

	@Override
	public Date getDate(int columnIndex, Calendar cal) throws SQLException
	{
		return resultSet.getDate(columnIndex, cal);
	}

	@Override
	public Date getDate(String columnLabel, Calendar cal) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getDate(columnLabel, cal);
	}

	@Override
	public double getDouble(int columnIndex) throws SQLException
	{
		return resultSet.getDouble(columnIndex);
	}

	@Override
	public double getDouble(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getDouble(columnLabel);
	}

	@Override
	public int getFetchDirection() throws SQLException
	{
		return resultSet.getFetchDirection();
	}

	@Override
	public int getFetchSize() throws SQLException
	{
		return resultSet.getFetchSize();
	}

	@Override
	public float getFloat(int columnIndex) throws SQLException
	{
		return resultSet.getFloat(columnIndex);
	}

	@Override
	public float getFloat(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getFloat(columnLabel);
	}

	@Override
	public int getHoldability() throws SQLException
	{
		return resultSet.getHoldability();
	}

	@Override
	public int getInt(int columnIndex) throws SQLException
	{
		Long cipherText = new Long(resultSet.getInt(columnIndex));
		Logger.getLogger("dice").log(Level.INFO, "cipherText:"+cipherText);
		String columnLabel = resultSet.getMetaData().getColumnLabel(columnIndex);
		boolean decrypt = resultSet.getMetaData().isWritable(columnIndex);
		if(decrypt)
		{
			Long clearText = connection.getSqlTransformer().transformOutAttribute(cipherText, columnLabel);
			return clearText.intValue();
		}
		return cipherText.intValue();
	}

	@Override
	public int getInt(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		int columnIndex = resultSet.findColumn(columnLabel);
		return getInt(columnIndex);
	}

	@Override
	public long getLong(int columnIndex) throws SQLException
	{
		Long cipherText = resultSet.getLong(columnIndex);
		Logger.getLogger("dice").log(Level.INFO, "cipherText:"+cipherText);
		String columnLabel = resultSet.getMetaData().getTableName(columnIndex)+"."+resultSet.getMetaData().getColumnLabel(columnIndex);
		boolean decrypt = resultSet.getMetaData().isWritable(columnIndex);
		if(decrypt)
		{
			Long clearText = connection.getSqlTransformer().transformOutAttribute(cipherText, columnLabel);
			return clearText;
		}
		return cipherText;
	}

	@Override
	public long getLong(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		int columnIndex = resultSet.findColumn(columnLabel);
		return getLong(columnIndex);
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException
	{
		Logger.getLogger("dice").log(Level.INFO, "resultSet:"+resultSet);
		ResultSetMetaData meta = resultSet.getMetaData();
		return new DiceResultSetMetaData(meta,connection);
	}

	@Override
	public Reader getNCharacterStream(int columnIndex) throws SQLException
	{
		return resultSet.getNCharacterStream(columnIndex);
	}

	@Override
	public Reader getNCharacterStream(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getNCharacterStream(columnLabel);
	}

	@Override
	public NClob getNClob(int columnIndex) throws SQLException
	{
		return resultSet.getNClob(columnIndex);
	}

	@Override
	public NClob getNClob(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getNClob(columnLabel);
	}

	@Override
	public String getNString(int columnIndex) throws SQLException
	{
		return resultSet.getNString(columnIndex);
	}

	@Override
	public String getNString(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getNString(columnLabel);
	}

	@Override
	public Object getObject(int columnIndex) throws SQLException
	{
		return resultSet.getObject(columnIndex);
	}

	@Override
	public Object getObject(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getObject(columnLabel);
	}

	@Override
	public Object getObject(int columnIndex, Map<String, Class<?>> map)
			throws SQLException
	{
		return resultSet.getObject(columnIndex, map);
	}

	@Override
	public Object getObject(String columnLabel, Map<String, Class<?>> arg1)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getObject(columnLabel);
	}

	@Override
	public Ref getRef(int columnIndex) throws SQLException
	{
		return resultSet.getRef(columnIndex);
	}

	@Override
	public Ref getRef(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getRef(columnLabel);
	}

	@Override
	public int getRow() throws SQLException
	{
		return resultSet.getRow();
	}

	@Override
	public RowId getRowId(int columnIndex) throws SQLException
	{
		return resultSet.getRowId(columnIndex);
	}

	@Override
	public RowId getRowId(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getRowId(columnLabel);
	}

	@Override
	public SQLXML getSQLXML(int columnIndex) throws SQLException
	{
		return resultSet.getSQLXML(columnIndex);
	}

	@Override
	public SQLXML getSQLXML(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getSQLXML(columnLabel);
	}

	@Override
	public short getShort(int columnIndex) throws SQLException
	{
		Long cipherText = new Long(resultSet.getShort(columnIndex));
		Logger.getLogger("dice").log(Level.INFO, "cipherText:"+cipherText);
		String columnLabel = resultSet.getMetaData().getTableName(columnIndex)+"."+resultSet.getMetaData().getColumnLabel(columnIndex);
		boolean decrypt = resultSet.getMetaData().isWritable(columnIndex);
		if(decrypt)
		{
			Long clearText = connection.getSqlTransformer().transformOutAttribute(cipherText, columnLabel);
			return clearText.shortValue();
		}
		return cipherText.shortValue();
	}

	@Override
	public short getShort(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		int columnIndex = resultSet.findColumn(columnLabel);
		return getShort(columnIndex);
	}

	@Override
	public Statement getStatement() throws SQLException
	{
		return resultSet.getStatement();
	}

	@Override
	public String getString(int columnIndex) throws SQLException
	{
		String cipherText = resultSet.getString(columnIndex);
		Logger.getLogger("dice").log(Level.INFO, "cipherText:"+cipherText);
		String columnLabel = resultSet.getMetaData().getTableName(columnIndex)+"."+resultSet.getMetaData().getColumnLabel(columnIndex);
		boolean decrypt = resultSet.getMetaData().isWritable(columnIndex);
		if(decrypt)
		{
			String clearText = connection.getSqlTransformer().transformOutAttribute(cipherText, columnLabel);
			this.getMetaData().getColumnName(columnIndex);
			return clearText;
		}
		return cipherText;
	}

	@Override
	public String getString(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		int columnIndex = resultSet.findColumn(columnLabel);
		return getString(columnIndex);
	}

	@Override
	public Time getTime(int columnIndex) throws SQLException
	{
		return resultSet.getTime(columnIndex);
	}

	@Override
	public Time getTime(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getTime(columnLabel);
	}

	@Override
	public Time getTime(int columnIndex, Calendar cal) throws SQLException
	{
		return resultSet.getTime(columnIndex,cal);
	}

	@Override
	public Time getTime(String columnLabel, Calendar cal) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getTime(columnLabel,cal);
	}

	@Override
	public Timestamp getTimestamp(int columnIndex) throws SQLException
	{
		return resultSet.getTimestamp(columnIndex);
	}

	@Override
	public Timestamp getTimestamp(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getTimestamp(columnLabel);
	}

	@Override
	public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException
	{
		return resultSet.getTimestamp(columnIndex,cal);
	}

	@Override
	public Timestamp getTimestamp(String columnLabel, Calendar cal)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getTimestamp(columnLabel,cal);
	}

	@Override
	public int getType() throws SQLException
	{
		return resultSet.getType();
	}

	@Override
	public URL getURL(int columnIndex) throws SQLException
	{
		return resultSet.getURL(columnIndex);
	}

	@Override
	public URL getURL(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getURL(columnLabel);
	}

	@SuppressWarnings("deprecation")
	@Override
	public InputStream getUnicodeStream(int columnIndex) throws SQLException
	{
		return resultSet.getUnicodeStream(columnIndex);
	}

	@SuppressWarnings("deprecation")
	@Override
	public InputStream getUnicodeStream(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		return resultSet.getUnicodeStream(columnLabel);
	}

	@Override
	public SQLWarning getWarnings() throws SQLException
	{
		return resultSet.getWarnings();
	}

	@Override
	public void insertRow() throws SQLException
	{
		resultSet.insertRow();
	}

	@Override
	public boolean isAfterLast() throws SQLException
	{
		return resultSet.isAfterLast();
	}

	@Override
	public boolean isBeforeFirst() throws SQLException
	{
		return resultSet.isBeforeFirst();
	}

	@Override
	public boolean isClosed() throws SQLException
	{
		return resultSet.isClosed();
	}

	@Override
	public boolean isFirst() throws SQLException
	{
		return resultSet.isFirst();
	}

	@Override
	public boolean isLast() throws SQLException
	{
		return resultSet.isLast();
	}

	@Override
	public boolean last() throws SQLException
	{
		return resultSet.last();
	}

	@Override
	public void moveToCurrentRow() throws SQLException
	{
		resultSet.moveToCurrentRow();
	}

	@Override
	public void moveToInsertRow() throws SQLException
	{
		resultSet.moveToInsertRow();
	}

	@Override
	public boolean next() throws SQLException
	{
		boolean result = resultSet.next();
		if(result)
		{
			this.connection.getSqlTransformer().print("BEGIN RESULT", null);
		}
		return result;
	}

	@Override
	public boolean previous() throws SQLException
	{
		return resultSet.previous();
	}

	@Override
	public void refreshRow() throws SQLException
	{
		resultSet.refreshRow();
	}

	@Override
	public boolean relative(int rows) throws SQLException
	{
		return resultSet.relative(rows);
	}

	@Override
	public boolean rowDeleted() throws SQLException
	{
		return resultSet.rowDeleted();
	}

	@Override
	public boolean rowInserted() throws SQLException
	{
		return resultSet.rowInserted();
	}

	@Override
	public boolean rowUpdated() throws SQLException
	{
		return resultSet.rowUpdated();
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException
	{
		resultSet.setFetchDirection(direction);
	}

	@Override
	public void setFetchSize(int rows) throws SQLException
	{
		resultSet.setFetchSize(rows);
	}

	@Override
	public void updateArray(int columnIndex, Array x) throws SQLException
	{
		resultSet.updateArray(columnIndex, x);

	}

	@Override
	public void updateArray(String columnLabel, Array x) throws SQLException
	{
		resultSet.updateArray(columnLabel, x);
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x)
			throws SQLException
	{
		resultSet.updateAsciiStream(columnIndex, x);
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateAsciiStream(columnLabel, x);
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, int length)
			throws SQLException
	{
		resultSet.updateAsciiStream(columnIndex, x,length);
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, int length)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateAsciiStream(columnLabel, x,length);
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, long length)
			throws SQLException
	{
		resultSet.updateAsciiStream(columnIndex, x,length);
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, long length)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateAsciiStream(columnLabel, x,length);
	}

	@Override
	public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException
	{
		resultSet.updateBigDecimal(columnIndex, x);
	}

	@Override
	public void updateBigDecimal(String columnLabel, BigDecimal x)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateBigDecimal(columnLabel, x);
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x)
			throws SQLException
	{
		resultSet.updateBinaryStream(columnIndex, x);
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateBinaryStream(columnLabel, x);
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, int length)
			throws SQLException
	{
		resultSet.updateBinaryStream(columnIndex, x,length);
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, int length)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateBinaryStream(columnLabel, x,length);

	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, long length)
			throws SQLException
	{
		resultSet.updateBinaryStream(columnIndex, x,length);
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, long length)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateBinaryStream(columnLabel, x,length);
	}

	@Override
	public void updateBlob(int columnIndex, Blob x) throws SQLException
	{
		resultSet.updateBlob(columnIndex, x);
	}

	@Override
	public void updateBlob(String columnLabel, Blob x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateBlob(columnLabel, x);
	}

	@Override
	public void updateBlob(int columnIndex, InputStream x) throws SQLException
	{
		resultSet.updateBlob(columnIndex, x);
	}

	@Override
	public void updateBlob(String columnLabel, InputStream x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateBlob(columnLabel, x);
	}

	@Override
	public void updateBlob(int columnIndex, InputStream x, long length)
			throws SQLException
	{
		resultSet.updateBlob(columnIndex, x, length);
	}

	@Override
	public void updateBlob(String columnLabel, InputStream x, long length)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateBlob(columnLabel, x, length);
	}

	@Override
	public void updateBoolean(int columnIndex, boolean x) throws SQLException
	{
		resultSet.updateBoolean(columnIndex, x);
	}

	@Override
	public void updateBoolean(String columnLabel, boolean x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateBoolean(columnLabel, x);
	}

	@Override
	public void updateByte(int columnIndex, byte x) throws SQLException
	{
		resultSet.updateByte(columnIndex, x);
	}

	@Override
	public void updateByte(String columnLabel, byte x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateByte(columnLabel, x);
	}

	@Override
	public void updateBytes(int columnIndex, byte[] x) throws SQLException
	{
		resultSet.updateBytes(columnIndex, x);
	}

	@Override
	public void updateBytes(String columnLabel, byte[] x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateBytes(columnLabel, x);
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x)
			throws SQLException
	{
		resultSet.updateCharacterStream(columnIndex, x);
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader x)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateCharacterStream(columnLabel, x);
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, int length)
			throws SQLException
	{
		resultSet.updateCharacterStream(columnIndex, x, length);
	}


	@Override
	public void updateCharacterStream(String columnLabel, Reader x, int length)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateCharacterStream(columnLabel, x, length);
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, long length)
			throws SQLException
	{
		resultSet.updateCharacterStream(columnIndex, x, length);
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader x, long length)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateCharacterStream(columnLabel, x, length);
	}

	@Override
	public void updateClob(int columnIndex, Clob x) throws SQLException
	{
		resultSet.updateClob(columnIndex, x);
	}

	@Override
	public void updateClob(String columnLabel, Clob x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateClob(columnLabel, x);
	}


	@Override
	public void updateClob(int columnIndex, Reader reader) throws SQLException
	{
		resultSet.updateClob(columnIndex,reader);
	}

	@Override
	public void updateClob(String columnLabel, Reader reader) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateClob(columnLabel, reader);
	}

	@Override
	public void updateClob(int columnIndex, Reader reader, long length)
			throws SQLException
	{
		resultSet.updateClob(columnIndex, reader, length);
	}

	@Override
	public void updateClob(String columnLabel, Reader reader, long length)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateClob(columnLabel, reader, length);
	}

	@Override
	public void updateDate(int columnIndex, Date x) throws SQLException
	{
		resultSet.updateDate(columnIndex, x);
	}

	@Override
	public void updateDate(String columnLabel, Date x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateDate(columnLabel, x);

	}

	@Override
	public void updateDouble(int columnIndex, double x) throws SQLException
	{
		resultSet.updateDouble(columnIndex, x);
	}

	@Override
	public void updateDouble(String columnLabel, double x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateDouble(columnLabel, x);
	}

	@Override
	public void updateFloat(int columnIndex, float x) throws SQLException
	{
		resultSet.updateFloat(columnIndex, x);
	}

	@Override
	public void updateFloat(String columnLabel, float x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateFloat(columnLabel, x);
	}

	@Override
	public void updateInt(int columnIndex, int x) throws SQLException
	{
		resultSet.updateInt(columnIndex, x);
	}

	@Override
	public void updateInt(String columnLabel, int x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateInt(columnLabel, x);
	}

	@Override
	public void updateLong(int columnIndex, long x) throws SQLException
	{
		resultSet.updateLong(columnIndex, x);
	}

	@Override
	public void updateLong(String columnLabel, long x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateLong(columnLabel, x);
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader reader)
			throws SQLException
	{
		resultSet.updateNCharacterStream(columnIndex, reader);
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateNCharacterStream(columnLabel, reader);
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader reader, long length)
			throws SQLException
	{
		resultSet.updateNCharacterStream(columnIndex, reader, length);
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader, long length)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateNCharacterStream(columnLabel, reader, length);
	}

	@Override
	public void updateNClob(int columnIndex, NClob x) throws SQLException
	{
		resultSet.updateNClob(columnIndex, x);
	}

	@Override
	public void updateNClob(String columnLabel, NClob x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateNClob(columnLabel, x);
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader) throws SQLException
	{
		resultSet.updateNClob(columnIndex, reader);
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateNClob(columnLabel, reader);
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader, long length)
			throws SQLException
	{
		resultSet.updateNClob(columnIndex, reader, length);
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader, long length)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateNClob(columnLabel, reader, length);
	}

	@Override
	public void updateNString(int columnIndex, String x) throws SQLException
	{
		resultSet.updateNString(columnIndex, x);
	}

	@Override
	public void updateNString(String columnLabel, String x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateNString(columnLabel, x);
	}

	@Override
	public void updateNull(int columnIndex) throws SQLException
	{
		resultSet.updateNull(columnIndex);
	}

	@Override
	public void updateNull(String columnLabel) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateNull(columnLabel);
	}

	@Override
	public void updateObject(int columnIndex, Object x) throws SQLException
	{
		resultSet.updateObject(columnIndex,x);
	}

	@Override
	public void updateObject(String columnLabel, Object x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateObject(columnLabel,x);
	}

	@Override
	public void updateObject(int columnIndex, Object x, int scaleOrLength)
			throws SQLException
	{
		resultSet.updateObject(columnIndex, x, scaleOrLength);
	}

	@Override
	public void updateObject(String columnLabel, Object x, int scaleOrLength)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateObject(columnLabel, x, scaleOrLength);
	}

	@Override
	public void updateRef(int columnIndex, Ref x) throws SQLException
	{
		resultSet.updateRef(columnIndex, x);
	}

	@Override
	public void updateRef(String columnLabel, Ref x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateRef(columnLabel, x);
	}

	@Override
	public void updateRow() throws SQLException
	{
		resultSet.updateRow();
	}

	@Override
	public void updateRowId(int columnIndex, RowId x) throws SQLException
	{
		resultSet.updateRowId(columnIndex, x);
	}

	@Override
	public void updateRowId(String columnLabel, RowId x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateRowId(columnLabel, x);
	}

	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException
	{
		resultSet.updateSQLXML(columnIndex, xmlObject);
	}

	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateSQLXML(columnLabel, xmlObject);
	}

	@Override
	public void updateShort(int columnIndex, short x) throws SQLException
	{
		resultSet.updateShort(columnIndex, x);
	}

	@Override
	public void updateShort(String columnLabel, short x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateShort(columnLabel, x);
	}

	@Override
	public void updateString(int columnIndex, String x) throws SQLException
	{
		resultSet.updateString(columnIndex, x);
	}

	@Override
	public void updateString(String columnLabel, String x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateString(columnLabel, x);
	}

	@Override
	public void updateTime(int columnIndex, Time x) throws SQLException
	{
		resultSet.updateTime(columnIndex, x);
	}

	@Override
	public void updateTime(String columnLabel, Time x) throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateTime(columnLabel, x);
	}

	@Override
	public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException
	{
		resultSet.updateTimestamp(columnIndex, x);
	}

	@Override
	public void updateTimestamp(String columnLabel, Timestamp x)
			throws SQLException
	{
		columnLabel = connection.getSqlTransformer().transformInAttribute(columnLabel, "column");
		resultSet.updateTimestamp(columnLabel, x);
	}

	@Override
	public boolean wasNull() throws SQLException
	{
		return resultSet.wasNull();
	}

	@Override
	public <T> T getObject(int arg0, Class<T> arg1) throws SQLException
	{
		return resultSet.getObject(arg0,arg1);
	}

	@Override
	public <T> T getObject(String arg0, Class<T> arg1) throws SQLException
	{
		return resultSet.getObject(arg0,arg1);
	}

}
