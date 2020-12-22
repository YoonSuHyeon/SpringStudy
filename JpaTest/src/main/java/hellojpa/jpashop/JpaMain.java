package hellojpa.jpashop;

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
            Order order = new Order();
            order.addOrderItem(new OrderItem());
            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}