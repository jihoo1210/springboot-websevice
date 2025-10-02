package com.boot.works.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션이 적용될 수 있는 위치
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)

// @interface: 어노테이션 클래스로 지정
public @interface LoginUser {
}
