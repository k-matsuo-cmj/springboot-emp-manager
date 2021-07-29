package jp.co.cybermissions.itspj.java.empmanager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 従業員モデルクラス
 */
@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
@ToString
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

  @ManyToMany
  @JoinTable(name = "EMPLOYEES_GROUPS")
  private List<Group> groups;

  @ManyToOne(optional = true)
  private Group mainGroup;
}
