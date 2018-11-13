package dice.sql;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DiceResultSetMetaData implements ResultSetMetaData
{
	private ResultSetMetaData meta;
	private DiceConnection conn;
	
	public DiceResultSetMetaData(ResultSetMetaData meta, DiceConnection connection)
	{
		this.meta = meta;
		this.conn = connection;
	}
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException
	{
		return meta.isWrapperFor(iface);
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException
	{
		return meta.unwrap(iface);
	}

	@Override
	public String getCatalogName(int column) throws SQLException
	{
		return meta.getCatalogName(column);
	}

	@Override
	public String getColumnClassName(int column) throws SQLException
	{
		return meta.getColumnClassName(column);
	}

	@Override
	public int getColumnCount() throws SQLException
	{
		return meta.getColumnCount();
	}

	@Override
	public int getColumnDisplaySize(int column) throws SQLException
	{
		return meta.getColumnDisplaySize(column);
	}

	@Override
	public String getColumnLabel(int column) throws SQLException
	{
		/*if(!isWritable(column))
		{
			return meta.getColumnName(column);
		}*/
		return conn.getSqlTransformer().transformOutAttribute(meta.getColumnLabel(column),new String("meta"));
	}

	@Override
	public String getColumnName(int column) throws SQLException
	{
		/*if(!isWritable(column))
		{
			return meta.getColumnName(column);
		}*/
		return conn.getSqlTransformer().transformOutAttribute(meta.getColumnName(column),new String("meta"));
	}

	@Override
	public int getColumnType(int column) throws SQLException
	{
		return meta.getColumnType(column);
	}

	@Override
	public String getColumnTypeName(int column) throws SQLException
	{
		return meta.getColumnTypeName(column);
	}

	@Override
	public int getPrecision(int column) throws SQLException
	{
		return meta.getPrecision(column);
	}

	@Override
	public int getScale(int column) throws SQLException
	{
		return meta.getScale(column);
	}

	@Override
	public String getSchemaName(int column) throws SQLException
	{
		// TODO
		return meta.getSchemaName(column);
	}

	@Override
	public String getTableName(int column) throws SQLException
	{
		return conn.getSqlTransformer().transformOutAttribute(meta.getTableName(column),new String("meta"));
	}

	@Override
	public boolean isAutoIncrement(int column) throws SQLException
	{
		return meta.isAutoIncrement(column);
	}

	@Override
	public boolean isCaseSensitive(int column) throws SQLException
	{
		return meta.isCaseSensitive(column);
	}

	@Override
	public boolean isCurrency(int column) throws SQLException
	{
		return meta.isCurrency(column);
	}

	@Override
	public boolean isDefinitelyWritable(int column) throws SQLException
	{
		return meta.isDefinitelyWritable(column);
	}

	@Override
	public int isNullable(int column) throws SQLException
	{
		return meta.isNullable(column);
	}

	@Override
	public boolean isReadOnly(int column) throws SQLException
	{
		return meta.isReadOnly(column);
	}

	@Override
	public boolean isSearchable(int column) throws SQLException
	{
		return meta.isSearchable(column);
	}

	@Override
	public boolean isSigned(int column) throws SQLException
	{
		return meta.isSigned(column);
	}

	@Override
	public boolean isWritable(int column) throws SQLException
	{
		return meta.isWritable(column);
	}

}
