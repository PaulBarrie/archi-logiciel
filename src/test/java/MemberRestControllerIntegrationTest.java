import org.esgi.trademe.Configuration;
import org.esgi.trademe.kernel.hash.SHA256Engine;
import org.esgi.trademe.member.exposition.MemberController;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuration.class)
@Import(MemberController.class)
@WebMvcTest(controllers = MemberController.class)
public class MemberRestControllerIntegrationTest {

    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testCreateValidMember() throws Exception {
        this.mockMvc.perform(post("/member")
                .contentType(MediaType.APPLICATION_JSON)
                .param("first_name", "Paul")
                .param("last_name", "Barrié")
                .param("email", "paul@gmail.com")
                .param("birth", "31/10/1995")
                .param("street_number", "2")
                .param("street_name", "rue de la Paix")
                .param("zip_code", "75002")
                .param("city", "Paris")
                .param("country", "FRANCE")
                .param("username", "paulb")
                .param("password", "P@55w0rd"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id.value").value(1))
                .andExpect(jsonPath("$.firstname").value("Paul"))
                .andExpect(jsonPath("$.lastname").value("Barrié"))
                .andExpect(jsonPath("$.email").value("paul@gmail.com"))
                .andExpect(jsonPath("$.birth").value("31/10/1995"))
                .andExpect(jsonPath("$.credentials.username").value("paulb"))
                .andExpect(jsonPath("$.credentials.password").value(new SHA256Engine().encrypt("P@55w0rd")))
                .andExpect(jsonPath("$.address.streetNumber").value("2"))
                .andExpect(jsonPath("$.address.streetName").value("rue de la Paix"))
                .andExpect(jsonPath("$.address.zipCode").value("75002"))
                .andExpect(jsonPath("$.address.city").value("Paris"))
                .andExpect(jsonPath("$.address.country").value("FRANCE"));
    }

    @Test
    public void testCreateMemberWithInvalidEmail() throws Exception {
        String expected = "paul@gmail is not a valid value for the field Email";
        MockHttpServletResponse response = this.mockMvc.perform(post("/member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("first_name", "Paul")
                        .param("last_name", "Barrié")
                        .param("email", "paul@gmail")
                        .param("birth", "31/10/1995")
                        .param("street_number", "2")
                        .param("street_name", "rue de la Paix")
                        .param("zip_code", "75002")
                        .param("city", "Paris")
                        .param("country", "FRANCE")
                        .param("username", "paulb")
                        .param("password", "P@55w0rd"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.EXPECTATION_FAILED.value());
        assertThat(response.getContentAsString()).isEqualTo(expected);
    }

    @Test
    public void testGetAllMembers() throws Exception {
        this.mockMvc.perform(get("/members")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }
}