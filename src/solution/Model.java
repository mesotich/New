package solution;

import java.util.List;

public class Model {
    public List<String> getStringDataList() {
        Service service = new Service();
        return service.getData();
    }
}
