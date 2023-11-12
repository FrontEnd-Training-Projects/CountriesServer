package countries.server.controller;
import countries.server.dto.CountryDto;
import countries.server.dto.SortingDataDto;
import countries.server.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController implements CountryService{

    final CountryService countryService;

    @GetMapping("/getAllCountries")
    public List<CountryDto> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/getCountryByNameLetters/{letters}")
    public List<CountryDto> getCountryByNameLetters(@RequestParam(required = false) @PathVariable String letters) {
        return countryService.getCountryByNameLetters(letters);
    }

    @GetMapping("/getCountryByCapitalLetters/{letters}")
    public List<CountryDto> getCountryByCapitalLetters(@RequestParam(required = false) @PathVariable String letters) {
        return countryService.getCountryByCapitalLetters(letters);
    }

    @GetMapping("/getCountriesForRegion/{region}")
    public List<CountryDto> getCountriesForRegion(@PathVariable String region) {
        return countryService.getCountriesForRegion(region);
    }

   @PostMapping("/getSortedCountries")
    public List<CountryDto> getSortedCountries(@RequestBody SortingDataDto sortingData) {
        return countryService.getSortedCountries(sortingData);
    }
}
