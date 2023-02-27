package HibernateJava;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Student s=new Student();
       s.setRollno(1);
       s.setName("Nitya");
       s.setAge(2);
     
       	Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
       	SessionFactory sf=con.buildSessionFactory();
       	Session  s1=sf.openSession();
       	Transaction t=s1.beginTransaction();
       	s1.save(s);
       	t.commit();
    }
}
