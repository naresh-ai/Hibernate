package OnetoMany;

import model.classes.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import javax.security.auth.login.Configuration;
import java.util.HashSet;
import java.util.Set;

public class Hutil {
    public static void main(String[] args) {

       // CarClass car = new CarClass();
        //car.setName("carmanza");

        customerClass item1 = new customerClass("sonkhas","sonkhas", 1);
        CarClass item2 = new CarClass(1,"mahesh","yello",9090);
       // Set<customerClass> itemsSet = new HashSet<customerClass>();
        //itemsSet.add(item1); itemsSet.add();

        //customerClass.setItems1(itemsSet);
        //customerClass.setTotal(10*1 + 20*2);

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try{
            //Get Session
            sessionFactory = MainRunClass.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            System.out.println("Session created");
            //start transaction
            tx = session.beginTransaction();
           // session.save(CarClass);
            session.save(item1);
            session.save(item2);

            tx.commit();
            //System.out.println("Cart1 ID="+CarClass.getId());
            System.out.println("item1 ID="+item1.getId()+", Foreign Key Cart ID="+item1.getId());
            System.out.println("item2 ID="+item2.getId()+", Foreign Key Cart ID="+item1.getId());

        }catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            e.printStackTrace();
        }finally{
            if(!sessionFactory.isClosed()){
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }


    }
}