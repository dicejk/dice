package dice.cipher.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dice.cipher.CaesarCipher;
import dice.cipher.StableGenericROT;
import dice.sql.AntlrTransformer;
import dice.sql.SqlTransformer;

public class AntlrTransformerTest
{

	@Test
	public void testTransformSqlLike()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String cipherText = transformer.transformSql("SELECT * FROM Products AS p WHERE p.product_name LIKE '%R%'", null);
		assertEquals("SELECT * FROM Surgxfwv AS s WHERE s.surgxfw_qdph LIKE '%U%'",cipherText);
	}

	@Test
	public void testTransformSqlInsert()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String cipherText = transformer.transformSql("INSERT INTO Products(product_id, product_name) VALUES (1, 'Open RoundFile')", null);
		assertEquals("INSERT INTO Surgxfwv(surgxfw_lg, surgxfw_qdph) VALUES (4, 'Rshq UrxqgIloh')",cipherText);
	}
	
	@Test
	public void testTransformLimit()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String cipherText = transformer.transformSql("SELECT FIRSTNAME,LASTNAME,AGE FROM CUSTOMERS C ORDER BY C.AGE LIMIT 5", null);
		assertEquals("SELECT ILUVWQDPH,ODVWQDPH,DJH FROM FXVWRPHUV F ORDER BY F.DJH LIMIT 5",cipherText);
	}
	
	
	@Test
	public void testTransformSqlLikeAnonym()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String cipherText = transformer.transformSql("SELECT * FROM Products WHERE product_name LIKE '%R%'", null);
		assertEquals("SELECT * FROM Surgxfwv WHERE surgxfw_qdph LIKE '%U%'",cipherText);
	}
	
	@Test
	public void testTransformLess()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String cipherText = transformer.transformSql("SELECT * FROM Products WHERE product_name < 20000", null);
		assertEquals("SELECT * FROM Surgxfwv WHERE surgxfw_qdph < 53333",cipherText);
	}
	
	@Test
	public void testTransformSqlCols()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String cipherText = transformer.transformSql("SELECT A FROM Products WHERE product_name LIKE '%R%'", null);
		assertEquals("SELECT D FROM Surgxfwv WHERE surgxfw_qdph LIKE '%U%'",cipherText);
	}
	
	@Test
	public void testTransformSqlJoin()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String cipherText = transformer.transformSql("SELECT A FROM Products, Products WHERE product_name LIKE '%R%'", null);
		assertEquals("SELECT D FROM Surgxfwv, Surgxfwv WHERE surgxfw_qdph LIKE '%U%'",cipherText);
	}
	
	@Test
	public void testTransformSqlQualifier()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String cipherText = transformer.transformSql("SELECT Products.A FROM Products", null);
		assertEquals("SELECT Surgxfwv.D FROM Surgxfwv",cipherText);
	}
	
	@Test
	public void testTransformSqlOrder()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String cipherText = transformer.transformSql("select A from Products order by A ASC", null);
		assertEquals("select D from Surgxfwv order by D ASC",cipherText);
	}
	
	@Test
	public void testCreate()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(0), null);
		String sql = "CREATE TABLE SUPPLIERS(SUP_ID integer NOT NULL,SUP_NAME varchar(40) NOT NULL,STREET varchar(40) NOT NULL,CITY varchar(20) NOT NULL,STATE char(2) NOT NULL,ZIP char(5),PRIMARY KEY (SUP_ID))";
		
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sql,cipherText);
	}
	
	@Test
	public void testCreateC1()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(1), null);
		String sql = "CREATE TABLE SUPPLIERS(SUP_ID integer NOT NULL,SUP_NAME varchar(40) NOT NULL,STREET varchar(40) NOT NULL,CITY varchar(20) NOT NULL,STATE char(2) NOT NULL,ZIP char(5),PRIMARY KEY (SUP_ID))";
		
		String cipherText = transformer.transformSql(sql, null);
		String sqlCipher = "CREATE TABLE TVQQMJFST(TVQ_JE integer NOT NULL,TVQ_OBNF varchar(40) NOT NULL,TUSFFU varchar(40) NOT NULL,DJUZ varchar(20) NOT NULL,TUBUF char(2) NOT NULL,aJQ char(5),PRIMARY KEY (TVQ_JE))";
		
		assertEquals(sqlCipher,cipherText);
	}
	
	@Test
	public void testDrop()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(0), null);
		String sql = "DROP TABLE SUPPLIERS";
		
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sql,cipherText);
	}
	
	@Test
	public void testCreateTableCustomer()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(0), null);
		String sql = "CREATE TABLE customer(c_id int not null,c_d_id int not null,c_w_id int not null,c_first varchar(16),c_middle char(2),c_last varchar(16),c_street_1 varchar(20),c_street_2 varchar(20),c_city varchar(20),c_state char(2),c_zip char(9),c_phone char(16),c_since date default '1970-01-01',c_credit char(2),c_credit_lim double precision,c_discount float,c_balance double precision,c_ytd_payment double precision,c_payment_cnt smallint,c_delivery_cnt smallint,c_data varchar(500),primary key (c_w_id, c_d_id, c_id)) engine = InnoDB CHARACTER SET utf8";
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sql,cipherText);
		
	}
	
	@Test
	public void testCreateTableSmall()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(0), null);
		String sql = "CREATE TABLE customer(c_id int not null,primary key (c_id)) engine = InnoDB CHARACTER SET utf8";
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sql,cipherText);
		
	}
	
	@Test
	public void testCreateTableCustomer3()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String sql = "CREATE TABLE customer(c_id int not null,c_d_id int not null,c_w_id int not null,c_first varchar(16),c_middle char(2),c_last varchar(16),c_street_1 varchar(20),c_street_2 varchar(20),c_city varchar(20),c_state char(2),c_zip char(9),c_phone char(16),c_since date default '1970-01-01',c_credit char(2),c_credit_lim double precision,c_discount float,c_balance double precision,c_ytd_payment double precision,c_payment_cnt smallint,c_delivery_cnt smallint,c_data varchar(500),primary key (c_w_id, c_d_id, c_id)) engine = InnoDB CHARACTER SET utf8";
		//String sqlCipher = "CREATE TABLE customer(c_id int not null,c_d_id int not null,c_w_id int not null,c_first varchar(16),c_middle char(2),c_last varchar(16),c_street_1 varchar(20),c_street_2 varchar(20),c_city varchar(20),c_state char(2),c_zip char(9),c_phone char(16),c_since date default '1970-01-01',c_credit char(2),c_credit_lim double precision,c_discount float,c_balance double precision,c_ytd_payment double precision,c_payment_cnt smallint,c_delivery_cnt smallint,c_data varchar(500),primary key (c_w_id, c_d_id, c_id)) engine = InnoDB CHARACTER SET utf8";
		String sqlCipher = "CREATE TABLE fxvwrphu(f_lg int not null,f_g_lg int not null,f_z_lg int not null,f_iluvw varchar(16),f_plggoh char(2),f_odvw varchar(16),f_vwuhhw_4 varchar(20),f_vwuhhw_5 varchar(20),f_flw varchar(20),f_vwdwh char(2),f_ls char(9),f_skrqh char(16),f_vlqfh date default '1970-01-01',f_fuhglw char(2),f_fuhglw_olp double precision,f_glvfrxqw float,f_edodqfh double precision,f_wg_sdphqw double precision,f_sdphqw_fqw smallint,f_gholyhu_fqw smallint,f_gdwd varchar(500),primary key (f_z_lg, f_g_lg, f_lg)) engine = InnoDB CHARACTER SET utf8";
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sqlCipher,cipherText);
		
	}
	
	@Test
	public void testInsertNumber()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String sql = "INSERT INTO COFFEES VALUES('test',17)";
		String sqlCipher = "INSERT INTO FRIIHHV VALUES('whvw',50)";
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sqlCipher,cipherText);
	}
	
	@Test
	public void testAlterConstraint()
	{
		SqlTransformer transformer = new AntlrTransformer(new StableGenericROT(1), null);
		String sql = "alter table customer add constraint fk_customer_district foreign key (c_w_id, c_d_id) references district (d_w_id, d_id) on delete restrict on update restrict;";
		String sqlCipher = "alter table dvtupnfs add constraint fk_customer_district foreign key (d_x_je, d_e_je) references ejtusjdu (e_x_je, e_je) on delete restrict on update restrict;";
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sqlCipher,cipherText);
	}
	
	@Test
	public void testDropIfExists()
	{
		SqlTransformer transformer = new AntlrTransformer(new StableGenericROT(1), null);
		String sql = "DROP TABLE IF EXISTS ABC";
		String sqlCipher = "DROP TABLE IF EXISTS BCD";
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sqlCipher,cipherText);
	}
	
	@Test
	public void testCreateIfNotExists()
	{
		SqlTransformer transformer = new AntlrTransformer(new StableGenericROT(1), null);
		String sql = "CREATE TABLE IF NOT EXISTS ABC(attr int);";
		String sqlCipher = "CREATE TABLE IF NOT EXISTS BCD(buus int);";
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sqlCipher,cipherText);
	}
	
	@Test
	public void testTransformSqlJoinPerf()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		for(int i = 0; i < 100; ++i)
		{
			String cipherText = transformer.transformSql("SELECT A FROM Products, Products WHERE product_name LIKE '%R%'", null);
			assertEquals("SELECT D FROM Surgxfwv, Surgxfwv WHERE surgxfw_qdph LIKE '%U%'",cipherText);
		}
	}
	@Test
	public void testForeignKeyTest()
	{
		SqlTransformer transformer = new AntlrTransformer(new StableGenericROT(1), null);
		String sql = "CREATE TABLE DISTRICT (D_ID		INT(11)		NOT NULL,D_W_ID		INT(11)		NOT NULL,D_NAME		VARCHAR(10)	NOT NULL,D_STREET_1	VARCHAR(20)	NOT NULL,D_STREET_2	VARCHAR(20)	NOT NULL,D_CITY		VARCHAR(20)	NOT NULL,D_STATE		CHAR(2)		NOT NULL,D_ZIP		CHAR(9)		NOT NULL,D_TAX		DECIMAL(4,4)	NOT NULL,D_YTD		DECIMAL(12,4)	NOT NULL,D_NEXT_O_ID	INT(11)		NOT NULL,PRIMARY KEY (D_W_ID, D_ID),FOREIGN KEY (D_W_ID)REFERENCES WAREHOUSE (W_ID)) ENGINE=INNODB;";
		String sqlCipher = "CREATE TABLE EJTUSJDU (E_JE		INT(11)		NOT NULL,E_X_JE		INT(11)		NOT NULL,E_OBNF		VARCHAR(10)	NOT NULL,E_TUSFFU_2	VARCHAR(20)	NOT NULL,E_TUSFFU_3	VARCHAR(20)	NOT NULL,E_DJUZ		VARCHAR(20)	NOT NULL,E_TUBUF		CHAR(2)		NOT NULL,F_AJQ		CHAR(9)		NOT NULL,E_UBY		DECIMAL(4,4)	NOT NULL,E_ZUE		DECIMAL(12,4)	NOT NULL,E_OFYU_P_JE	INT(11)		NOT NULL,PRIMARY KEY (E_X_JE, E_JE),FOREIGN KEY (E_X_JE)REFERENCES XBSFIPVTF (X_JE)) ENGINE=INNODB;";
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sqlCipher,cipherText);
	}
	@Test
	public void testINsertFunc()
	{
		SqlTransformer transformer = new AntlrTransformer(new StableGenericROT(1), null);
		String sql = "INSERT INTO ORD (O_ID, O_D_ID, O_W_ID, O_C_ID, O_ENTRY_D, O_OL_CNT, O_ALL_LOCAL) VALUES (?, ?, ?, ?, {fn now()}, ?, ?);";
		String sqlCipher = "INSERT INTO PSE (P_JE, P_E_JE, P_X_JE, P_D_JE, P_FOUSZ_E, P_PM_DOU, P_BMM_MPDBM) VALUES (?, ?, ?, ?, {fn now()}, ?, ?);";
		String cipherText = transformer.transformSql(sql, null);
		assertEquals(sqlCipher,cipherText);
	}
	
	@Test
	public void testSub()
	{
		String s = new String("1");
		assertEquals(s.substring(0,s.length() > 255 ? 255 : s.length()),s);
	}
	
	@Test
	public void testTransformDate()
	{
		SqlTransformer transformer = new AntlrTransformer(new CaesarCipher(3), null);
		String cipherText = transformer.transformSql("SELECT * FROM ORDERS WHERE O.ORDERDATE < '2010-01-01'", null);
		// TODO Date
		assertEquals("SELECT * FROM RUGHUV WHERE R.RUGHUGDWH < '5343-34-34'",cipherText);
	}
}
