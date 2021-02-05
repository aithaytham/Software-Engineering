import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PromotionInterface extends Remote {
	
	  public String get_student(int id) throws java.rmi.RemoteException;
	  public String promotion_score() throws java.rmi.RemoteException;
	  public void add_student(int id, String name, int age) throws RemoteException;
	  public String calculate_average() throws RemoteException;
	  public void add_exam_student(int id, String name, Double score, Double coef) throws RemoteException;

}
