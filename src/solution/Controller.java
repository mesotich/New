package solution;

import java.util.List;

public class Controller {
    public List<String> onShowDataList() {
        Model model = new Model();
        return model.getStringDataList();
    }
}
