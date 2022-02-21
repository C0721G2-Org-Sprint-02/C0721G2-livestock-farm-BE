package com.project.livestockfarmbe.service.cage;

import com.project.livestockfarmbe.model.cage.TypeOfCage;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ITypeOfCageService {
    List<TypeOfCage> findAllTypeOfCage();
}
