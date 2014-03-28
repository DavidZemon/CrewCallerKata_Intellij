package com.uprr.training.controller.crewCaller;

import com.uprr.training.controller.AbstractContextControllerTests;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
public class CrewCallerControllerTest extends AbstractContextControllerTests {


    private static final String ANOTHER_REQUEST =
            " { \"trainDate\" : \"2013-09-15\", " +
                    "\"departTime\" : \"2013-09-15T10:09:08Z\", " +
                    "\"trainSymbol\" : \"ZLAMN\" } ";
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
    }

    @Ignore
    @Test
    public void testMissingUser() throws Exception {
        this.mockMvc.perform(
                get("/crewCaller/sampleRequest?locationCirc7=MX283&track=001&yard=01")
                        .accept(MediaType.APPLICATION_JSON)  //requests a JSON Response
        )
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("\"count\":42")))
                .andExpect(content().string(containsString("\"ping\":\"Pong\"")))
                .andExpect(content().string(containsString("\"userId\":\"UNKNOWN\"")))
                .andExpect(content().string(containsString("\"employeeId\":null")))
                .andExpect(content().string(containsString("\"springAmazing\":true")))
                .andExpect(content().string(containsString("\"when\":\"2013-12-11T10:09:08Z\"")))
                .andExpect(content().string(containsString("\"springFacts\":[")))
                .andExpect(content().string(containsString("{\"factName\":\"fails fast\",\"fact\":true}")))
                .andExpect(content().string(containsString("{\"factName\":\"testable\",\"fact\":true}")))
                .andExpect(content().string(containsString("{\"factName\":\"clear\",\"fact\":true}")))
                .andExpect(content().string(containsString("{\"factName\":\"easy\",\"fact\":false}")));
    }

    @Ignore
    @Test
    public void testAnotherRequest() throws Exception {
        this.mockMvc.perform(
                post("/crewCaller/anotherRequest", "json")
                        .contentType(MediaType.APPLICATION_JSON)  //input is JSON
                        .accept(MediaType.APPLICATION_JSON)       //requests a JSON Response
                        .content(ANOTHER_REQUEST.getBytes())
        )
                .andExpect(content().string("Read from JSON: JavaBean {trainDate=[9/15/2013], departTime=[05:09:08 CENTRAL] trainSymbol=[ZLAMN]}"));
    }

    /*
     * This test checks the SampleGlobalExceptionHandler class.  The errors returned here appear
     * fairly rudimentary, but it's important to remember that these are fail safe
     * validations - the primary responsibility for UI validation belongs in the UI layer
     * (Angular, by present standards))
     * @throws Exception
     */

    @Ignore
    @Test
    public void testSampleGlobalExceptionHandler() throws Exception {
        mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().is(400)).build();  //400 indicates application error
        MvcResult resultMvc = this.mockMvc.perform(
                get("/crewCaller/sampleRequest?track=A")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("SMUSER", "test999")
        )
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("{\"errors\":[\"Required String parameter 'locationCirc7' is not present (locationCirc7 : String)\"]}")))
                .andReturn();
        System.out.println(">>RESP: " + resultMvc.getResponse().getContentAsString());
    }

}
