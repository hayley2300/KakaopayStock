package com.contoller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.service.Services;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
	@InjectMocks
	private Controller contoller;
	
	@Mock
    private Services services;
    
	@Autowired
	private MockMvc mockMvc;

	@Before    
	public void init() {
		   mockMvc = MockMvcBuilders.standaloneSetup(contoller).build();
	}
	
	
    @Test
    @DisplayName("Requirement1 Controller Test")
    public void require1Test() throws Exception {
        mockMvc.perform(get("/test/require1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Requirement2 Controller Test")
    public void require2Test() throws Exception {
        mockMvc.perform(get("/test/require2"))
                .andExpect(status().isOk());
    }

    
    @Test
    @DisplayName("Requirement3 Controller Test")
    public void require3Test() throws Exception {
        mockMvc.perform(get("/test/require3"))
                .andExpect(status().isOk());
    }

    
    @Test
    @DisplayName("Requirement4 Controller Test")
    public void require4Test() throws Exception {
    	
    	String testString = "{\"brName\":\"테스트점\"}";
    	
        mockMvc.perform(post("/test/require4")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(testString)
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        		
    }


	
}
