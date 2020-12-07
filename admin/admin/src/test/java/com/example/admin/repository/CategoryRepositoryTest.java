package com.example.admin.repository;

import com.example.admin.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {


    @Autowired
    private  CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type = "COMPUTER";
        String tilte = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(tilte);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assertions.assertNotNull(newCategory);
        org.assertj.core.api.Assertions.assertThat(newCategory).isSameAs(category);

    }

    @Test
    public void read(){

        //생성
        String type = "COMPUTER";
        String tilte = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(tilte);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);



        //조회
        Optional<Category> categoryRepositoryById = categoryRepository.findById(newCategory.getId());

        categoryRepositoryById.ifPresent(c->{
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());

            org.assertj.core.api.Assertions.assertThat(c).isSameAs(newCategory);
        });


    }

}