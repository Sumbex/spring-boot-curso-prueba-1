package com.estudio.camping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudio.camping.entities.Camping;
import com.estudio.camping.repository.CampingRepository;

@Service
public class CampingService implements ICampingService {
    @Autowired
    private CampingRepository repository;

    @Override
    public List<Camping> getAllCampings() {
        return (List<Camping>) repository.findAllByActivoTrue();
    }

    @Override
    public Camping getCampingById(Long id) {
        try {
            return (Camping) repository.findByIdAndActivoTrue(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Camping postCamping(Camping camping) {
        return repository.save(camping);
    }

    @Override
    public Camping putCamping(Camping camping) {
        Long id = camping.getId();
        Camping update = repository.findById(id).get();
        update.setCamping(camping.getCamping());
        return repository.save(update);
    }

    @Override
    public Boolean deleteCamping(Long id) {
        Camping update = repository.findById(id).get();
        update.setActivo(false);
        update = repository.save(update);
        return update != null ? true : false;
    }

}
