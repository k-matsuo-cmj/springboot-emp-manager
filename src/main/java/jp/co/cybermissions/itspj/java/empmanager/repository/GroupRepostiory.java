package jp.co.cybermissions.itspj.java.empmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.cybermissions.itspj.java.empmanager.model.Group;

public interface GroupRepostiory extends JpaRepository<Group, Integer> {

  /** 表示順でソートした一覧を取得する */
  List<Group> findAllByOrderBySortOrder();

  /** 同じ表示順の情報を取得する */
  List<Group> findBySortOrder(int sortOrder);
}
