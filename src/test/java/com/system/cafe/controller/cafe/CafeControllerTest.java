package com.system.cafe.controller.cafe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * https://tecoble.techcourse.co.kr/post/2020-08-18-spring-rest-docs/
 * https://backtony.github.io/spring/2021-10-15-spring-test-3/
 */
@AutoConfigureMockMvc // -> webAppContextSetup(webApplicationContext)
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "gospel306.synology.me", uriPort = 8090) // -> apply(documentationConfiguration(restDocumentation))
@SpringBootTest
public class CafeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(
                        get("/cafe/mainList/{currentLocation}", "1")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(
                        document("mainList-get", preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("currentLocation").description("현재 위치")
                                ),
                                responseFields(
                                        subsectionWithPath("categoryList").type(JsonFieldType.ARRAY).description("상단 카테고리 리스트"),
                                        subsectionWithPath("categoryList[].id").type(JsonFieldType.NUMBER).description("카테고리 ID"),
                                        subsectionWithPath("categoryList[].name").type(JsonFieldType.STRING).description("카테고리 이름"),
                                        subsectionWithPath("hotCafeList").type(JsonFieldType.ARRAY).description("HOT 매장 추천 리스트"),
                                        subsectionWithPath("hotCafeList[].uuid").type(JsonFieldType.STRING).description("카페 UUID"),
                                        subsectionWithPath("hotCafeList[].name").type(JsonFieldType.STRING).description("카페 이름"),
                                        subsectionWithPath("hotCafeList[].address").type(JsonFieldType.STRING).description("주소"),
                                        subsectionWithPath("hotCafeList[].rating").type(JsonFieldType.NUMBER).description("평점").optional(),
                                        subsectionWithPath("hotCafeList[].menuList").type(JsonFieldType.ARRAY).description("메뉴 리스트"),
                                        subsectionWithPath("hotCafeList[].menuList[].id").type(JsonFieldType.NUMBER).description("메뉴 ID").optional(),
                                        subsectionWithPath("hotCafeList[].menuList[].name").type(JsonFieldType.STRING).description("메뉴 이름").optional()
                                )
                        )
                );
    }
}
