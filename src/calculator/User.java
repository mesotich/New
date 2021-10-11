package calculator;

import calculator.controller.Controller;
import calculator.controller.MyController;
import calculator.model.Model;
import calculator.model.MyModel;
import calculator.view.MyView;
import calculator.view.MyView2;
import calculator.view.View;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Queue;

public class User {
    public static void main(String[] args) {
        Map<Integer, String> map = new IdentityHashMap<>();

        Model model = new MyModel();
        View view = new MyView2();
        model.addListener(view);
        Controller controller = new MyController(model, view);
    }
}
