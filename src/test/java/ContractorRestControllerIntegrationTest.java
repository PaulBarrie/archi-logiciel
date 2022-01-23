import org.esgi.trademe.Configuration;
import org.esgi.trademe.ExceptionController;
import org.esgi.trademe.kernel.hash.SHA256Engine;
import org.esgi.trademe.contractor.exposition.ContractorController;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Configuration.class, ExceptionController.class})
@Import(ContractorController.class)
@WebMvcTest(controllers = ContractorController.class)
public class ContractorRestControllerIntegrationTest {

    @Autowired
    WebApplicationContext wac;


    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testCreateValidContractor() throws Exception {
        this.mockMvc.perform(post("/contractor")
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
    public void testCreateContractorWithInvalidEmail() throws Exception {
        String expected = "paul@gmail is not a valid value for the field Email";
        String error = this.mockMvc.perform(
                post("/contractor")
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
                .andExpect(status().is(400))
                .andReturn().getResolvedException().getMessage();
        assertEquals(error, expected);
    }

    @Test
    public void testCreateContractorWithInvalidFirstname() throws Exception {
        String expected = "P@ul is not a valid value for the field Firstname";
        String error = this.mockMvc.perform(
                        post("/contractor")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("first_name", "P@ul")
                                .param("last_name", "Barrié")
                                .param("email", "paul@gmail.com")
                                .param("birth", "10/31/1995")
                                .param("street_number", "2")
                                .param("street_name", "rue de la Paix")
                                .param("zip_code", "75002")
                                .param("city", "Paris")
                                .param("country", "FRANCE")
                                .param("username", "paulb")
                                .param("password", "P@55w0rd"))
                .andExpect(status().is(400))
                .andReturn().getResolvedException().getMessage();
        assertEquals(error, expected);
    }

    @Test
    public void testCreateContractorWithInvalidLastname() throws Exception {
        String expected = "Barri& is not a valid value for the field Lastname";
        String error = this.mockMvc.perform(
                        post("/contractor")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("first_name", "Paul")
                                .param("last_name", "Barri&")
                                .param("email", "paul@gmail.com")
                                .param("birth", "10/31/1995")
                                .param("street_number", "2")
                                .param("street_name", "rue de la Paix")
                                .param("zip_code", "75002")
                                .param("city", "Paris")
                                .param("country", "FRANCE")
                                .param("username", "paulb")
                                .param("password", "P@55w0rd"))
                .andExpect(status().is(400))
                .andReturn().getResolvedException().getMessage();
        assertEquals(error, expected);
    }


    @Test
    public void testGetOneContractor() throws Exception {
        this.mockMvc.perform(get("/contractors")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void testGetAllContractors() throws Exception {
        this.mockMvc.perform(get("/contractors")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }
}