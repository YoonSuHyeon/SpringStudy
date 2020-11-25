package com.example.admin.repository;



import com.example.admin.model.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@DataJpaTest                                                             // JPA 테스트 관련 컴포넌트만 Import
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
@DisplayName("UserRepositoryTest 테스트")
public class UserRepositoryTest  {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        //String sql = insert into user(%s,%s,%d) value(account,email,age);
        User user = new User();
        user.setAccount("TestUser1");
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

    }
    @Test
    public void update(){

    }
    @Test
    public void delete(){

    }
}
