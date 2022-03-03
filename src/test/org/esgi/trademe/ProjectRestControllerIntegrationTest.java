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

}
