package interview.controller.web;

import interview.model.TedTalkInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CRUDController.class)
public class CRUDControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void addTedTalk() throws Exception {
        TedTalkInformation tedTalkInformation = TedTalkInformation.builder()
                .urlInformation("http://2323432.com")
//                .author(new AuthorInformation())
                .authorInteractionDate(new Date())
                .likes(new Long(100))
                .views(new Long(50))
                .title("myTitle")
                .build();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/addTedTalk");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

    }
}
