package countries.server.utils;
import countries.server.dto.CountryDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class GetCountries {
    private static final String BASE_URL = "https://countryapi.io/api/all";
    private static final String API_KEY = "zqfcIyGHyGJ6ySZjRYxOkAG9iyCS9x96jMWJenaf";
    private static final RestTemplate restTemplate = new RestTemplate();

    public static List<CountryDto> getCountries() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL).queryParam("apikey", API_KEY);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + API_KEY);
        RequestEntity<String> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, builder.build().toUri());
        ResponseEntity<LinkedHashMap<String, CountryDto>> responseEntity = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<>() {});
        return new ArrayList<>(Objects.requireNonNull(responseEntity.getBody()).values());
    }
}
