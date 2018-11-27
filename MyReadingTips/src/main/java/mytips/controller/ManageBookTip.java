/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.controller;

import java.util.List;
import java.util.Date;
import java.util.Iterator;
import mytips.model.BookTip;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mmohamud
 */
public class ManageBookTip {
    
    SessionFactory factory;
    
    public ManageBookTip() {
        try {
            this.factory = new Configuration()
                    .configure("/resource/hibernate.cfg.xml")
                    .addAnnotatedClass(BookTip.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    /* Method to CREATE an booktip in the database */
    public Integer addBookTip(String author, String title, String ISBN, String summary, String Comment) {
        Session session = this.factory.openSession();
        Transaction tx = null;
        Integer booktipID = null;

        try {
            tx = session.beginTransaction();
            BookTip booktip = new BookTip();
            booktip.setAuthor(author);
            booktip.setTitle(title);
            booktip.setISBN(ISBN);
            booktip.setSummary(summary);
            booktip.setComment(Comment);

            booktipID = (Integer) session.save(booktip);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return booktipID;
    }

    /* Method to  READ all the booktips */
    public void listBookTips() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM BookTip").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
                BookTip booktip = (BookTip) iterator.next();
                System.out.print("Author: " + booktip.getAuthor());
                System.out.print("  Title: " + booktip.getTitle());
                System.out.println("  ISBN: " + booktip.getISBN());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an booktip from the records */
    public void deleteBookTip(Integer booktipID) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            BookTip booktip = (BookTip) session.get(BookTip.class, booktipID);
            session.delete(booktip);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
