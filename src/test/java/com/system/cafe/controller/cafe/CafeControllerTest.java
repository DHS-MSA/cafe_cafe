package com.system.cafe.controller.cafe;

import com.system.cafe.service.cafe.CafeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// import문을 잘 확인해야 합니다.
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * https://tecoble.techcourse.co.kr/post/2020-08-18-spring-rest-docs/
 * https://backtony.github.io/spring/2021-10-15-spring-test-3/
 */
@AutoConfigureMockMvc // -> webAppContextSetup(webApplicationContext)
@AutoConfigureRestDocs // -> apply(documentationConfiguration(restDocumentation))
@SpringBootTest
public class CafeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CafeService cafeService;

    @Test
    void findAll() throws Exception {

        mockMvc.perform(
                get("/cafe/mainList/{currentLocation}", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(
                        document("mainList-get",
                                pathParameters(
                                        parameterWithName("currentLocation").description("현재 위치")
                                )
//                                ,
//                                responseFields(
//
//                                        fieldWithPath("categoryList").description("상단 카테고리 리스트"),
//                                        fieldWithPath("hotCafeList").description("HOT 매장 추천")
//                                )
                        )
                );
    }
}
