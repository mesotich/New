import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class MyPhantomRef <T>extends PhantomReference <T>{
    private static int count;
    private int id;
    public MyPhantomRef(Object referent, ReferenceQueue q) {
        super((T) referent, q);
        count++;
        id = count;
    }

    public int getId() {
        return id;
    }
}
