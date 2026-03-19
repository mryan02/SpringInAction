// package com.ryan.mifsud.taco_cloud.application;


// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import static org.hamcrest.Matchers.containsString;

// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// @WebMvcTest(HomeController.class)
// public class HomeControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @Test
//     void home_returnsHomePage() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.get("/"))
//         .andExpect(MockMvcResultMatchers.status().isOk())
//         .andExpect(MockMvcResultMatchers.view().name("home"))
//         .andExpect(MockMvcResultMatchers.content().string(containsString("taco")));

//     }   
// }
