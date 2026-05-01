package customLmax;

public final class SequenceBarrier {
    private final Sequence cursor;

    public SequenceBarrier(Sequence cursor) {
        this.cursor = cursor;
    }

    public long waitFor(long sequence) {
        while (cursor.get() < sequence) {
            Thread.onSpinWait();
        }
        return cursor.get();
    }
}
