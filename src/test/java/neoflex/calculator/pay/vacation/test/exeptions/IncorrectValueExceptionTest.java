package neoflex.calculator.pay.vacation.test.exeptions;

import neoflex.calculator.pay.vacation.exceptions.IncorrectValueException;
import neoflex.calculator.pay.vacation.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IncorrectValueExceptionTest extends BaseTest {
    @Value("${salary}")
    private String salary;

    @Value("${firstDateOfTheNumberOfDays}")
    private String firstDateOfTheNumberOfDays;

    @Value("${secondDateTo28Days}")
    private String secondDateTo28Days;

    @Value("${incorrectLetterSymbolsSalary}")
    private String incorrectLetterSymbolsSalary;

    @Value("${inputNegativeNumberSalary}")
    private String inputNegativeNumberSalary;

    @Value("${incorrectCombinationInputFirstString}")
    private String incorrectCombinationInputFirstString;

    @Value("${incorrectCombinationInputSecondString}")
    private String incorrectCombinationInputSecondString;

    @Test
    void shouldThrowExceptionForInputIncorrectSalary() {
        Assertions.assertThrows(IncorrectValueException.class,
                () -> payVacation.resultPayVacation(incorrectLetterSymbolsSalary, firstDateOfTheNumberOfDays, secondDateTo28Days));
    }

    @Test
    void shouldThrowExceptionForInputNullSalary() {
        Assertions.assertThrows(IncorrectValueException.class,
                () -> payVacation.resultPayVacation("0", firstDateOfTheNumberOfDays, secondDateTo28Days));
    }

    @Test
    void shouldThrowExceptionForInputNegativeNumberSalary() {
        Assertions.assertThrows(IncorrectValueException.class,
                () -> payVacation.resultPayVacation(inputNegativeNumberSalary, firstDateOfTheNumberOfDays, secondDateTo28Days));
    }

    @Test
    void shouldThrowExceptionForInputNullFirstString() {
        Assertions.assertThrows(IncorrectValueException.class,
                () -> payVacation.resultPayVacation(salary, null, secondDateTo28Days));
    }

    @Test
    void shouldThrowExceptionForInputIncorrectValueFirstString() {
        Assertions.assertThrows(IncorrectValueException.class,
                () -> payVacation.resultPayVacation(salary, incorrectCombinationInputFirstString, secondDateTo28Days));
    }

    @Test
    void shouldThrowExceptionForInputNullSecondString() {
        Assertions.assertThrows(IncorrectValueException.class,
                () -> payVacation.resultPayVacation(salary, firstDateOfTheNumberOfDays, null));
    }

    @Test
    void shouldThrowExceptionForInputIncorrectValueSecondString() {
        Assertions.assertThrows(IncorrectValueException.class,
                () -> payVacation.resultPayVacation(salary, firstDateOfTheNumberOfDays, incorrectCombinationInputSecondString));
    }
}
