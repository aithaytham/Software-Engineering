import java.rmi.*;

public class HelloClient {
	public static void main(String args[]) 
	{
		try 
		{
      // lookup for the object
			PromotionInterface obj = (PromotionInterface) Naming.lookup("rmi://localhost:12345/promotion");
			
			// call methods
			obj.add_exam_student(0, "Maths", 2.0, 1.0);
			obj.add_exam_student(0,"Anglais", 9.0, 1.5);
			obj.add_exam_student(0,"Français", 7.0, 2.0);
			obj.add_exam_student(1, "Maths", 12.0, 1.0);
			obj.add_exam_student(1,"Anglais", 10.0, 1.5);
			obj.add_exam_student(1,"Français", 8.0, 2.0);
			obj.add_exam_student(2, "Maths", 16.0, 1.0);
			obj.add_exam_student(2,"Anglais", 12.0, 1.5);
			obj.add_exam_student(2,"Français", 4.0, 2.0);

			String msg = obj.calculate_average();
			System.out.println(msg);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
