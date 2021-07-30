package jp.co.cybermissions.itspj.java.empmanager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GROUPS")
@Getter
@Setter
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @NotNull
  @NotBlank
  @Size(max = 100)
  private String name;
  @Min(1)
  private int sortOrder;

  @ManyToMany(mappedBy = "groups")
  private List<Employee> employees;
}
