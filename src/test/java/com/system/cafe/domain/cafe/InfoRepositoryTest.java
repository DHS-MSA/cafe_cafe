package com.system.cafe.domain.cafe;

import com.system.cafe.dto.cafe.CafeListResponseDto;
import com.system.cafe.dto.cafe.RecommendInfoListDTO;
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

}