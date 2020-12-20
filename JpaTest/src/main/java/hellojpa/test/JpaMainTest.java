package hellojpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainTest
{

   /* public static void main(String[] args) {
      //  EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

      //  EntityManager em = emf.createEntityManager();
       // EntityTransaction ts = em.getTransaction();
    //    ts.begin();

        try{

            //영속
           // Member member1 = new Member(150L, "A");
            //Member member2 = new Member(160L, "B");

           // em.persist(member1);
           // em.persist(member2);
          //  System.out.println("=====================");
          //  ts.commit();

            /*
            //비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");
            //영속
            System.out.println("=== BEFORE ===" );
            em.persist(member);
            System.out.println("=== AFTER ===" );


            //1차캐시를 저장하기 때문에 select문을 하지 않는다.
            Member findMember = em.find(Member.class, 101L);
            */


            //지우는것
            //em.detach(member);
            
            
            
            /*수정
             
            Member member = em.find(Member.class, 1L);
            member.setName("HelloJPA");
            ts.commit();*/
            
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
        /*}catch (Exception e){
            ts.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }*/
}
