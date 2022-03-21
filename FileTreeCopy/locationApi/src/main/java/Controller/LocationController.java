package Controller;

import com.locations.LocationsEntity;
import database.repository.LocationRepository;
import io.micronaut.data.annotation.Query;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.exceptions.HttpException;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Validated
@Controller("/locationEntity")
public class LocationController {

    private EntityManager entityManager;

    @Inject
    private LocationRepository locationRepository;

    @Get("/locations")
    public Iterable<LocationsEntity> showAllData() {
        return locationRepository.findAll();
    }

    @Get("/findByLocation/{location}")
    public Optional<LocationsEntity> readByLocation(String location) {
        return Optional.ofNullable(locationRepository.findByLocation(location));

    }

    @Get("/findById/{id}")
    public LocationsEntity findByLocationId(Long id) {
        var result = locationRepository.findById(id);
        if(result.isPresent())
            return result.get();
        else
            return null;
    }

    @Get("/location/findRelatedLocation")
    public LocationsEntity findSpecificData(@QueryValue(value="q", defaultValue="") String name) {
//        var result1 =  locationRepository.findByLocationContaining(name);
        System.out.println(name);
        var result1 =  locationRepository.findByLocation(name);
        return (LocationsEntity) result1;
//        var result = locationRepository.findLocations(name);
//        return (LocationsEntity) result.iterator();
    }





}


