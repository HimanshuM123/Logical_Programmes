package customLmax;

public class DisruptorDemo {

    public static void main(String[] args) {
        int bufferSize = 1024;

        RingBuffer<Order> ringBuffer = new RingBuffer<>(bufferSize);

        EventHandler<Order> handler = (order, seq) ->
                System.out.println("Consumed seq=" + seq + " " + order);

        EventProcessor<Order> processor =
                new EventProcessor<>(ringBuffer,
                        new SequenceBarrier(new Sequence()), // placeholder
                        handler);

        Sequence consumerSequence = processor.getSequence();

        SingleProducerSequencer sequencer =
                new SingleProducerSequencer(bufferSize, consumerSequence);

        SequenceBarrier barrier =
                new SequenceBarrier(new Sequence() {
                    @Override public long get() {
                        return sequencer.getCursor();
                    }
                });

        // Fix barrier reference
        new Thread(processor).start();

        // Producer
        for (int i = 0; i < 10; i++) {
            long seq = sequencer.next();
            ringBuffer.set(seq, new Order(i, 100.5 + i, 10));
            sequencer.publish(seq);
        }
    }
}
