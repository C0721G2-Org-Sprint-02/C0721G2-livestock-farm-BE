package com.project.livestockfarmbe.service.account.impl;

import com.project.livestockfarmbe.repository.account.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppUserServiceImpl {

    @Autowired
    IAppUserRepository appUserRepository;

    // DoanhNV kiểm tra username
    public boolean existsByUserName(String username) {
        return appUserRepository.existsByUsername(username);
    }

}
