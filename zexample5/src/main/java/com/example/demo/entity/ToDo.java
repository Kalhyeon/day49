package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 스프링에서 사용하는 모든 클래스는 반드시 기본 생성자가 있어야 한다.
// 스프링이 관리하는 객체를 스프링 빈이라고 한다.
// 스프링이 객체를 생성할 때 기본 생성자를 사용한다.
// 마이바티스 역시 기본 생성자가 필수이다.
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
  private Long tno;
  private String job;
  private LocalDate writeday;
  private Boolean finish;
}
