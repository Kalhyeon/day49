package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ToDoDao;
import com.example.demo.entity.ToDo;

@SpringBootTest
public class DaoTest {
  @Autowired
  ToDoDao toDoDao;
  
//  @Test
  public void test1() {
    System.out.println(toDoDao);
  }
  
  @Transactional
  @Test
  public void saveTest() {
    ToDo toDo = new ToDo();
    toDo.setJob("Hello MyBatis");
    Long result = toDoDao.save(toDo);
    System.out.println(result==1);
  }
}
