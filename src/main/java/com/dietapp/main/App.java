//package com.dietapp.main;
//import org.hibernate.*;
//import com.dietapp.model.User;
//
//public class App {
//    public static void main(String[] args) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//
//        User u = new User();
//        u.setName("TestUser");
//        u.setAge(25);
//        u.setGender("male");
//        u.setHeight(175f);
//        u.setWeight(70f);
//        u.setActivityLevel("moderate");
//        u.setGoal("maintenance");
//
//        session.save(u);
//
//        tx.commit();
//        session.close();
//        HibernateUtil.shutdown();
//        System.out.println("Saved user id: " + u.getId());
//    }
//}
