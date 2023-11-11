package countries.server.model;
import countries.server.dto.FlagDto;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document(collection = "countries")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    String id;
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
