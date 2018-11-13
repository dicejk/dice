package dice.info;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ConsoleDiceInfoClient
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			String registryURL = "rmi://localhost:1099/dice";
			DiceServer server = (DiceServer) Naming.lookup(registryURL);
			DiceListener listener = new DiceListenerImpl(new DiceSqlListener()
				{

					@Override
					public void sqlString(String sqlString)
					{
						System.out.println(sqlString);

					}
				});
			server.addDiceListener(listener);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}

	}

}
