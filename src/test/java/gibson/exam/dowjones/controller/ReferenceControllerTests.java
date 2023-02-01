package gibson.exam.dowjones.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import gibson.exam.dowjones.pojo.Reference;
import gibson.exam.dowjones.service.ReferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ReferenceControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReferenceService referenceService;

    static final String TEST_FLAG_STOCK = "TEST";

    public static Reference getMockObj() {
        Reference reference = new Reference();
        reference.setQuarter(1);
        reference.setStock(TEST_FLAG_STOCK);
        reference.setDate("1/7/2012");
        reference.setOpen("$15.82");
        reference.setHigh("$16.72");
        reference.setLow("$15.78");
        reference.setClose("$16.42");
        reference.setVolume("239655616");
        return reference;
    }

    public static MockMultipartFile getMockFile() {
        String content = "quarter,stock,date,open,high,low,close,volume,percent_change_price,percent_change_volume_over_last_wk,previous_weeks_volume,next_weeks_open,next_weeks_close,percent_change_next_weeks_price,days_to_next_dividend,percent_return_next_dividend\n" +
                "1,TEST,1/7/2011,$15.82,$16.72,$15.78,$16.42,239655616,3.79267,,,$16.71,$15.97,-4.42849,26,0.182704\n" +
                "1,TEST,1/14/2011,$16.71,$16.71,$15.64,$15.97,242963398,-4.42849,1.380223028,239655616,$16.19,$15.79,-2.47066,19,0.187852\n";
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "test.csv",
                MediaType.TEXT_PLAIN_VALUE,
                content.getBytes()
        );
        return file;
    }

    @Test
    public void shouldReturnCreatedWhenSave() throws Exception {
        this.mockMvc.perform(post("/v1/reference/save")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getMockObj())))
                .andDo(print())
                .andExpect(status().isCreated());

        tidyUp();
    }

    @Test
    public void shouldReturnFailWhenSaveTwoSameRecords() throws Exception {
        this.mockMvc.perform(post("/v1/reference/save")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getMockObj())))
                .andDo(print());

        this.mockMvc.perform(post("/v1/reference/save")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getMockObj())))
                .andDo(print())
                .andExpect(status().is5xxServerError());

        tidyUp();
    }

    @Test
    public void shouldReturnListWhenFetchByTicker() throws Exception {
        this.mockMvc.perform(post("/v1/reference/save")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(getMockObj())))
                .andDo(print())
                .andExpect(status().isCreated());

        this.mockMvc.perform(get("/v1/reference/fetchByTicker")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("ticker", getMockObj().getStock()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result[0].stock").value(getMockObj().getStock()));

        tidyUp();
    }

    @Test
    public void shouldReturnOkWhenImportData() throws Exception {
        this.mockMvc.perform(multipart("/v1/reference/importData").file(getMockFile()))
                .andExpect(status().isOk());
    }

    public void tidyUp() {
        QueryWrapper<Reference> wrapper = new QueryWrapper<>();
        referenceService.remove(wrapper.eq("stock", TEST_FLAG_STOCK));
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
