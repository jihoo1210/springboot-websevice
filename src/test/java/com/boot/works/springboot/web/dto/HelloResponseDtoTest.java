package com.boot.works.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

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
