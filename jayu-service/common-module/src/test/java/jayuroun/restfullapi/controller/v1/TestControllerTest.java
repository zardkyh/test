package jayuroun.restfullapi.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import jayuroun.restfullapi.ApiDocumentationUtils;
import jayuroun.restfullapi.config.JwtTokenProvider;
import jayuroun.restfullapi.model.req.TestRequest;
import jayuroun.restfullapi.service.TestService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;


import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * -------------------------------------------------------------------------------------
 * ::::::'OO::::'OOO::::'OO:::'OO:'OO::::'OO:'OOOOOOOO:::'OOOOOOO::'OO::::'OO:'OO....OO:
 * :::::: OO:::'OO OO:::. OO:'OO:: OO::::.OO: OO.....OO:'OO.....OO: OO:::: OO: OOO...OO:
 * :::::: OO::'OO:..OO:::. OOOO::: OO::::.OO: OO::::.OO: OO::::.OO: OO:::: OO: OOOO..OO:
 * :::::: OO:'OO:::..OO:::. OO:::: OO::::.OO: OOOOOOOO:: OO::::.OO: OO:::: OO: OO.OO.OO:
 * OO:::: OO: OOOOOOOOO:::: OO:::: OO::::.OO: OO.. OO::: OO::::.OO: OO:::: OO: OO..OOOO:
 * :OO::::OO: OO.....OO:::: OO:::: OO::::.OO: OO::. OO:: OO::::.OO: OO:::: OO: OO:..OOO:
 * ::OOOOOO:: OO:::..OO:::: OO::::. OOOOOOO:: OO:::. OO:. OOOOOOO::. OOOOOOO:: OO::..OO:
 * :......:::..:::::..:::::..::::::.......:::..:::::..:::.......::::.......:::..::::..::
 * <p>
 * TestControllerTest 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.common.controller.v1.TestControllerTest
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

@AutoConfigureRestDocs
@AutoConfigureMockMvc
@SpringBootTest()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TestService testService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private UserDetailsService userDetailsService;

    @BeforeAll
    void init() {

    }

    @Test
    void testDetail() throws Exception {

        //given
        String token = jwtTokenProvider.createToken(String.valueOf(1), Collections.singletonList("ROLE_USER") );
        TestRequest response = TestRequest.builder()
                .id(1L)
                .name("홍길동")
                .uid("uid")
                .build();

        given(userDetailsService.loadUserByUsername("1"))
                .willReturn(ApiDocumentationUtils.makeUserDetail(Collections.singletonList("ROLE_USER")));

        given(testService.detail(eq(1L)))
                .willReturn(response);

        //when
        ResultActions result = this.mockMvc.perform(
                RestDocumentationRequestBuilders.get("/common/test/{id}", 1L)
                        .header("X-AUTH-TOKEN", token)
                .accept(MediaType.APPLICATION_JSON)
        );

        //then
        result.andExpect(status().isOk())
                .andDo(document("test-detail",
                        ApiDocumentationUtils.getDocumentRequest(),
                        ApiDocumentationUtils.getDocumentResponse(),
                        ApiDocumentationUtils.getRequestHeaders(),
                        pathParameters(
                                parameterWithName("id").description("고유번호")
                        ),
                        ApiDocumentationUtils.setResponseFields().and(
                                fieldWithPath("data")
                                        .type(JsonFieldType.OBJECT)
                                        .description("에로 정보"),
                                fieldWithPath("data.id")
                                        .type(JsonFieldType.NUMBER)
                                        .description("테스트 고유번호"),
                                fieldWithPath("data.name")
                                        .type(JsonFieldType.STRING)
                                        .description("테스트 이름"),
                                fieldWithPath("data.uid")
                                        .type(JsonFieldType.STRING)
                                        .description("테스트 아이디")
                        )
                ));
    }



    @Test
    void postTest() throws Exception {

        //given
        String token = jwtTokenProvider.createToken(String.valueOf(1), Collections.singletonList("ROLE_USER") );
        TestRequest response = TestRequest.builder()
                .id(1L)
                .name("홍길동")
                .uid("uid")
                .build();

        given(userDetailsService.loadUserByUsername("1"))
                .willReturn(ApiDocumentationUtils.makeUserDetail(Collections.singletonList("ROLE_USER")));

        given(testService.detail(eq(1L)))
                .willReturn(response);

        //when
        ResultActions result = this.mockMvc.perform(
                RestDocumentationRequestBuilders.post("/common/test/{id}", 1L)
                        .header("X-AUTH-TOKEN", token)
                        .content(objectMapper.writeValueAsString(response))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        //then
        result.andExpect(status().isOk())
                .andDo(document("test-create",
                        ApiDocumentationUtils.getDocumentRequest(),
                        ApiDocumentationUtils.getDocumentResponse(),
                        ApiDocumentationUtils.getRequestHeaders(),
                        pathParameters(
                                parameterWithName("id").description("고유번호")
                        ),
                        requestFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("고유번호 생성은 0"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                fieldWithPath("uid").type(JsonFieldType.STRING).description("아이디")
                        ),
                        ApiDocumentationUtils.setResponseFields().and(
                                fieldWithPath("data")
                                        .type(JsonFieldType.OBJECT)
                                        .description("에로 정보"),
                                fieldWithPath("data.id")
                                        .type(JsonFieldType.NUMBER)
                                        .description("테스트 고유번호"),
                                fieldWithPath("data.name")
                                        .type(JsonFieldType.STRING)
                                        .description("테스트 이름"),
                                fieldWithPath("data.uid")
                                        .type(JsonFieldType.STRING)
                                        .description("테스트 아이디"))
                ));
    }
}
