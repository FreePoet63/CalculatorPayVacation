package neoflex.calculator.pay.vacation.test.service;

import neoflex.calculator.pay.vacation.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServicePayVacationTest extends BaseTest {
    @Value("${salary}")
    private String salary;

    @Value("${firstDateOfTheNumberOfDays}")
    private String firstDateOfTheNumberOfDays;

    @Value("${secondDateTo14Days}")
    private String secondDateTo14Days;

    @Value("${secondDateTo28Days}")
    private String secondDateTo28Days;

    @Value("${payVacationFor14Day}")
    private Double payVacationFor14Day;

    @Value("${payVacationFor28Day}")
    private Double payVacationFor28Day;

    @Test
    void payVacationFor14Days() {
        Assertions.assertEquals(payVacation.resultPayVacation(salary, firstDateOfTheNumberOfDays, secondDateTo14Days), payVacationFor14Day);
    }

    @Test
    void payVacationFor28Days() {
        Assertions.assertEquals(payVacation.resultPayVacation(salary, firstDateOfTheNumberOfDays, secondDateTo28Days), payVacationFor28Day);
    }
}
