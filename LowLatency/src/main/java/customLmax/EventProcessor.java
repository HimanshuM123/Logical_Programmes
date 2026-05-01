package customLmax;
public final class EventProcessor<T> implements Runnable {
    private final RingBuffer<T> ringBuffer;
    private final SequenceBarrier barrier;
    private final Sequence sequence = new Sequence();
    private final EventHandler<T> handler;

    public EventProcessor(RingBuffer<T> ringBuffer,
                          SequenceBarrier barrier,
                          EventHandler<T> handler) {
        this.ringBuffer = ringBuffer;
        this.barrier = barrier;
        this.handler = handler;
    }

    public Sequence getSequence() {
        return sequence;
    }

    @Override
    public void run() {
        long nextSeq = sequence.get() + 1;

        while (true) {
            long available = barrier.waitFor(nextSeq);

            while (nextSeq <= available) {
                T event = ringBuffer.get(nextSeq);
                handler.onEvent(event, nextSeq);
                sequence.set(nextSeq);
                nextSeq++;
            }
        }
    }
}
