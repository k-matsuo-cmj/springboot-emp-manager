package jp.co.cybermissions.itspj.java.empmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * 従業員モデルクラス
 */
@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @NotNull
  @Size(max = 100)
  private String name;
  @Size(max = 100)
  private String kana;
  @NotNull
  @Size(max = 100)
  private String loginId;
  private String email;
  @NotNull
  private String password;

  private boolean admin;
}
