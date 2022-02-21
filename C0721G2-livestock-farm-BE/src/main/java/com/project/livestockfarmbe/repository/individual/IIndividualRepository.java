package com.project.livestockfarmbe.repository.individual;

import com.project.livestockfarmbe.model.individual.Individual;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public interface IIndividualRepository extends JpaRepository<Individual,String> {

    @Query(value = "select *  from individuals where  id like concat('%',:individualId,'%') and  " +
            " cage_id like concat('%',:cageId,'%') and date_in like concat('%',:dateIn,'%') and " +
            " date_out like concat('%',:dateOut,'%') and status like concat('%',:status,'%') " +
            "and deleted = false", nativeQuery = true)
    Page<Individual> searchIndividual(@Param("individualId") String individualId,@Param("cageId") String cageId,
                                     @Param("dateIn") String dateIn, @Param("dateOut") String dateOut,
                                      @Param("status") String status, Pageable pageable);

    @Query(value = "select * from livestock_farm.inviduals where id = :id",nativeQuery = true)
    Optional<Individual> findIndividualById(@Param("id") String id);

}
