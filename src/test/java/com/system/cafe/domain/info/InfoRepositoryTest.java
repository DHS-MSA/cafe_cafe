package com.system.cafe.domain.info;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InfoRepositoryTest {

    @Autowired
    InfoRepository infoRepository;

    @Test
    public void InfoRepositoy_save_test() {

        Info info = Info.builder()
                .user_id("tester3")
                .build();

        infoRepository.save(info);
    }
}