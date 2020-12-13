package com.example.admin.repository;

import com.example.admin.model.entity.Item;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)// JPA 테스트 관련 컴포넌트만 Import
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
@DisplayName("ItemRepositoryTest 테스트")
class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("삼성 노트북" );
        item.setTitle("삼성 놑북 A100");
        item.setContent("2019년형 노트북 입니다.");
        item.setPrice(900000);
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        item.setPartnerId(2L);

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
    }
    @Test
    public void read(){
        Item item = new Item();
        item.setName("노트북");
        item.setPrice(100000);
        item.setContent("삼성 노트북");


        //select * from category where type = 'COMPUTER'
        Item newItem = itemRepository.save(item);

        Optional<Item> findItem = itemRepository.findById(1L);
        org.assertj.core.api.Assertions.assertThat(findItem.get()).isEqualTo(newItem);
    }

}