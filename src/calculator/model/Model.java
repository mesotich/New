package calculator.model;

import java.beans.PropertyChangeListener;

public interface Model {
    void setExpression(Expression expression);

    double calculate();

    void addListener(PropertyChangeListener listener);

    void fire(double result);
}
