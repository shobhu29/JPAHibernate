import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MainApp {
	
	private static SessionFactory factory; 
	public static void main(String[] args) {
		
		 factory = new Configuration().configure().buildSessionFactory();
		
		if(factory!=null)
		{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee user=new Employee();
		user.setEmp_name("shobhit");
		session.save(user);
		
		tx.commit();
      session.close();
      
      ReadData();
      
      
	}
		else
			System.out.println("Session factory is null");

}

	private static void ReadData() {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee user1=(Employee)session.get(Employee.class,1);
		System.out.println(user1.getEmp_name());
		tx.commit();
		session.close();
		
		
	}
}