package solution;

public class View {
    public void fireShowDataEvent() {
        Controller controller = new Controller();
        System.out.println(controller.onShowDataList());
    }
}
