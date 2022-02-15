package com.project.livestockfarmbe.service.individual.impl;

import com.project.livestockfarmbe.model.individual.Individual;
import com.project.livestockfarmbe.repository.individual.IIndividualRepository;
import com.project.livestockfarmbe.service.individual.IIndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class IndividualServiceImpl implements IIndividualService {
    @Autowired
    private IIndividualRepository iIndividualRepository;

    @Override
    public Page<Individual> findAllIndividual(int page, int size, String sortField, String sortDirection, String individualId, String cageId, String dateIn, String dateOut, String status) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return iIndividualRepository.searchIndividual(individualId,cageId,dateIn,dateOut,status,pageable);
    }

    @Override
    public Individual findIndividualById(String id) {
        return iIndividualRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteIndividual(Individual individual) {
        iIndividualRepository.delete(individual);
    }
}
