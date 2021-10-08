package calculator.controller;

import calculator.model.Expression;

public interface Controller {
    void initialize();
    Expression getExpressionByUser();
}
