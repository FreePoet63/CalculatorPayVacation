package neoflex.calculator.pay.vacation.service;

import neoflex.calculator.pay.vacation.exceptions.IncorrectValueException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ServicePayVacation {
    public double resultPayVacation(String salary, String firstString, String secondString) {
        int daysVacation = daysBetweenTwoDate(firstString, secondString);
        double resultPayVacation = (correctValue(salary) / 29.3) * daysVacation;
        resultPayVacation = ((int) (resultPayVacation * 100)) / 100;
        return resultPayVacation;
    }

    public int daysBetweenTwoDate(String firstString, String secondString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = null;
        Date secondDate = null;
        try {
            firstDate = dateFormat.parse(firstString);
            secondDate = dateFormat.parse(secondString);
        } catch (Exception e) {
            throw new IncorrectValueException();
        }
        int day = (int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
        return day;
    }

    public double correctValue(String salary) {
        double value = 0.0;
        try {
            value = Double.parseDouble(salary);
            if (value <= 0) {
                throw new IncorrectValueException();
            }
        }catch (Exception e) {
            throw new IncorrectValueException();
        }
        return value;
    }
}
