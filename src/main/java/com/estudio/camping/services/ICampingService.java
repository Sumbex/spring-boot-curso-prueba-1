package com.estudio.camping.services;

import java.util.List;

import com.estudio.camping.entities.Camping;

public interface ICampingService {
    List<Camping> getAllCampings();

    Camping getCampingById(Long id);

    Camping postCamping(Camping camping);

    Camping putCamping(Camping camping);

    Boolean deleteCamping(Long id);
}
