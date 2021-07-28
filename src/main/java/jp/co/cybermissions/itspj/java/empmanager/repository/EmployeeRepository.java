package jp.co.cybermissions.itspj.java.empmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.cybermissions.itspj.java.empmanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  /** ログインIDをもとに1件取得する */
  public Employee findByLoginId(String loginId);
}
