package jp.co.cybermissions.itspj.java.empmanager.service;

import jp.co.cybermissions.itspj.java.empmanager.form.ProfileForm;

public interface ProfileService {

  /** ログインしている従業員の情報を取得する */
  public ProfileForm getLoginProfile();

  /** ログインしている従業員の情報を更新する */
  public void updateLoginProfile(ProfileForm form);
}
