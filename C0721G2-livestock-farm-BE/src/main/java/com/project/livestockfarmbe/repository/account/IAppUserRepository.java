package com.project.livestockfarmbe.repository.account;

import com.project.livestockfarmbe.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, UUID> {
    @Query(value = "SELECT * FROM app_users a join employees e on a.id = e.app_user_id where e.id =?1", nativeQuery = true)
    AppUser findByEmployee(String id);

}
