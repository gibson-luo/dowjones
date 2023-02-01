package gibson.exam.dowjones.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HealthControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void healthShouldReturn200() throws Exception {
        this.mockMvc.perform(get("/v1/health")).andDo(print()).andExpect(status().isOk());
    }
}
