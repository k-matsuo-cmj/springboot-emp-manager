package jp.co.cybermissions.itspj.java.empmanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.cybermissions.itspj.java.empmanager.form.ProfileForm;
import jp.co.cybermissions.itspj.java.empmanager.form.validator.ProfileFormValidator;
import jp.co.cybermissions.itspj.java.empmanager.model.Group;
import jp.co.cybermissions.itspj.java.empmanager.service.ProfileService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/prof")
@RequiredArgsConstructor
public class ProfileController {

  private final ProfileService service;
  private final ProfileFormValidator validator;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.addValidators(validator);
  }

  @GetMapping("")
  public String getProfile(Model model) {
    model.addAttribute("profileForm", service.getLoginProfile());
    return "emp/profile";
  }

  @PostMapping("")
  public String postProfile(@Validated @ModelAttribute ProfileForm form, BindingResult result) {
    if (result.hasErrors()) {
      // グループだけ取り直す
      List<Group> groups = service.getLoginProfile().getGroups();
      form.setGroups(groups);
      return "emp/profile";
    }
    service.updateLoginProfile(form);
    return "redirect:/emp";
  }
}
