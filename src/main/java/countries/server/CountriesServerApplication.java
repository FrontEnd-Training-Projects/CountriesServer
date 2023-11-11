package countries.server;
import countries.server.dao.CountryRepository;
import countries.server.model.Country;
import countries.server.utils.GetCountries;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class CountriesServerApplication implements CommandLineRunner {

    final CountryRepository countryRepository;
    final ModelMapper modelMapper;

    public static void main(String[] args) {
        SpringApplication.run(CountriesServerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (countryRepository.count() == 0) {
            List<Country> allCountries = GetCountries.getCountries()
                    .stream().map(c -> modelMapper.map(c, Country.class))
                    .collect(Collectors.toList());
            countryRepository.saveAll(allCountries);
        }
    }
}