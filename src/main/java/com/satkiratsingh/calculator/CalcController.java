package com.satkiratsingh.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * CalculatorController handles basic arithmetic operations and maintains a
 * history of calculations.
 */
@Controller
public class CalcController {

    private List<CalculationHistory> history = new ArrayList<>();

    /**
     * Adds two numbers.
     *
     * @param op1 Operand 1
     * @param op2 Operand 2
     * @return The sum of op1 and op2
     */
    @RequestMapping("/calculator/add")
    @ResponseBody
    public Double add(@RequestParam Double op1, @RequestParam Double op2) {
        double sum = op1 + op2;
        addToHistory(op1, op2, "+", sum);
        return sum;
    }

    /**
     * Subtracts op2 from op1.
     *
     * @param op1 Operand 1
     * @param op2 Operand 2
     * @return The result of op1 minus op2
     */
    @RequestMapping("/calculator/minus")
    @ResponseBody
    public Double minus(@RequestParam Double op1, @RequestParam Double op2) {
        double ans = op1 - op2;
        addToHistory(op1, op2, "-", ans);
        return ans;
    }

    /**
     * Multiplies two numbers.
     *
     * @param op1 Operand 1
     * @param op2 Operand 2
     * @return The product of op1 and op2
     */
    @RequestMapping("/calculator/product")
    @ResponseBody
    public Double product(@RequestParam Double op1, @RequestParam Double op2) {
        double ans = op1 * op2;
        addToHistory(op1, op2, "*", ans);
        return ans;
    }

    /**
     * Divides op1 by op2.
     *
     * @param op1 Operand 1
     * @param op2 Operand 2
     * @return ResponseEntity containing the result of the division or an error
     *         message if op2 is zero
     */
    @RequestMapping("/calculator/divide")
    @ResponseBody
    public ResponseEntity<String> divide(@RequestParam Double op1, @RequestParam Double op2) {
        if (op2 == 0) {
            addToHistory(op1, op2, "/", Double.POSITIVE_INFINITY);
            return new ResponseEntity<>("Cannot divide by zero!", HttpStatus.BAD_REQUEST);
        }
        Double ans = op1 / op2;
        addToHistory(op1, op2, "/", ans);
        return new ResponseEntity<>(ans.toString(), HttpStatus.OK);
    }

    /**
     * Retrieves the history of calculations and formats it as a string.
     *
     * @return A formatted string representing the calculation history
     */
    @RequestMapping("/calculator/history")
    @ResponseBody
    public String history() {
        StringBuilder historyStr = new StringBuilder("");

        for (CalculationHistory entry : history) {
            historyStr.append(entry.toString()).append("<br>");
        }

        return historyStr.toString();
    }

    /**
     * Clears the history of calculations.
     *
     * @return A message indicating that the history has been cleared
     */
    @RequestMapping("/calculator/clear")
    @ResponseBody
    public String clear() {
        history.clear();
        return "History cleared!";
    }

    /**
     * Adds a calculation to the history.
     *
     * @param op1      Operand 1
     * @param op2      Operand 2
     * @param operator The arithmetic operator used in the calculation
     * @param result   The result of the calculation
     */
    private void addToHistory(Double op1, Double op2, String operator, Double result) {
        CalculationHistory entry = new CalculationHistory(op1, op2, operator, result);
        history.add(entry);
    }
}
