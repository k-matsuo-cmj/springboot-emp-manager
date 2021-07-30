package jp.co.cybermissions.itspj.java.empmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.cybermissions.itspj.java.empmanager.model.Employee;
import jp.co.cybermissions.itspj.java.empmanager.repository.EmployeeRepository;
import jp.co.cybermissions.itspj.java.empmanager.service.EmployeeService;
import lombok.RequiredArgsConstructor;

/**
 * 従業員画面用のコントローラークラス
 */
@Controller
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeRepository rep;
  private final EmployeeService service;

  @GetMapping("")
  public String getList(@RequestParam(name = "gid", required = false) Integer groupId, Model model) {
    model.addAttribute("empList", service.getEmployeeList(groupId));
    model.addAttribute("groupList", service.getGroupList());
    return "emp/list";
  }

  @GetMapping("/{id}")
  public String getDetail(@PathVariable int id, Model model) {
    Employee emp = rep.findById(id).get();
    model.addAttribute("emp", emp);
    return "emp/detail";
  }
}
