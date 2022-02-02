package sit.int204.lab01.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String chasisNumber;
    private String brand;
    private Engine engine;

    public void start() {
        engine.turnOn();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("chasisNumber='").append(chasisNumber).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", engine=").append(engine.getCapacity());
        sb.append('}');
        return sb.toString();
    }
}
