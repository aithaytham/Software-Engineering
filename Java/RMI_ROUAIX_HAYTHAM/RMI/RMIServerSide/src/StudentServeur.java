import java.rmi.*;

import java.rmi.server.*;
import java.util.ArrayList;

import model.*;


public class StudentServeur  
{	
	protected StudentServeur() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String arg[]) throws RemoteException {
		//ArrayList<Exam> lstePromo = new ArrayList<Student>();
		
		Promotion promo = new Promotion();
		promo.add_student(0, "robot", 21);
		promo.add_student(1, "vany", 22);
		promo.add_student(2, "kevkev", 21);
		
		try 
		{
				// start RMIRegistry: port 12345
				// Alternative: start rmiregistry in terminal !
				java.rmi.registry.LocateRegistry.createRegistry(12345);
				
				// register the object
				Naming.rebind("rmi://localhost:12345/promotion",promo);
				
				System.out.println("HelloServer bound in registry");
			} 
			catch(Exception e)
			{
	      e.printStackTrace();
	    }

	}
}
