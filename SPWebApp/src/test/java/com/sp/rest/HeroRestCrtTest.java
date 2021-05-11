package com.sp.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sp.model.Hero;
import com.sp.service.HeroService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HeroRestCrt.class)
public class HeroRestCrtTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private HeroService hService;

	Hero mockHero=new Hero(1, "jdoe", "strong", 100, "https//url.com");
	
	@Test
	public void retrieveHero() throws Exception {
		Mockito.when(
				hService.getHero(Mockito.anyInt())
				).thenReturn(mockHero);
				

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hero/50").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expectedResult="{\"id\":1,\"name\":\"jdoe\",\"superPowerName\":\"strong\",\"superPowerValue\":100,\"imgUrl\":\"https//url.com\"}";


		JSONAssert.assertEquals(expectedResult, result.getResponse()
				.getContentAsString(), false);
	}

}

