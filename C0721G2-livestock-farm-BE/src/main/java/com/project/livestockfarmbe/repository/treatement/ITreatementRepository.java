package com.project.livestockfarmbe.repository.treatement;

import com.project.livestockfarmbe.model.treatement.Treatement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Modifying
    @Transactional
    @Query(value = "insert into treatement (doctor, kind_of_disease, medicine, note, quantily, treatement_date, individual_id) " +
            " values (:doctor,:kind_of_disease,:medicine,:note,:quantily,:individual_id)", nativeQuery = true)
    Treatement saveNews(@Param("doctor") String doctor, @Param("kind_of_disease") String kind_of_disease,
                     @Param("medicine") String medicine, @Param("note") String note, @Param("quantily") Integer quantily,
                     @Param("individual_id") String individual_id);

}
