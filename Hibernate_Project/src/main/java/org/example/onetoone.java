package org.example;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.classes.Customer;
import model.classes.Txn;
import org.example.Main;
public class onetoone {



        public static void main(String[] args) {

            Txn txn = buildDemoTransaction();

            SessionFactory sessionFactory = null;
            Session session = null;
            Transaction tx = null;
            try{
                //Get Session
                //sessionFactory = Main.getSessionFactory();
                session = sessionFactory.getCurrentSession();
                System.out.println("Session created");
                //start transaction
                tx = session.beginTransaction();
                //Save the Model object
                session.save(txn);
                //Commit transaction
                tx.commit();
                System.out.println("Transaction ID="+txn.getId());

                //Get Saved Trasaction Data
                printTransactionData(txn.getId(), sessionFactory);

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

        private static void printTransactionData(long id, SessionFactory sessionFactory) {
            Session session = null;
            Transaction tx = null;
            try{
                //Get Session
                //sessionFactory = Main.getSessionFactory();
                session = sessionFactory.getCurrentSession();
                //start transaction
                tx = session.beginTransaction();
                //Save the Model object
                Txn txn = (Txn) session.get(Txn.class, id);
                //Commit transaction
                tx.commit();
                System.out.println("Transaction Details=\n"+txn);

            }catch(Exception e){
                System.out.println("Exception occured. "+e.getMessage());
                e.printStackTrace();
            }
        }

        private static Txn buildDemoTransaction() {
            Txn txn = new Txn();
            txn.setDate(new Date());
            txn.setTotal(100);

            Customer cust = new Customer();
            cust.setAddress("Maharashtra, Us");
            cust.setEmail("naresh@gaml");
            cust.setName("Narsh Petkar");
            txn.setCustomer(cust);


            cust.setTxn(txn);
            return txn;



        }

    }

