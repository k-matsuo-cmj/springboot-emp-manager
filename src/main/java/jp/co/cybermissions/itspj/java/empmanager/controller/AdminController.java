package jp.co.cybermissions.itspj.java.empmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.cybermissions.itspj.java.empmanager.form.EmployeeForm;
import jp.co.cybermissions.itspj.java.empmanager.form.validator.EmployeeValidator;
import jp.co.cybermissions.itspj.java.empmanager.service.AdminService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/adm")
@RequiredArgsConstructor
public class AdminController {

  private final AdminService service;
  private final EmployeeValidator empValidator;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.addValidators(empValidator);
  }

  @GetMapping("/emp/new")
  public String getNewEmployee(@ModelAttribute EmployeeForm form, Model model) {
    model.addAttribute("groupList", service.getGroupList());
    return "emp/new";
  }

  @PostMapping("/emp")
  public String postNewEmployee(@Validated @ModelAttribute EmployeeForm form, BindingResult result, Model model) {
    // バリデーションエラー
    if (result.hasErrors()) {
      return getNewEmployee(form, model);
    }
    // 正常時
    service.createEmployee(form);
    return "redirect:/emp";
  }

  @DeleteMapping("/emp/{id}")
  public String deleteEmployee(@PathVariable int id) {
    service.deleteEmployee(id);
    return "redirect:/emp";
  }
}
