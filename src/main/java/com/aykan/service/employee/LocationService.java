package com.aykan.service.employee;

import com.aykan.domain.employee.Location;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocationService {
    boolean saveLocation(Location location);

    boolean deleteLocation(Location location);

    Location updateLocation(Location location);

    @Transactional(readOnly = true)
    Location findLocationById(Long locationId);

    @Transactional(readOnly = true)
    List<Location> findAllLocation();
}
