package sit.int204.lab01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sit.int204.lab01.beans.Car;
import sit.int204.lab01.beans.DieselEngine;
import sit.int204.lab01.beans.Engine;

@Configuration
public class ApplicationConfiguration {
    @Bean(name = "car")
    public Car getCar() {
        return new Car("ZM4969JXX", "Toyota-Fortuner", fortunerEngine());
    }

    @Bean(name = "1KD-FTV")
    public Engine fortunerEngine() {
        return new DieselEngine(2499);
    }
}
