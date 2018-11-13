package dice.info;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DiceListenerImpl extends UnicastRemoteObject implements DiceListener
{
	private DiceSqlListener listener;
	protected DiceListenerImpl(DiceSqlListener listener) throws RemoteException {
		super();
		this.listener = listener;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8954010116704584257L;

	@Override
	public void sqlString(String sqlString) throws RemoteException
	{
		listener.sqlString(sqlString);
	}

}
