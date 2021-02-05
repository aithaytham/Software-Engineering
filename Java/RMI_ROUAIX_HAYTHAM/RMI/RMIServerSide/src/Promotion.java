import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Promotion extends UnicastRemoteObject implements PromotionInterface{ 
	ArrayList<Student> listStudent = new ArrayList<Student>();

	
	protected Promotion() throws RemoteException {
		super();
		this.listStudent = new ArrayList<Student>();
	}

{

}

@Override
public void add_student(int id, String name, int age) throws RemoteException {
	Student stud = new Student (id, name, age);
	this.listStudent.add(stud);
	
}

@Override
public  String get_student(int id) {
	String stud = null; 
	for (Student e: this.listStudent) {
		if(e.getId()==id) {
			stud=e.getId()+"/"+e.getName()+"/"+e.getAge();
		}
	}
	return stud; 
}

@Override
public String promotion_score(){

	return null;
}

@Override
public String calculate_average() throws RemoteException {
	Double average = 0.0;
	Double sum = 0.0;
	for (Student e: this.listStudent) {
		sum = sum + e.calculate_average();
	}
	average = sum / listStudent.size();
	return "average promotion : " + average;
}

@Override
public void add_exam_student(int id, String name, Double score, Double coef) throws RemoteException {
	for (Student e: this.listStudent) {
		if(e.getId()==id) {
			e.add_exam(name, score, coef);
		}
	}
}
}