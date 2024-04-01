package com.example.chatserver.documentation;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.epages.restdocs.apispec.Schema;
import com.example.chatserver.config.ControllerTestConfig;
import com.example.chatserver.controller.ChatController;
import com.example.chatserver.facade.ChatFacade;
import com.example.chatserver.fixture.ChatRequestFixture;
import com.google.api.client.json.Json;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;

import static com.epages.restdocs.apispec.ResourceDocumentation.parameterWithName;
import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChatController.class)
class ChatControllerDocumentation extends ControllerTestConfig {

    @MockBean
    ChatFacade chatFacade;

    @Test
    void documentStompEndpoint() throws Exception {

        mockMvc.perform(
                        get("/websocket-endpoint")
                                .header("Authorization", testToken())

                )
                .andDo(document("stomp connect endpoint",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        resource(
                                ResourceSnippetParameters.builder()
                                        .tag("소켓 연결 정보")
                                        .description("stomp connect endpoint url 주소")
                                        .build()
                        )
                ));

    }

    private static String testToken() {
        return "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhdXRob3JpemF0aW9uIiwidXNlclV1aWQiOiI0NmQ5NjBmNTY1LTJhZTItNDE5My05NmZkLTMxYjZhODc1NzYxMSIsInJvbGUiOiJOT1JNQUwiLCJleHAiOjQ4NjQwMDQxODZ9.VGC6EJmCBdevtfSQspqsdu42FFl25dSBSHvHue6mAhE";
    }

//    @Test
//    void documentStompPub() throws Exception {
//
//        String requestBody = objectMapper.writeValueAsString(ChatRequestFixture.make());
//
//        mockMvc.perform(post("/pub/chat/{chat-room-no}",1)
//                        .content(requestBody)
//                        .header("Authorization", testToken()))
//                .andDo(document("stomp publish(전송 - send) url",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        resource(
//                                ResourceSnippetParameters.builder()
//                                        .tag("소켓 연결 정보")
//                                        .description("stomp publish (send) url 주소")
//                                        .pathParameters(
//                                                parameterWithName("chat-room-no").description("채팅방 idx")
//                                        )
//                                        .requestFields(
//                                                fieldWithPath("sender").type(JsonFieldType.STRING).description(""),
//                                                fieldWithPath("senderUuid").type(JsonFieldType.STRING).description("보내는 사람 user uuid"),
//                                                fieldWithPath("imgUrl").type(JsonFieldType.STRING).description("보내는 사람 프로필 img url"),
//                                                fieldWithPath("msg").type(JsonFieldType.STRING).description("전송 메세지 내용")
//                                        )
//                                        .requestFields()
//                                        .responseFields()
//                                        .requestSchema(Schema.schema("ChatRequest"))
//                                        .build()
//                        )
//                ));
//    }
//
//    @Test
//    void documentStompSub() throws Exception {
//
//        mockMvc.perform(post("/sub/chat/{chat-room-no}",1)
//                        .content("stomp 구독(subscribe) url")
//                        .header("Authorization", testToken()))
//                .andDo(document("stomp subscribe(구독) url",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        resource(
//                                ResourceSnippetParameters.builder()
//                                        .tag("소켓 연결 정보")
//                                        .description("stomp subscribe url 주소")
//                                        .pathParameters(
//                                                parameterWithName("chat-room-no").description("채팅방 idx")
//                                        )
//                                        .requestFields()
//                                        .responseFields(
//                                                fieldWithPath("chatIdx").type(JsonFieldType.STRING).description(""),
//                                                fieldWithPath("sender").type(JsonFieldType.STRING).description(""),
//                                                fieldWithPath("senderUuid").type(JsonFieldType.STRING).description("보내는 사람 user uuid"),
//                                                fieldWithPath("msg").type(JsonFieldType.STRING).description("보내는 사람 프로필 img url"),
//                                                fieldWithPath("imgUrl").type(JsonFieldType.STRING).description("전송 메세지 내용"),
//                                                fieldWithPath("dateTime").type(JsonFieldType.STRING).description("전송 메세지 내용")
//                                        )
//                                        .build()
//                        )
//                ));
//    }
}
