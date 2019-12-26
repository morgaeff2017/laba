/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_db;

import edb.Gruppyi;
import edb.Studentyi;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author 17687
 */
public class Lab1_DB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // создаём объект sf типа SessionFacory в который записываем то, что вернул нам 
        //метод getSessionFactory класса NewHibernateUtil
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        // создаём объект s типа Session и записываем туда то, что вернул метод openSession() объекта sf
        Session s = sf.openSession();
        //создаём запрос
        Query q = s.createQuery("from Gruppyi g");
        //создаём список с с типом данных Gruppyi в который записываем то,что вернул нам метод list
        List<Gruppyi> gruppyi = q.list();
        //заполняем список через цкил
        for (Gruppyi group : gruppyi)
        {
            List<Studentyi> students = group.getStudentyis();
            for(Studentyi student : students){
                System.out.println(student.getNomerZachetki());
    
                System.out.println(student.getGruppyi());
                System.out.println(student.getFamiliya());
               System.out.println( student.getImya());
               System.out.println( student.getOtchestvo());
            }
        }   
        s.close();
        sf.close();
    }
    
}
