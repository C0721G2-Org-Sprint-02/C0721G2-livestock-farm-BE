package com.project.livestockfarmbe.repository.buyIndividual;

import com.project.livestockfarmbe.model.buyIndividual.BuyIndividual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuyIndividualRepository extends JpaRepository<BuyIndividual, String> {

    @Query(value= "insert into buy_individuals (`name`, phone_number, email, address, content) " +
            "value (:name, :phone_number, :email, :address, :content)", nativeQuery = true )
    void saveBuyIndividual(@Param("name") String name, @Param("phone_number") String phoneNumber,
                           @Param("email") String email, @Param("address") String address,
                           @Param("content") String content);
}
