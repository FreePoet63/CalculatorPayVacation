package neoflex.calculator.pay.vacation.test;

import neoflex.calculator.pay.vacation.service.ServicePayVacation;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    public ServicePayVacation payVacation;

    @BeforeEach
    protected void setUp() {
        payVacation = new ServicePayVacation();
    }
}
