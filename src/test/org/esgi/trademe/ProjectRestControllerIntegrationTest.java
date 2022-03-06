package org.esgi.trademe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateValidProject() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/project")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("contractor_id", "1")
                        .param("day_duration", "25")
                        .param("location", "Toulouse"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void addContractToProject() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/project")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("contractor_id", "1")
                        .param("day_duration", "25")
                        .param("location", "Toulouse"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(
                        result -> {
                            mockMvc.perform(MockMvcRequestBuilders.post("/project/contract")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .param("project_id", "1")
                                            .param("nb_hours", "70")
                                            .param("hourly_wage", "15")
                                            .param("work_domain", "PLUMBING"))
                                    .andExpect(MockMvcResultMatchers.status().is(200))
                                    .andExpect(MockMvcResultMatchers.jsonPath("$.contract.contractID.value").value(1))
                                    .andExpect(MockMvcResultMatchers.jsonPath("$.contract.projectID.value").value(1))
                                    .andExpect(MockMvcResultMatchers.jsonPath("$.contract.hourlyWage").value(15))
                                    .andExpect(MockMvcResultMatchers.jsonPath("$.contract.nbHours").value(70))
                                    .andExpect(MockMvcResultMatchers.jsonPath("$.contract.workDomain").value("PLUMBING"))
                                    .andExpect(MockMvcResultMatchers.jsonPath("$.contract.contractStatus").value("PENDING"));
                        }
                );
    }

    @Test
    public void activateProject() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/project")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("contractor_id", "1")
                        .param("day_duration", "25")
                        .param("location", "Toulouse"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(
                        result -> {
                            mockMvc.perform(MockMvcRequestBuilders.put("/project/activate")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .param("project_id", "1"))
                                    .andExpect(MockMvcResultMatchers.status().is(200))
                                    .andExpect(MockMvcResultMatchers.content().string("Project 1 activated by tradesman"));
                        }
                );
    }

//    @Test
//    public void assignTradesmenToProject() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/tradesman")
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("first_name", "Paulo")
//                .param("last_name", "Barrié")
//                .param("email", "paul@yahoo.com")
//                .param("birth", "31/10/1995")
//                .param("street_number", "2")
//                .param("street_name", "rue de la Paix")
//                .param("zip_code", "75002")
//                .param("city", "Paris")
//                .param("country", "FRANCE")
//                .param("username", "paulob")
//                .param("password", "P@55w0rd"));
//        mockMvc.perform(MockMvcRequestBuilders.put("/tradesman/education")
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("tradesman_id", "1")
//                .param("domain", "ELECTRICITY")
//                .param("level", "BAC"));
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/tradesman")
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("first_name", "Kévin")
//                .param("last_name", "Barrié")
//                .param("email", "kevin@yahoo.com")
//                .param("birth", "31/10/1995")
//                .param("street_number", "2")
//                .param("street_name", "rue de la Paix")
//                .param("zip_code", "75002")
//                .param("city", "Paris")
//                .param("country", "FRANCE")
//                .param("username", "kevinb")
//                .param("password", "P@55w0rd"));
//        mockMvc.perform(MockMvcRequestBuilders.put("/tradesman/education")
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("tradesman_id", "2")
//                .param("domain", "ELECTRICITY")
//                .param("level", "BAC"));
//
//        // Create project with contracts
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/project")
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("contractor_id", "1")
//                .param("day_duration", "25")
//                .param("location", "Toulouse"));
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/project/contract")
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("project_id", "1")
//                .param("hourly_wage", "56")
//                .param("nb_hours", "Toulouse")
//                .param("work_domain", "ELECTRICITY"));
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/project/contract")
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("project_id", "1")
//                .param("hourly_wage", "25")
//                .param("nb_hours", "85")
//                .param("work_domain", "ELECTRICITY"));
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/project/tradesmen/match")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .param("project_id", "1"))
//                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.project.contractList.[0].tradesmanID.value").value("1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.project.contractList.[1].tradesmanID.value").value("1"));


//    }
}
