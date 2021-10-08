package calculator.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MyModel implements Model {
    private Expression expression;
    private PropertyChangeSupport support;

    public MyModel() {
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
        fire(calculate());

    }

    @Override
    public double calculate() {
        Expression.Sign sign = expression.getSIGN();
        switch (sign) {
            case PLUS:
                return expression.getFIRST_NUMBER() + expression.getSECOND_NUMBER();
            case MINUS:
                return expression.getFIRST_NUMBER() - expression.getSECOND_NUMBER();
        }
        return 0;
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void fire(double result) {
        support.firePropertyChange("Результат", null, result);
    }
}
