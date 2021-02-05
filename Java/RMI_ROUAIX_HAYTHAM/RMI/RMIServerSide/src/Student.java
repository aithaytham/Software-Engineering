

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Student extends UnicastRemoteObject implements StudentInterface{
	private int id;
	private String name;
	private int age;
	private ArrayList<Exam> listeExam;
	
	
	public Student(int id, String name, int age) throws RemoteException {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.listeExam = new ArrayList<Exam>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<Exam> getListeExam() {
		return listeExam;
	}
	
	@Override
	public String say() throws RemoteException {
		// TODO Auto-generated method stub
		return "Student name : "+this.getName()+" "+this.calculate_average()+ " exams : "+this.print_exams();
	}
	
	@Override
	public String print_exams() {
		String result = "";
		for (Exam e: this.listeExam) {
			result = result+"/"+e.getName()+" "+e.getScore()+" "+e.getCoef();
		}
		return result;
	}
	
	@Override
	public Double calculate_average() {
		Double div1 = 0.0;
		Double div2 = 0.0;
		Double average = 0.0;
		for (Exam e: this.listeExam) {
			div1 = div1 + (e.getScore() * e.getCoef());
			div2 = div2 + e.getCoef();
		}
		average = div1/div2;
		return average;
		
	}

	@Override
	public void add_exam(String name, Double score, Double coef){
		this.listeExam.add(new Exam(name, score, coef));
		
	}
	

	
}
