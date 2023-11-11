package countries.server.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CountryDto {
    String name;
    String official_name;
    String alpha3Code;
    String numericCode;
    String callingCode;
    String capital;
    String region;
    String subregion;
    Long population;
    List<String> timezones;
    FlagDto flag;
}
