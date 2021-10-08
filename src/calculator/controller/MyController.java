package calculator.controller;

import calculator.model.Expression;
import calculator.model.Model;
import calculator.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyController implements Controller {
    private Model model;
    private View view;

    public MyController(Model model, View view) {
        this.model = model;
        this.view = view;
        initialize();
    }

    @Override
    public void initialize() {
        view.printInitialize();
        model.setExpression(getExpressionByUser());
    }

    @Override
    public Expression getExpressionByUser() {
        view.printGetFirstNumber();
        double firstNumber = Double.parseDouble(readStringByConsole());
        view.printGetSecondNumber();
        double secondNumber = Double.parseDouble(readStringByConsole());
        view.printGetSign();
        Expression.Sign sign = Expression.Sign.valueOf(readStringByConsole());
        return new Expression(firstNumber, secondNumber, sign);
    }

    private String readStringByConsole() {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            result = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
