package com.boot.works.springboot.config.auth;

import com.boot.works.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor

// 스프링 시큐리티 설정 활성화
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                // h2-console 사용을 위한 disable
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                // 권한 관리 대상을 지정하는 옵션의 시작점
                .authorizeRequests()
                // 권한 관리 대상 지정
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                // 로그아웃 기능에 대한 설정의 시작점
                .logout()
                // 로그아웃 성공 시 이동할 주소
                .logoutSuccessUrl("/")
                .and()
                // OAuth2 로그인 기능에 대한 설정의 시작점
                .oauth2Login()
                // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때 설정
                .userInfoEndpoint()
                // 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스 구현체 등록
                // 리소스 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 먕시
                .userService(customOAuth2UserService);
    }
}
