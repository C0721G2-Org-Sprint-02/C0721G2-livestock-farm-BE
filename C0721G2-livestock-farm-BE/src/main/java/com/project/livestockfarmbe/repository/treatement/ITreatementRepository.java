package com.project.livestockfarmbe.repository.treatement;

import com.project.livestockfarmbe.model.treatement.Treatement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITreatementRepository extends JpaRepository< Treatement, String > {
//    @Query(value = " select * \n" +
//            " from treatements ", nativeQuery = true, countQuery = " select count(*) from treatements ")
//    Page<Treatement> findAllTreatementsByFilter(@Param("doctor") String doctor,
//                                                @Param("kindOfDisease")String kindOfDisease,
//                                                @Param("cage")String cage,
//                                                Pageable pageable);
    @Query(value = " select * \n " +
            " from treatements tr join individuals ind on tr.individual_id = ind.id \n " +
            " where doctor like concat('%',trim(:doctor),'%')\n " +
            " and kind_of_disease like concat('%',trim(:kindOfDisease),'%')\n " +
            " and cage_id like concat('%',trim(:cage),'%')\n " +
            " and tr.deleted = 0 ", nativeQuery = true, countQuery = " select count(*) from treatements tr join individuals ind on tr.individual_id = ind.id \n " +
            " where doctor like concat('%',trim(:doctor),'%')\n " +
            " and kind_of_disease like concat('%',trim(:kindOfDisease),'%')\n " +
            " and cage_id like concat('%',trim(:cage),'%')\n " +
            " and tr.deleted = 0 ")
    Page<Treatement> findAllTreatementsByFilter(@Param("doctor")String doctor,
            @Param("kindOfDisease")String kindOfDisease,
            @Param("cage")String cage,
            Pageable pageable);
}
