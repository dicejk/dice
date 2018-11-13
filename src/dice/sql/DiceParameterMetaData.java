package dice.sql;

import java.sql.ParameterMetaData;
import java.sql.SQLException;

public class DiceParameterMetaData implements ParameterMetaData
{

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParameterClassName(int param) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getParameterCount() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getParameterMode(int param) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getParameterType(int param) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getParameterTypeName(int param) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPrecision(int param) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScale(int param) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int isNullable(int param) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSigned(int param) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

}
