package jp.co.cybermissions.itspj.java.empmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.cybermissions.itspj.java.empmanager.model.Employee;
import jp.co.cybermissions.itspj.java.empmanager.model.Group;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  /** ログインIDをもとに1件取得する */
  public Employee findByLoginId(String loginId);

  /** グループが一致する情報を取得 */
  public List<Employee> findByGroups(Group group);
}
