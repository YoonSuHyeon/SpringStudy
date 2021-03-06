package com.example.admin.repository;



import com.example.admin.model.entity.Item;
import com.example.admin.model.entity.OrderDetail;
import com.example.admin.model.entity.OrderGroup;
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
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
//@DataJpaTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)// JPA 테스트 관련 컴포넌트만 Import
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
@DisplayName("UserRepositoryTest 테스트")
public class UserRepositoryTest  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Autowired
    private OrderGroupRepository orderGroupRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        //String sql = insert into user(%s,%s,%d) value(account,email,age);
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";


        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User save = userRepository.save(user);
        User userFind = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        Assertions.assertThat(userFind).isNotNull();
        Assertions.assertThat(userFind).isSameAs(save);


    }
    @Transactional
    @Test
    public void read(){


        /*String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
       String createdBy = "AdminServer";


        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);
        */

        User save = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");


        save.getOrderGroupList().stream().forEach(it -> System.out.println("연관관계 = " + it));



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
