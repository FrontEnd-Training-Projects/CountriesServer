package countries.server.dao;

import countries.server.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.stream.Stream;

public interface CountryRepository extends MongoRepository<Country, String> {
    @Query("{name: {$regex: '(?i)?0'}}")
    Stream<Country> findCountryByNameLetters(String letters);
    @Query("{capital: {$regex: '(?i)?0'}}")
    Stream<Country> findCountryByCapitalLetters(String letters);
    Stream<Country> findCountriesByRegionIgnoreCase(String region);
}
