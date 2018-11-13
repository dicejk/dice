package dice.info;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DiceServer extends Remote
{
	boolean addDiceListener(DiceListener listener) throws RemoteException;
	boolean removeDiceListener(DiceListener listener) throws RemoteException;
	boolean addMessage(String msg) throws RemoteException;
}
