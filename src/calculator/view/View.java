package calculator.view;

import java.beans.PropertyChangeListener;

public interface View extends PropertyChangeListener {
    void printInitialize();

    void printGetFirstNumber();

    void printGetSecondNumber();

    void printGetSign();

    void printResult();


}
