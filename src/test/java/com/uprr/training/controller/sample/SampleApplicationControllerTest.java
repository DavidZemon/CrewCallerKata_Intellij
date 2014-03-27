package com.uprr.training.controller.sample;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.*;

import com.uprr.training.controller.AbstractContextControllerTests;
import com.uprr.ui.shared.user.ActiveUserId;

@RunWith(SpringJUnit4ClassRunner.class)
public class SampleApplicationControllerTest extends AbstractContextControllerTests {

	
	private static final String ANOTHER_REQUEST = 
			" { \"trainDate\" : \"2013-09-15\", " +
			   "\"departTime\" : \"2013-09-15T10:09:08Z\", " +
			   "\"trainSymbol\" : \"ZLAMN\" } ";
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
	}

	@Test
	public void testSampleRequest() throws Exception {
		this.mockMvc.perform(
				get("/sample/sampleRequest?track=001&locationCirc7=MX283&yard=01")
					.accept(MediaType.APPLICATION_JSON)  //requests a JSON Response
					.header(ActiveUserId.SMHEADER_USER, "test999")         //Places a userid on the header for the userid lookup to use
					.header(ActiveUserId.SMHEADER_EMPLOYEE_ID, "1234")     //Places a employee Id on the header for the userid lookup to use
				)        
				.andExpect( content().contentType(MediaType.APPLICATION_JSON) )
				.andExpect(content().string(containsString("\"count\":42")))
                .andExpect(content().string(containsString("\"ping\":\"Pong\"")))
                .andExpect(content().string(containsString("\"userId\":\"test999\"")))
                .andExpect(content().string(containsString("\"employeeId\":\"1234\"")))
                .andExpect(content().string(containsString("\"springAmazing\":true")))
                .andExpect(content().string(containsString("\"when\":\"2013-12-11T10:09:08Z\"")))
                .andExpect(content().string(containsString("\"springFacts\":[")))
                .andExpect(content().string(containsString("{\"factName\":\"fails fast\",\"fact\":true}")))
                .andExpect(content().string(containsString("{\"factName\":\"testable\",\"fact\":true}")))
                .andExpect(content().string(containsString("{\"factName\":\"clear\",\"fact\":true}")))
                .andExpect(content().string(containsString("{\"factName\":\"easy\",\"fact\":false}")));
	}
	
	@Test
	public void testMissingUser() throws Exception {
		this.mockMvc.perform(
				get("/sample/sampleRequest?locationCirc7=MX283&track=001&yard=01")
					.accept(MediaType.APPLICATION_JSON)  //requests a JSON Response					
				)        
				.andExpect( content().contentType(MediaType.APPLICATION_JSON) )
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

	@Test
	public void testAnotherRequest() throws Exception {
		this.mockMvc.perform(
				post("/sample/anotherRequest", "json")
					.contentType(MediaType.APPLICATION_JSON)  //input is JSON
					.accept(MediaType.APPLICATION_JSON)       //requests a JSON Response
					.content(ANOTHER_REQUEST.getBytes()))
				.andExpect(content().string("Read from JSON: JavaBean {trainDate=[9/15/2013], departTime=[05:09:08 CENTRAL] trainSymbol=[ZLAMN]}"));
	}
	
	/*
	 * This test checks the SampleGlobalExceptionHandler class.  The errors returned here appear 
	 * fairly rudimentary, but it's important to remember that these are fail safe 
	 * validations - the primary responsibility for UI validation belongs in the UI layer 
	 * (Angular, by present standards))
	 * @throws Exception
	 */
	@Test
	public void testSampleGlobalExceptionHandler() throws Exception {
		mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().is(400)).build();  //400 indicates application error
		MvcResult resultMvc = this.mockMvc.perform(
				get("/sample/sampleRequest?track=A")
					.accept(MediaType.APPLICATION_JSON)
					.header("SMUSER", "test999")
					)
					.andExpect( content().contentType(MediaType.APPLICATION_JSON) )
					.andExpect(content().string(containsString("{\"errors\":[\"Required String parameter 'locationCirc7' is not present (locationCirc7 : String)\"]}")))
					.andReturn();
		System.out.println(">>RESP: "+resultMvc.getResponse().getContentAsString());
	}
	
}
