package onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.Hbutil;

public class Manrun {
    public static void main(String[] args) {
        SessionFactory factory =Hbutil.getSf();
        Session session= factory.openSession();
        Transaction transaction= session.beginTransaction();


        Passport pass=new Passport();
        pass.setCountryName("Pune");

        Person p=new Person();
        p.setName(" sameer");
        p.setId(2);
        p.setPassport(pass);

        session.save(pass);
        session.save(p);










         session.flush();
         session.close();
         factory.close();


    }
}
