package calculator;

import calculator.controller.Controller;
import calculator.controller.MyController;
import calculator.model.Model;
import calculator.model.MyModel;
import calculator.view.MyView;
import calculator.view.View;

public class User {
    public static void main(String[] args) {
        Model model = new MyModel();
        View view = new MyView();
        model.addListener(view);
        Controller controller = new MyController(model, view);
    }
}
