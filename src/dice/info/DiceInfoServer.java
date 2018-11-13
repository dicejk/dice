package dice.info;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class DiceInfoServer
{
	private DiceServerImpl exportedObj = null;
	public void run()
	{
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new RMISecurityManager());
		}
		try
		{
			LocateRegistry.createRegistry(1099);
			exportedObj = new DiceServerImpl();
			String registryURL = "rmi://localhost:1099/dice";
			Naming.rebind(registryURL, exportedObj);
			System.out.println("DiceInfoServer ready.");
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
	}

	public void callBack(String sqlString)
	{
		if(exportedObj != null)
			exportedObj.callBack(sqlString);
	}
	public static void main(String args[])
	{
		DiceInfoServer infoServer = new DiceInfoServer();
		infoServer.run();
	}
}
