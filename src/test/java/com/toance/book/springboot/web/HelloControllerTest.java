package com.toance.book.springboot.web;

import com.toance.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) // mvc.perform의 결과 검증
                .andExpect(content().string(hello)); // mvc.perform의 결과 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                    get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)) // param의 경우 값으로 string만 허용
                )
                .andExpect(status().isOk()) // mvc.perform의 결과 검증
                .andExpect(jsonPath("$.name", is(name))) // mvc.perform의 결과 검증
                .andExpect(jsonPath("$.amount", is(amount))); // mvc.perform의 결과 검증
    }
}
