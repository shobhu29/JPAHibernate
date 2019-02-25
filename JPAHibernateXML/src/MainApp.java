import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
  
public class MainApp {  
  
    public static void main( String[] args )  
    {  
         StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
        Session session = factory.openSession();  
        Transaction t = session.beginTransaction();  
          
         Employee e1=new Employee();    
        //    e1.setId(4);    
            e1.setFirstName("Shobhit");    
            e1.setLastName("Mishra");    
        Employee e2 = new Employee();    
        //	e2.setId(5);
        	e2.setFirstName("Aditya");
        	e2.setLastName("Singh");
       session.save(e1);  
       session.save(e2); 
       t.commit();  
       System.out.println(e1.getFirstName());    
       System.out.println(e1.getLastName());  
       System.out.println(e2.getFirstName());    
       System.out.println(e2.getLastName());  
       
       System.out.println("successfully saved");    


        factory.close();  
        session.close();     
    }  
}  