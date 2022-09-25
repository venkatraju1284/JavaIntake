package interview.controller.web;

import interview.model.TedTalkInformation;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CRUDControllerTest {

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

        this.mockMvc.perform(post("/tedtalks//add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(tedTalkInformation.toString()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void updateTedTalk() throws Exception {

        TedTalkInformation tedTalkInformation = TedTalkInformation.builder()
                .urlInformation("http://2323432.com")
//                .author(new AuthorInformation())
                .authorInteractionDate(new Date())
                .likes(new Long(100))
                .views(new Long(50))
                .title("myTitle")
                .build();

        this.mockMvc.perform(post("/tedtalks/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(tedTalkInformation.toString()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }

    @Test
    void removeTedTalk() {
    }

    @Test
    void getTedTalk() throws Exception {

        this.mockMvc.perform(get("/tedtalks/users/123"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getTedTalksByAuthor() throws Exception {
        this.mockMvc.perform(get("/tedtalks/authors/123"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getTedTalksByTitle() throws Exception {
        this.mockMvc.perform(get("/tedtalks/titiles/123"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getTedTalksByLikes() throws Exception {
        this.mockMvc.perform(get("/tedtalks/like?from=123&to=4334"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getTedTalksByShares() throws Exception {

        this.mockMvc.perform(get("/tedtalks/views?from=123&to=4334"))
                .andExpect(status().is2xxSuccessful());
    }
}