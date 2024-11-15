package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Hbutil {
    private static StandardServiceRegistry rag;
    private static SessionFactory sf;
    public   static SessionFactory getSf(){
        if (sf==null){
            try{
                rag =new StandardServiceRegistryBuilder().configure().build();
                MetadataSources mds=new MetadataSources(rag);
                Metadata md=mds.getMetadataBuilder().build();
                sf=md.getSessionFactoryBuilder().build();

            }catch (Exception e){
                throw  new RuntimeException(e);
            }
        }
        return sf;
    }
}
