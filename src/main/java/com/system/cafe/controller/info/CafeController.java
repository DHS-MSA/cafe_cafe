package com.system.cafe.controller.info;

import com.system.cafe.service.cafe.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CafeController {

    private final CafeService cafeService;

    @GetMapping(value = "/mainList/currentLocation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> recommendList(@PathVariable String currentLocation) {
        Map<String, Object> resultMap = cafeService.getMainList(currentLocation);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping(value = "/cafeList" , produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<CafeListResponseDto>> infoList(){
//        return new ResponseEntity<>(cafeService.findInfoList(), HttpStatus.OK);
//    }
}
