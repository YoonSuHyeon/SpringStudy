package hellojpa;

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
            /*수정*/
            Member member = em.find(Member.class, 1L);
            member.setName("HelloJPA");
            ts.commit();
            
            /*삭제
            Member member = em.find(Member.class, 1L);
            System.out.println("member.getId() = " + member.getId());
            System.out.println("member = " + member);
            em.remove(member);*/
            /* 등록
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);
            ts.commit();*/
        }catch (Exception e){
            ts.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
