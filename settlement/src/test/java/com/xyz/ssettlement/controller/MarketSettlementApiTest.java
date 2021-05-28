package com.xyz.ssettlement.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.myit.settlement.SettlementApp;
import com.myit.settlement.response.MarketSettlementMessage;

@SpringBootTest(classes=SettlementApp.class)
public class MarketSettlementApiTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
    
	private MockMvc mockMvc;
	
	MarketSettlementMessage msm = new MarketSettlementMessage();
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders
	    		.webAppContextSetup(webApplicationContext)
	    		.build();
	}
	
	@Test
	public void createNewSettlementTest() throws Exception {

		String trade = "{\r\n"
				+ "  \"tradeId\": \"16846548\",\r\n"
				+ "  \"ssiCode\": \"OCBC_DBS_1\",\r\n"
				+ "  \"amount\" : 12894.65,\r\n"
				+ "  \"currency\" : \"USD\",\r\n"
				+ "  \"valueDate\" : 20022020\r\n"
				+ "}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/createNewMarketSettlement")
				.contentType(MediaType.APPLICATION_JSON).content(trade)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}	
	
	
	@Test
	public void fetchMarketSettlementTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/fetchMarketSettlement/16800001");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void fetchMarketSettlementNotFoundTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/fetchMarketSettlement/16800011");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
	}
}