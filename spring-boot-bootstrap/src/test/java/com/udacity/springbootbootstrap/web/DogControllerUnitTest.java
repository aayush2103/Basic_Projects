package com.udacity.springbootbootstrap.web;

import com.udacity.springbootbootstrap.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DogService dogService;

    @Test
    public void getAllDogs() throws Exception{
        mockMvc.perform(get("/dogs/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).findAllDogs();
    }

    @Test
    public void getBreedById() throws Exception{
        mockMvc.perform(get("/dogs/breeds/1"))
                .andExpect(status().isOk());

        verify(dogService, times(1)).retrieveDogBreedById(new Long(2));
    }
}
