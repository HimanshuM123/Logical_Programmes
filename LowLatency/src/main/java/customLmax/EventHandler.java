package customLmax;

public interface EventHandler<T> {
    void onEvent(T event, long sequence);
}
