package com.project.livestockfarmbe.service.account.impl;




import com.project.livestockfarmbe.model.account.Role;
import com.project.livestockfarmbe.repository.account.IRoleRepository;
import com.project.livestockfarmbe.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;


    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }
}
