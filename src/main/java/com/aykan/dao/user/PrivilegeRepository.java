package com.aykan.dao.user;

import com.aykan.domain.user.Privilege;

import java.util.List;

public interface PrivilegeRepository {
    Privilege savePrivilege(Privilege privilege);

    Privilege updatePrivilege(Privilege privilege);

    Privilege deletePrivilege(Privilege privilege);

    Privilege findPrivilegeById(Long id);

    Privilege findPrivilegeByName(String privilegeName);

    List<Privilege> findAllPrivileges();
}
