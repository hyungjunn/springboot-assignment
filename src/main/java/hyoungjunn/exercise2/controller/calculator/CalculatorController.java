package hyoungjunn.exercise2.controller.calculator;

import hyoungjunn.exercise2.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumber(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }
}
