package com.wjz.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class MockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mock1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/index_1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void mock2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/index_2")).andExpect(MockMvcResultMatchers.status().is5xxServerError());
    }

    @Test
    public void mock3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/index_3")).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getOutputStream().println();
    }
}
