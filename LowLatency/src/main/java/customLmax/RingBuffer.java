package customLmax;

public final class RingBuffer<T> {
    private final Object[] entries;
    private final int mask;

    public RingBuffer(int bufferSize) {
        if (Integer.bitCount(bufferSize) != 1) {
            throw new IllegalArgumentException("Buffer size must be power of 2");
        }
        this.entries = new Object[bufferSize];
        this.mask = bufferSize - 1;
    }

    @SuppressWarnings("unchecked")
    public T get(long sequence) {
        return (T) entries[(int) (sequence & mask)];
    }

    public void set(long sequence, T event) {
        entries[(int) (sequence & mask)] = event;
    }

    public int size() {
        return entries.length;
    }
}