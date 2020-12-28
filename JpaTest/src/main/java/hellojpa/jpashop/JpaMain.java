package hellojpa.jpashop;

import hellojpa.jpashop.domain.Book;
import hellojpa.jpashop.domain.Order;
import hellojpa.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain
{

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try{
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");
            em.persist(book);
            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}