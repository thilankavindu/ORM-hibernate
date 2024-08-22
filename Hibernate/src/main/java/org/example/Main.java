package org.example;

import org.example.config.FactoryConfiguration;
import org.example.embed.FullName;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session= FactoryConfiguration.getInstance().getSession();
        FullName fullName = new FullName("KAVINDU","THILAN");
        Student student = new Student();
        student.setId(1);
        student.setName(fullName);
        student.setAddress("Rathnapura");

        //session.save(student);
        Transaction transaction = session.beginTransaction();
        //session.save(student);
        //session.delete(student);
        Student st = session.get(Student.class,1);

        if (st!=null){
            System.out.println(st.getId());
            System.out.println(st.getAddress());
            System.out.println(st.getName().getFirstName());
            System.out.println(st.getName().getLastName());
        }

        transaction.commit();
        session.close();

    }
}