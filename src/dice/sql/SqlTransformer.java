package dice.sql;

public interface SqlTransformer
{
	public String transformSql(String sql, String context);
	public String transformInAttribute(String attr, String context);
	public String transformOutAttribute(String attr, String context);
	public Long transformInAttribute(Long attr, String context);
	public Long transformOutAttribute(Long attr, String context);
	public void print(String str, String context);
}
