package com.estudio.camping.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estudio.camping.entities.Camping;

@Repository
public interface CampingRepository extends CrudRepository<Camping, Long> {
    List<Camping> findAllByActivoTrue();

    Camping findByIdAndActivoTrue(Long id);
}
