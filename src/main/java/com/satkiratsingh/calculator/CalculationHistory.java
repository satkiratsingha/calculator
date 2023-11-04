package com.satkiratsingh.calculator;

/**
 * CalculationHistory represents a single calculation entry in the history.
 */
public class CalculationHistory {
    private Double operand1;
    private Double operand2;
    private String operator;
    private Double result;

    /**
     * Constructs a CalculationHistory object.
     *
     * @param operand1 The first operand
     * @param operand2 The second operand
     * @param operator The arithmetic operator used in the calculation
     * @param result   The result of the calculation
     */
    public CalculationHistory(Double operand1, Double operand2, String operator, Double result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.result = result;
    }

    /**
     * Retrieves the first operand.
     *
     * @return The first operand
     */
    public Double getOperand1() {
        return operand1;
    }

    /**
     * Retrieves the second operand.
     *
     * @return The second operand
     */
    public Double getOperand2() {
        return operand2;
    }

    /**
     * Retrieves the arithmetic operator used in the calculation.
     *
     * @return The arithmetic operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Retrieves the result of the calculation.
     *
     * @return The calculation result
     */
    public Double getResult() {
        return result;
    }

    /**
     * Returns a string representation of the calculation history entry.
     *
     * @return The formatted string representing the calculation history
     */
    @Override
    public String toString() {
        return operand1 + " " + operator + " " + operand2 + " = " + result;
    }
}
