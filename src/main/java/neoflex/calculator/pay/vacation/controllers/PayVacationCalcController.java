package neoflex.calculator.pay.vacation.controllers;

import neoflex.calculator.pay.vacation.service.ServicePayVacation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculacte")
public class PayVacationCalcController {
    private final ServicePayVacation payVacation;

    public PayVacationCalcController(ServicePayVacation payVacation) {
        this.payVacation = payVacation;
    }

    @GetMapping
    public double getPayVacation(
            @RequestParam String salary,
            @RequestParam String firstDate,
            @RequestParam String secondDate
    ) {
        return payVacation.resultPayVacation(salary, firstDate, secondDate);
    }
}
