package jp.co.cybermissions.itspj.java.empmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.cybermissions.itspj.java.empmanager.model.Group;
import jp.co.cybermissions.itspj.java.empmanager.service.AdminService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/adm/groups")
@RequiredArgsConstructor
public class AdminGroupController {

  private final AdminService service;

  @GetMapping("")
  public String getGroupList(Model model) {
    model.addAttribute("groupList", service.getGroupList());
    return "group/list";
  }

  @GetMapping("/new")
  public String getNewGroup(@ModelAttribute Group group) {
    return "group/new";
  }

  @PostMapping("")
  public String postNewGroup(@ModelAttribute Group group) {
    // TODO 登録処理
    return "redirect:/adm/groups";
  }

  @GetMapping("/{id}")
  public String getGroup(@PathVariable int id, Model model) {
    model.addAttribute("group", service.getGroup(id));
    return "group/edit";
  }

  @PatchMapping("/{id}")
  public String updateGroup(@PathVariable int id, @ModelAttribute Group group) {
    // TODO バリデーション
    service.updateGroup(id, group);
    return "redirect:/adm/groups";
  }

  @DeleteMapping("/{id}")
  public String deleteGroup(@PathVariable int id) {
    // TODO 削除処理
    return "redirect:/adm/groups";
  }

}
