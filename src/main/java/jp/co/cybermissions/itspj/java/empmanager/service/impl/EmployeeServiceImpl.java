package jp.co.cybermissions.itspj.java.empmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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

  
}
