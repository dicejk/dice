package dice.info;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DiceServerImpl extends UnicastRemoteObject implements DiceServer
{

	private ArrayList<DiceListener> listenerList;
	protected DiceServerImpl() throws RemoteException {
		super();
		listenerList = new ArrayList<DiceListener>();
	}

	private static final long serialVersionUID = 5545483245226265700L;

	@Override
	public synchronized boolean addDiceListener(DiceListener listener)
			throws RemoteException
	{
		listenerList.add(listener);
		listener.sqlString("Connection established.");
		return true;
	}
	
	public void callBack(String sqlString)
	{
		ArrayList<DiceListener> removeList= new ArrayList<DiceListener>();
		for(DiceListener listener : listenerList)
		{
			try
			{
				listener.sqlString(sqlString);
			}
			catch (RemoteException e)
			{
				removeList.add(listener);
			}
		}
		for(DiceListener listener : removeList)
		{
			listenerList.remove(listener);
		}
	}

	@Override
	public synchronized boolean removeDiceListener(DiceListener listener)
			throws RemoteException
	{
		listener.sqlString("Connection closed.");
		listenerList.remove(listener);
		return true;
	}

	@Override
	public boolean addMessage(String msg) throws RemoteException
	{
		this.callBack(msg);
		return true;
	}

}
