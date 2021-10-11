package solution;

public class View {
    private final Controller controller = new Controller();

    public void fireShowDataEvent() {
        System.out.println(controller.onShowDataList());
    }
}
