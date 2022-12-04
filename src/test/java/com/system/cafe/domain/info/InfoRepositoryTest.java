package com.system.cafe.domain.info;

import com.querydsl.core.Tuple;
import com.system.cafe.web.dto.info.InfoListResponseDto;
import com.system.cafe.web.dto.info.RecommendInfoListDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
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

    @Transactional
    @Test
    public void InfoCustomRepository_recommendCafeInfoList_test() {
        List<RecommendInfoListDTO> list = infoCustomRepository.findRecommendList();

        list.forEach(item -> System.out.println(item));
    }
}