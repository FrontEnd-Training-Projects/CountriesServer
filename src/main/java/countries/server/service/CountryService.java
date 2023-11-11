package countries.server.service;

import countries.server.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAllCountries();
    List<CountryDto> getCountryByNameLetters(String letters);
    List<CountryDto> getCountryByCapitalLetters(String letters);
    List<CountryDto> getCountriesForRegion(String region);
}
