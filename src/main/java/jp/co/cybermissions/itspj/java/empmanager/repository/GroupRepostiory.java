package jp.co.cybermissions.itspj.java.empmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.cybermissions.itspj.java.empmanager.model.Group;

public interface GroupRepostiory extends JpaRepository<Group, Integer> {
  
}
