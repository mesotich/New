package solution;

import java.util.List;

public class Model {
    private final Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }
}
