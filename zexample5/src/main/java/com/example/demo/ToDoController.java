package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ToDoDao;
import com.example.demo.entity.ToDo;

@Controller
public class ToDoController {
  @Autowired
  private ToDoDao toDoDao;
  
//  ToDo 목록
  @GetMapping({"/","/list"})
  public String list(Model model) {
    List<ToDo> todos = toDoDao.findAll();
    model.addAttribute("todos", todos);
    return "list";
  }
  
//  ToDo 를 작성하는 화면 보이기
  @GetMapping("/write")
  public String write() {
    return "write";
  }
  
//  ToDo 를 작성 => 목록으로 이동
  @PostMapping("/write")
  public String write(@RequestParam String job) {
    ToDo toDo = ToDo.builder().job(job).build();
    toDoDao.save(toDo);
    return "redirect:/";
  }
  
//  ToDo 삭제 => 목록으로 이동
  
//  ToDo 변경 => 목록으로 이동
  @PostMapping("/update")
  public String update(@RequestParam Long tno) {
    toDoDao.update(tno);
    return "redirect:/";
  }
}
