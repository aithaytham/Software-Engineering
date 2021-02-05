

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote {
	
	public String say() throws RemoteException;
	public String print_exams() throws RemoteException;
	public Double calculate_average() throws RemoteException;
	public void add_exam(String name, Double score, Double coef) throws RemoteException;
}
