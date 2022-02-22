package com.project.livestockfarmbe.service.account;


import com.project.livestockfarmbe.model.account.Role;

public interface IRoleService {
    Role findRoleByName(String name);

    Role getRoleById(Long id);
}
