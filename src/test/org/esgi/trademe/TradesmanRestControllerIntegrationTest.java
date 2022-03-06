package org.esgi.trademe;

import org.esgi.trademe.kernel.hash.SHA256Engine;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TradesmanRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testCreateTradesmanithInvalidEmail() throws Exception {
        String expected = "paul@gmail is not a valid value for the field Email";
        String error = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/tradesman")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("first_name", "Paul")
                                .param("last_name", "Toto")
                                .param("email", "paul@gmail")
                                .param("birth", "31/10/1995")
                                .param("street_number", "2")
                                .param("street_name", "rue de la Paix")
                                .param("zip_code", "75002")
                                .param("city", "Paris")
                                .param("country", "FRANCE")
                                .param("username", "paultoto")
                                .param("password", "P@55w0rd"))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andReturn().getResolvedException().getMessage();
        Assert.assertEquals(error, expected);
    }

//    @Test
//    public void testCreateTradesmanWithInvalidFirstname() throws Exception {
//        String expected = "P@ul is not a valid value for the field Firstname";
//        String error = this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/tradesman")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .param("first_name", "P@ul")
//                                .param("last_name", "Barrié")
//                                .param("email", "paul@gmail.com")
//                                .param("birth", "10/31/1995")
//                                .param("street_number", "2")
//                                .param("street_name", "rue de la Paix")
//                                .param("zip_code", "75002")
//                                .param("city", "Paris")
//                                .param("country", "FRANCE")
//                                .param("username", "paulb")
//                                .param("password", "P@55w0rd"))
//                .andExpect(MockMvcResultMatchers.status().is(400))
//                .andReturn().getResolvedException().getMessage();
//        Assert.assertEquals(error, expected);
//    }
//
//    @Test
//    public void testCreateTradesmanWithInvalidLastname() throws Exception {
//        String expected = "Barri& is not a valid value for the field Lastname";
//        String error = this.mockMvc.perform(
//                        MockMvcRequestBuilders.post("/tradesman")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .param("first_name", "Paul")
//                                .param("last_name", "Barri&")
//                                .param("email", "paul@gmail.com")
//                                .param("birth", "10/31/1995")
//                                .param("street_number", "2")
//                                .param("street_name", "rue de la Paix")
//                                .param("zip_code", "75002")
//                                .param("city", "Paris")
//                                .param("country", "FRANCE")
//                                .param("username", "paulb")
//                                .param("password", "P@55w0rd"))
//                .andExpect(MockMvcResultMatchers.status().is(400))
//                .andReturn().getResolvedException().getMessage();
//        Assert.assertEquals(error, expected);
//    }

    @Test
    public void testCreateValidTradesman() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/tradesman")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("first_name", "Paulo")
                        .param("last_name", "Barrié")
                        .param("email", "paul@yahoo.com")
                        .param("birth", "31/10/1995")
                        .param("street_number", "2")
                        .param("street_name", "rue de la Paix")
                        .param("zip_code", "75002")
                        .param("city", "Paris")
                        .param("country", "FRANCE")
                        .param("username", "paulob")
                        .param("password", "P@55w0rd"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("Paulo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("Barrié"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("paul@yahoo.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.credentials.username").value("paulob"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.credentials.password").value(new SHA256Engine().encrypt("P@55w0rd")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address.streetNumber").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address.streetName").value("rue de la Paix"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address.zipCode").value("75002"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address.city").value("Paris"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address.country").value("FRANCE"));
    }
    
    @Test
    public void testAddTradesmanEducation() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/tradesman")
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
                .andDo(
                        result -> {
                            mockMvc.perform(MockMvcRequestBuilders.put("/tradesman/education")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .param("tradesman_id", "1")
                                    .param("domain", "ELECTRICITY")
                                    .param("level", "BAC"))
                                    .andExpect(MockMvcResultMatchers.status().is(200))
                                    .andExpect(MockMvcResultMatchers.content().string("BAC in ELECTRICITY domain added in tradesman 1 education."));
                        }
                );
    }

    @Test
    public void testAddTradesmanExperience() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/tradesman")
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
                .andDo(
                        result -> {
                            mockMvc.perform(MockMvcRequestBuilders.put("/tradesman/experience")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .param("tradesman_id", "1")
                                            .param("domain", "ELECTRICITY")
                                            .param("year", "1"))
//                                    .andExpect(MockMvcResultMatchers.status().is(200))
                                    .andDo(print())
                                    .andExpect(MockMvcResultMatchers.content().string("1 years experience in ELECTRICITY added to tradesman 1."));
                        }
                );
    }
}