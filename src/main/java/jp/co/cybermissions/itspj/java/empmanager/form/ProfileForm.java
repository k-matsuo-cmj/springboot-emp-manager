package jp.co.cybermissions.itspj.java.empmanager.form;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jp.co.cybermissions.itspj.java.empmanager.model.Group;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileForm {
  @NotBlank
  @Size(max = 100)
  private String name;
  @Size(max = 100)
  private String kana;
  private String loginId;
  @Email
  private String email;
  private String password;
  private String passwordConfirm;

  private List<Group> groups;

  private Group mainGroup;
}
