public class Generator<T> {
    private final Class<T> eventClass;

    public Generator(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    T newInstance() {
        T t = null;
        try {
            t = eventClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}