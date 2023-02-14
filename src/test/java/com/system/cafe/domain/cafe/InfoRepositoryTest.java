package com.system.cafe.domain.cafe;

import com.system.cafe.dto.info.CafeListResponseDto;
import com.system.cafe.dto.info.RecommendInfoListDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class InfoRepositoryTest {

    @Autowired
    CafeRepository infoRepository;

    @Autowired
    CafeCustomRepository infoCustomRepository;

    @Test
    public void InfoRepository_save_test() {

        Cafe info = Cafe.builder()
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

    @Transactional
    @Test
    public void InfoCustomRepository_findInfoList_Test(){
        List<CafeListResponseDto> list = infoCustomRepository.findInfoList();
        list.forEach(item -> System.out.println(item));
    }
}