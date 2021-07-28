package jp.co.cybermissions.itspj.java.empmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.cybermissions.itspj.java.empmanager.service.ProfileService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/prof")
@RequiredArgsConstructor
public class ProfileController {

  private final ProfileService service;

  @GetMapping("")
  public String getProfile(Model model) {
    model.addAttribute("emp", service.getLoginProfile());
    return "emp/profile";
  }

  @PostMapping("")
  public String postProfile() {
    return "redirect:/emp";
  }
}
