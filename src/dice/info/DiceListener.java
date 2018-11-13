package dice.info;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DiceListener extends Remote
{
	void sqlString(String sqlString) throws RemoteException;
} 
