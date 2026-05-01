package customLmax;
public final class SingleProducerSequencer {
    private final int bufferSize;
    private final Sequence cursor = new Sequence();
    private final Sequence[] gatingSequences;

    public SingleProducerSequencer(int bufferSize, Sequence... gatingSequences) {
        this.bufferSize = bufferSize;
        this.gatingSequences = gatingSequences;
    }

    public long next() {
        long nextSeq = cursor.incrementAndGet();

        long wrapPoint = nextSeq - bufferSize;
        while (wrapPoint > getMinimumSequence()) {
            // busy spin (no locks!)
            Thread.onSpinWait();
        }

        return nextSeq;
    }

    public void publish(long sequence) {
        // nothing else needed — cursor already updated
    }

    public long getCursor() {
        return cursor.get();
    }

    private long getMinimumSequence() {
        long min = Long.MAX_VALUE;
        for (Sequence seq : gatingSequences) {
            min = Math.min(min, seq.get());
        }
        return min;
    }
}
