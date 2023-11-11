package countries.server.service;
import countries.server.dao.CountryRepository;
import countries.server.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{

    final CountryRepository countryRepository;
    final ModelMapper modelMapper;

    @Override
    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(country -> modelMapper.map(country, CountryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDto> getCountryByNameLetters(String letters) {
        return countryRepository.findCountryByNameLetters(letters.toLowerCase())
                .map(country -> modelMapper.map(country, CountryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDto> getCountryByCapitalLetters(String letters) {
        return countryRepository.findCountryByCapitalLetters(letters.toLowerCase())
                .map(country -> modelMapper.map(country, CountryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDto> getCountriesForRegion(String region) {
        return countryRepository.findCountriesByRegionIgnoreCase(region)
                .map(country -> modelMapper.map(country, CountryDto.class))
                .collect(Collectors.toList());
    }
}
