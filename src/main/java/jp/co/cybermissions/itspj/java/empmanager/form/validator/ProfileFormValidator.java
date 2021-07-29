package jp.co.cybermissions.itspj.java.empmanager.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import jp.co.cybermissions.itspj.java.empmanager.form.ProfileForm;

@Component
public class ProfileFormValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    // ProfileFormクラスを対象
    return ProfileForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    // ProfileFormにキャスト
    ProfileForm form = (ProfileForm) target;
    String pwd1 = form.getPassword();
    String pwd2 = form.getPasswordConfirm();

    if (pwd1.isBlank() && pwd2.isBlank()) {
      // パスワードが空白の場合は確認しない
      return;
    }
    if (!pwd1.equals(pwd2)) {
      // エラー
      errors.rejectValue("passwordConfirm", "ProfileFormValidator.passwordConfirm", "パスワードが一致しません");
    }
  }

}
