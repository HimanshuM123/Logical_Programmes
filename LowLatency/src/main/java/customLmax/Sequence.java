package customLmax;

import java.util.concurrent.atomic.AtomicLong;

public  class Sequence {
    private final AtomicLong value = new AtomicLong(-1);

    public long get() {
        return value.get();
    }

    public void set(long v) {
        value.set(v);
    }

    public boolean compareAndSet(long expected, long next) {
        return value.compareAndSet(expected, next);
    }

    public long incrementAndGet() {
        return value.incrementAndGet();
    }
}
