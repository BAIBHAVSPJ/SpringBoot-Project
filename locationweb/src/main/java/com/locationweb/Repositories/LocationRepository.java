package com.locationweb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locationweb.entities.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
