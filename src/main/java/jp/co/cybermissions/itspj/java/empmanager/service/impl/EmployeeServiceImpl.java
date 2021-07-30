package jp.co.cybermissions.itspj.java.empmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.cybermissions.itspj.java.empmanager.model.Employee;
import jp.co.cybermissions.itspj.java.empmanager.model.Group;
import jp.co.cybermissions.itspj.java.empmanager.repository.EmployeeRepository;
import jp.co.cybermissions.itspj.java.empmanager.repository.GroupRepostiory;
import jp.co.cybermissions.itspj.java.empmanager.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository empRep;
  private final GroupRepostiory groupRep;

  @Override
  public List<Group> getGroupList() {
    return groupRep.findAll();
  }

  @Override
  public List<Employee> getEmployeeList(Integer groupId) {
    if (groupId == null) {
      // グループIDがnullの場合(デフォルト)
      List<Employee> empList = empRep.findAll();
      return empList;
    } else {
      // グループを条件に含めて取得
      Group group = groupRep.findById(groupId).orElse(null);
      List<Employee> empList = empRep.findByGroups(group);
      return empList;
    }
  }

  @Override
  public Employee getEmployee(int empId) {
    return empRep.findById(empId).get();
  }

}
