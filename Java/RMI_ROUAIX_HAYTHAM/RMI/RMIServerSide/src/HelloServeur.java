import java.rmi.*;
import java.rmi.server.*;


public class HelloServeur extends UnicastRemoteObject implements HelloInterface
{
	private String msg;
	public HelloServeur(String msg) throws java.rmi.RemoteException
	{
		super(); this.msg = msg;
	}

	public String say() throws java.rmi.RemoteException
	{
		System.out.println("Hello world: " + msg);
		return "Hello world: " + msg;
	}
	
	public static void main(String args[])
	{
	}
}
