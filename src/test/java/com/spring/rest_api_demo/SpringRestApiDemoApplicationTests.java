package com.spring.rest_api_demo;

import com.spring.rest_api_demo.configuration.WebSecurityConfiguration;
import com.spring.rest_api_demo.controller.ApiController;
import com.spring.rest_api_demo.service.CalculateService;
import com.spring.rest_api_demo.service.CalculateServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SpringRestApiDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	void contextLoads() {
	}

	@Test
	@WithMockUser
	public void should_Add_When_APIAddRequest() throws Exception {
		mockMvc.perform(post("/api/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"x\":\"10\",\"y\":\"1\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.result").value("11"));
	}

	@Test
	@WithMockUser
	public void should_Diff_When_APIDiffRequest() throws Exception {
		mockMvc.perform(post("/api/diff")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"x\":\"10\",\"y\":\"1\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.result").value("9"));
	}

	@Test
	@WithMockUser
	public void should_Error_When_Invalid_APIAddRequest() throws Exception {
		mockMvc.perform(post("/api/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"x\":\"10\",\"y\":\"a\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(400));
	}
}
