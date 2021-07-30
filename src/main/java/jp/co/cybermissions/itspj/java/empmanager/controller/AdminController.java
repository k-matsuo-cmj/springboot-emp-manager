package jp.co.cybermissions.itspj.java.empmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.cybermissions.itspj.java.empmanager.form.EmployeeForm;
import jp.co.cybermissions.itspj.java.empmanager.service.AdminService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/adm")
@RequiredArgsConstructor
public class AdminController {

  private final AdminService service;

  @GetMapping("/emp/new")
  public String getNewEmployee(@ModelAttribute EmployeeForm form, Model model) {
    model.addAttribute("groupList", service.getGroupList());
    return "emp/new";
  }

  @PostMapping("/emp")
  public String postNewEmployee() {
    return "redirect:/emp";
  }
}
