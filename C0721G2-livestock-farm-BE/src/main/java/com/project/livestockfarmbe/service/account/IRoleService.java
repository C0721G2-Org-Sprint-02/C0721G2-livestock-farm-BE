package com.project.livestockfarmbe.service.account;

import com.project.livestockfarmbe.model.account.Role;
import org.springframework.stereotype.Service;

@Service
public interface IRoleService {

    // DoanhNV
    Role getRoleById(Long id);
}
