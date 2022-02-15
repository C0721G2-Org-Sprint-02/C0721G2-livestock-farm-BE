package com.project.livestockfarmbe.repository.cage;


import com.project.livestockfarmbe.model.cage.Cage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICageRepository extends PagingAndSortingRepository<Cage, String> {
    // kiểm tra nhân viên
//     Boolean existsByEmployee(String employeeId);
    @Query(value = "select * \n" +
            " from cages where id = :id ", nativeQuery = true)
    Optional<Cage> findById(@Param("id") String id);
}
