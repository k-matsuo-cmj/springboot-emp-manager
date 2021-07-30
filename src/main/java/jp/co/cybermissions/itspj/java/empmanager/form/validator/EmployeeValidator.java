package jp.co.cybermissions.itspj.java.empmanager.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import jp.co.cybermissions.itspj.java.empmanager.form.EmployeeForm;
import jp.co.cybermissions.itspj.java.empmanager.model.Group;

@Component
public class EmployeeValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    // EmployeeFormクラスを対象
    return EmployeeForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    // EmployeeFormにキャスト
    EmployeeForm form = (EmployeeForm) target;

    // パスワード検証
    String pwd1 = form.getPassword();
    String pwd2 = form.getPasswordConfirm();
    if (!pwd1.equals(pwd2)) {
      // エラー
      errors.rejectValue("passwordConfirm", "EmployeeValidator.passwordConfirm", "パスワードが一致しません");
    }

    // 代表グループ検証
    int[] groupIds = form.getGroupIds();
    Group mainGroup = form.getMainGroup();
    if (mainGroup != null) {
      boolean isMatch = false;
      for (int i = 0; i < groupIds.length; i++) {
        if (groupIds[i] == mainGroup.getId()) {
          isMatch = true;
          break;
        }
      }
      if (!isMatch) {
        // エラー
        errors.rejectValue("mainGroup.id", "EmployeeValidator.mainGroup.id", "代表グループが不正です");
      }
    }
  }

}
