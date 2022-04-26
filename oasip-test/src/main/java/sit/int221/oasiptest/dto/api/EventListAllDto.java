package sit.int221.oasiptest.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.int221.oasiptest.dto.EventCategoryDto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventListAllDto {
    @JsonIgnore
    private Integer id;
    private String bookingName;
    @JsonIgnore
    private EventCategoryDto eventCategory;
    private Instant eventStartTime;
    private Integer eventDuration;

    public String getEventCategoryName() {
        return eventCategory.getCategoryName();
    }

    public String getEventStartDate() {
        LocalDate date = eventStartTime.atZone(ZoneId.systemDefault()).toLocalDate();
        return date.toString();
    }

    public String getEventStartTime() {
        LocalTime time = eventStartTime.atZone(ZoneId.systemDefault()).toLocalTime();
        return time.toString();
    }
}
