package jp.co.cybermissions.itspj.java.empmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jp.co.cybermissions.itspj.java.empmanager.form.EmployeeForm;
import jp.co.cybermissions.itspj.java.empmanager.model.Employee;
import jp.co.cybermissions.itspj.java.empmanager.model.Group;
import jp.co.cybermissions.itspj.java.empmanager.repository.EmployeeRepository;
import jp.co.cybermissions.itspj.java.empmanager.repository.GroupRepostiory;
import jp.co.cybermissions.itspj.java.empmanager.service.AdminService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

  private final GroupRepostiory groupRep;
  private final EmployeeRepository empRep;
  private final PasswordEncoder passwordEncoder;

  @Override
  public List<Group> getGroupList() {
    return groupRep.findAll();
  }

  @Override
  public void createEmployee(EmployeeForm form) {
    // form->Employeeに変換
    Employee emp = new Employee();
    emp.setName(form.getName());
    emp.setKana(form.getKana());
    emp.setLoginId(form.getLoginId());
    emp.setEmail(form.getEmail());
    emp.setPassword(passwordEncoder.encode(form.getPassword()));
    emp.setAdmin(form.isAdmin());
    List<Group> groups = new ArrayList<>();
    for (int i = 0; i < form.getGroupIds().length; i++) {
      int groupId = form.getGroupIds()[i];
      groupRep.findById(groupId).map(g -> groups.add(g));
    }
    emp.setGroups(groups);
    emp.setMainGroup(form.getMainGroup());

    // 登録
    empRep.save(emp);
  }

  @Override
  public void deleteEmployee(int id) {
    // 削除
    empRep.deleteById(id);
  }

  @Override
  public Group getGroup(int id) {
    // 1件取得
    return groupRep.findById(id).get();
  }

  @Override
  public void updateGroup(int id, Group group) {
    // IDを設定
    group.setId(id);
    // 更新
    groupRep.save(group);
  }

}
