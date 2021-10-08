package calculator.view;

import java.beans.PropertyChangeEvent;

public class MyView implements View {
    private double result;

    @Override
    public void printInitialize() {
        System.out.println("Это программа Калькулятор");
    }

    @Override
    public void printGetFirstNumber() {
        System.out.println("Введите первое число:");
    }

    @Override
    public void printGetSecondNumber() {
        System.out.println("Введите второе число:");
    }

    @Override
    public void printGetSign() {
        System.out.println("Введите знак:");
    }

    @Override
    public void printResult() {
        System.out.println("Результат = " +result);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        result = (Double) evt.getNewValue();
        printResult();
    }
}
