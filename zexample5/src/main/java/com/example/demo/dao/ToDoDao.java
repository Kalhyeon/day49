package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.ToDo;

// 마이바티스에게 이 인터페이스의 객체를 만들어 스프링에 등록하라고 요청

@Mapper
public interface ToDoDao {
  @Insert("insert into todos(tno, job, writeday, finish) values(todos_seq.nextval, #{job}, sysdate, 0)")
  public Long save(ToDo toDo);
  
  @Select("select * from todos")
  public List<ToDo> findAll();
  
  @Update("update todos set finish=(finish-1)*-1 where tno=#{tno}")
  public Long update(Long tno);
  
  @Delete("delete from todos where tno=#{tno}")
  public Long delete(Long tno);
}
