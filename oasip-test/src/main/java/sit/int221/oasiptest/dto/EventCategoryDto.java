package sit.int221.oasiptest.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventCategoryDto {
    private Integer id;
    private String categoryName;
    private String categoryDescription;
    private Integer eventDuration;
    private Set<EventBookingDto> eventBookings = new LinkedHashSet<>();

    public String getCategoryDescription() {
        return categoryDescription == null ? "-" : categoryDescription;
    }
}
