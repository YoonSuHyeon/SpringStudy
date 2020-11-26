package com.example.admin.repository;



import com.example.admin.model.entity.Item;
import com.example.admin.model.entity.OrderDetail;
import com.example.admin.model.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@DataJpaTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)// JPA 테스트 관련 컴포넌트만 Import
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
@DisplayName("UserRepositoryTest 테스트")
public class UserRepositoryTest  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        //String sql = insert into user(%s,%s,%d) value(account,email,age);
        User user = new User();
        user.setAccount("TestUser3");
        user.setEmail("TestUser1@naver.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");
        User user1 = userRepository.save(user);
        System.out.println("user1 = " + user1);


        User user3 = new User();
        user3.setAccount("TestUser1");
        user3.setEmail("TestUser1@naver.com");
        user3.setPhoneNumber("010-1111-1111");
        user3.setCreatedAt(LocalDateTime.now());
        user3.setCreatedBy("admin");
        User user4 = userRepository.save(user3);
        System.out.println("user1 = " + user4);
    }
    @Test
    public void read(){
        Optional<User> id = userRepository.findById(3L);
        User user = id.get();
        List<OrderDetail> orderDetailList = user.getOrderDetailList();
        orderDetailList.stream().forEach(it-> System.out.println("it = " + it));


    }
    @Test
    public void update(){
        User user = new User();
        user.setAccount("TestUser1");
        user.setEmail("TestUser1@naver.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");
        User user1 = userRepository.save(user);
        System.out.println("user1 = " + user1);

        Optional<User> user2 = userRepository.findById(1L);
        if(user2.isPresent()){
            user2.get().setAccount("pppp");
            user2.get().setUpdatedAt(LocalDateTime.now());
            user2.get().setUpdatedBy("update method()");

            userRepository.save(user2.get());
        }
        Optional<User> user5 = userRepository.findById(1L);
        System.out.println("user5 = " + user5);




    }
    @Test
    public void delete(){
        User user = new User();
        user.setAccount("TestUser1");
        user.setEmail("TestUser1@naver.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");
        User user1 = userRepository.save(user);
        System.out.println("user1 = " + user1);

        Optional<User> user2 = userRepository.findById(1L);

        user2.ifPresent(value -> userRepository.delete(value));
        Optional<User> user4 = userRepository.findById(1L);
        System.out.println("user4 = " + user4.isPresent());
    }
}
