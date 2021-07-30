package jp.co.cybermissions.itspj.java.empmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.cybermissions.itspj.java.empmanager.model.Group;
import jp.co.cybermissions.itspj.java.empmanager.repository.GroupRepostiory;
import jp.co.cybermissions.itspj.java.empmanager.service.AdminService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

  private final GroupRepostiory groupRep;

  @Override
  public List<Group> getGroupList() {
    return groupRep.findAll();
  }

}
