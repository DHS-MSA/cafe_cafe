package com.system.cafe.service.info;

import com.system.cafe.domain.info.Info;
import com.system.cafe.domain.info.InfoRepository;
import com.system.cafe.domain.location.Location;
import com.system.cafe.domain.menu.Menu;
import com.system.cafe.web.dto.PageRequestDTO;
import com.system.cafe.web.dto.PageResultDTO;
import com.system.cafe.web.dto.info.InfoListResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Slf4j
@RequiredArgsConstructor
@Service
public class InfoServiceImpl implements InfoService{

    private final InfoRepository repository;

    @Override
    public PageResultDTO<InfoListResponseDto, Object[]> getInfoList(PageRequestDTO pageRequestDTO) {

        Function<Object[] , InfoListResponseDto> fn = (en -> new InfoListResponseDto((Info)en[0], (Location)en[1]));

        Page<Object[]> result = repository.getCafeInfoList(pageRequestDTO.getPageable(Sort.by("name")));


        return new PageResultDTO<>(result, fn);
    }
}
