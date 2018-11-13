package dice.sql;

import java.rmi.RemoteException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import dice.cipher.Cipher;
import dice.info.DiceServer;
import dsqlparser.SQLiteBaseListener;
import dsqlparser.SQLiteLexer;
import dsqlparser.SQLiteParser;

public class AntlrTransformer extends SQLiteBaseListener
		implements SqlTransformer
{

	private Cipher cipher;
	private DiceServer diceInfo;
	private TokenStreamRewriter rewriter;

	public AntlrTransformer(Cipher cipher, DiceServer diceInfo) {
		this.cipher = cipher;
		this.diceInfo = diceInfo;
	}

	@Override
	public String transformSql(String sql, String context)
	{
		ANTLRInputStream input = new ANTLRInputStream(sql);
		SQLiteLexer lexer = new SQLiteLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		rewriter = new TokenStreamRewriter(tokens);
		SQLiteParser parser = new SQLiteParser(tokens);
		// parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
		// TODO evtl. alternative für Test
		parser.removeErrorListeners();
		RuleContext tree = parser.parse();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(this, tree);
		return rewriter.getText();
	}

	@Override
	public String transformInAttribute(String attr, String context)
	{
		if (context != null && context.equals("meta") && !cipher.isMetaEncryptable())
			return attr;

		String cipherText = cipher.encrypt(attr);
		if (diceInfo != null)
		{
			try
			{
				diceInfo.addMessage(
						"encrypt: \"" + attr + "\" => \"" + cipherText + "\"");
			}
			catch (RemoteException e)
			{
				e.printStackTrace();
			}
		}
		return cipherText;
	}

	@Override
	public String transformOutAttribute(String attr, String context)
	{
		if (context != null && context.equals("meta") && cipher.isMetaEncryptable() == false)
			return attr;

		String clearText = cipher.decrypt(attr);
		if (diceInfo != null)
		{
			try
			{
				diceInfo.addMessage("decrypt: " + context
						+ cipher.isMetaEncryptable() + ": \"" + attr
						+ "\" => \"" + clearText + "\"");
			}
			catch (RemoteException e)
			{
				e.printStackTrace();
			}
		}
		return clearText;
	}

	@Override
	public Long transformInAttribute(Long attr, String context)
	{
		Long cipherText = cipher.encrypt(attr);
		if (diceInfo != null)
		{
			try
			{
				diceInfo.addMessage(
						"encrypt: \"" + attr + "\" => \"" + cipherText + "\"");
			}
			catch (RemoteException e)
			{
				e.printStackTrace();
			}
		}
		return cipherText;
	}

	@Override
	public Long transformOutAttribute(Long attr, String context)
	{
		Long clearText = cipher.decrypt(attr);
		if (diceInfo != null)
		{
			try
			{
				diceInfo.addMessage("decrypt: " + context + ": \"" + attr
						+ "\" => \"" + clearText + "\"");
			}
			catch (RemoteException e)
			{
				e.printStackTrace();
			}
		}
		return clearText;
	}

	@Override
	public void print(String str, String context)
	{
		if (diceInfo != null)
		{
			try
			{
				diceInfo.addMessage(str);
			}
			catch (RemoteException e)
			{
				e.printStackTrace();
			}
		}

	}

	public void rewrite(ParserRuleContext ctx)
	{
		if (cipher.isMetaEncryptable())
		{
			Token start = ctx.getStart();
			Token end = ctx.getStop();
			String encrypted = this.transformInAttribute(ctx.getText(),
					new String());
			rewriter.replace(start, end, encrypted);
		}
	}

	public void rewriteMeta(ParserRuleContext ctx)
	{
		Token start = ctx.getStart();
		Token end = ctx.getStop();
		String encrypted = "`"
				+ this.transformInAttribute(ctx.getText(), new String()) + "`";
		rewriter.replace(start, end, encrypted);
	}

	public void rewriteLong(ParserRuleContext ctx)
	{
		try
		{
			Long attr = Long.valueOf(ctx.getText());
			Token start = ctx.getStart();
			Token end = ctx.getStop();
			String encrypted = this.transformInAttribute(attr, new String())
					.toString();
			rewriter.replace(start, end, encrypted);
		}
		catch (Exception e)
		{
		}

	}

	@Override
	public void exitLiteral_value(
			@NotNull SQLiteParser.Literal_valueContext ctx)
	{
		// Einschränkung Werte
		TerminalNode strCtx = ctx.STRING_LITERAL();
		if (strCtx != null && !strCtx.getText().isEmpty())
		{
			rewrite(ctx);
		}
		TerminalNode numCtx = ctx.NUMERIC_LITERAL();
		if (numCtx != null && !numCtx.getText().isEmpty())
		{
			rewriteLong(ctx);
		}

	}

	@Override
	public void exitColumn_name(@NotNull SQLiteParser.Column_nameContext ctx)
	{
		rewrite(ctx);
	}

	@Override
	public void exitTable_name(@NotNull SQLiteParser.Table_nameContext ctx)
	{
		rewrite(ctx);
	}

	@Override
	public void exitTable_alias(@NotNull SQLiteParser.Table_aliasContext ctx)
	{
		rewrite(ctx);
	}

	@Override
	public void exitColumn_alias(@NotNull SQLiteParser.Column_aliasContext ctx)
	{
		rewrite(ctx);
	}

	@Override
	public void exitForeign_table(
			@NotNull SQLiteParser.Foreign_tableContext ctx)
	{
		rewrite(ctx);
	}
}
