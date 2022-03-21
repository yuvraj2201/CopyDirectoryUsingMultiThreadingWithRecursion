package database.repository;

import com.locations.LocationsEntity;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.http.annotation.QueryValue;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends CrudRepository<LocationsEntity, Long> {

    LocationsEntity findByLocation(String location);

    @Query(value = "select * from LocationEntity locData where locData.location like :name", nativeQuery = true)
    List<LocationsEntity> findLocations(@QueryValue(value = "name") String name);

    List<LocationsEntity> findByLocationContaining(String name);
}
