package com.system.cafe.domain.info;

import com.querydsl.core.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class InfoRepositoryTest {

    @Autowired
    InfoRepository infoRepository;

    @Autowired
    InfoCustomRepository infoCustomRepository;

    @Test
    public void InfoRepository_save_test() {

        Info info = Info.builder()
                .userId("tester3")
                .build();

        infoRepository.save(info);
    }

    @Test
    public void InfoRepository_findById_Test(){
        infoRepository.findById(3L);
    }

    @Test
    public void InfoRepository_findAll_Test(){
        infoRepository.findAll();
    }

    @Test
    public void InfoCustomRepository_recommendCafeInfoList_test() {
        List<Tuple> list = infoCustomRepository.recommendCafeInfoList();

        list.forEach(item -> System.out.println(item));
    }
}