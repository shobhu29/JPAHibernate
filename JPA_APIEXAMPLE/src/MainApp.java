import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Shobhit");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Employee emp = new Employee();
		emp.setEname("alok");
		emp.setSalary(25000);
		emp.setDeg("B.Tech");
		
		entitymanager.persist(emp);
		
	//	Employee emp1 = entitymanager.find(Employee.class, 8);
	//	emp1.setSalary(12000);
		
		
		entitymanager.getTransaction().commit();
		System.out.println(emp);
		entitymanager.close();
		emfactory.close();
	}

}
