package sit.int221.oasiptest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventBookingCategoryDto {
    private Integer id;
    private String bookingName;
    private String bookingEmail;
    private CategoryDto eventCategory;
    private Instant eventStartTime;
    private String eventNotes;

    public String getEventNotes() {
        return eventNotes == null ? "-" : eventNotes;
    }
}
