package com.boot.works.springboot.web;

import com.boot.works.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다
// SpringRunner.class 실행자를 실행시킨다
@RunWith(SpringRunner.class)

//스프링 테스트 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션
//@Controller, @ControllerAdvice 등을 사용할 수 있다
//@Service, @Component, @Repository 등을 사용할 수 없다
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    // 웹 API를 테스트할 때 사용
    // 스프링 MVC 테스트의 시작점
    private MockMvc mvc;

    @Test
    public void returnHello() throws Exception{
        String hello = "hello";

        // get 요청 보냄
        mvc.perform(get("/hello"))
                // status 검증, 200인지 확인
                .andExpect(status().isOk())
                // 응답 본문의 내용 검증
                .andExpect(content().string(hello));
    }

    @Test
    public void lombokTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        //assertThat: assertj라는 테스트 검증 라이브러리의 검증 메소드
        //isEqualTo: assertj의 동등 비교 메소드
        /* JUnit vs assertj:
            assertj의 장점
            1. 추가적인 라이브러리 필요없음
            - Junit에서 자동적으로 라이브러리에 등록
            - Junit은 CoreMatcher 라이브러리 필요
            2. 확실한 자동완성 지원
         */

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
