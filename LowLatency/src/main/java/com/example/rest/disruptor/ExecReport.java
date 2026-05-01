package com.example.rest.disruptor;



public class ExecReport {
    public final String orderId;
    public final String clientId;
    public final String status;
    public final int filledQty;
    public final double fillPrice;

    // timestamps:
    public final long originNanoTs;
    public final long omsNanoTs;
    public final long sorNanoTs;
    public final long adapterNanoTs;
    public final long execNanoTs;
    public final long persistNanoTs;

    public ExecReport(String orderId, String clientId, String status, int filledQty, double fillPrice,
                      long originNanoTs, long omsNanoTs, long sorNanoTs, long adapterNanoTs, long execNanoTs, long persistNanoTs) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.status = status;
        this.filledQty = filledQty;
        this.fillPrice = fillPrice;
        this.originNanoTs = originNanoTs;
        this.omsNanoTs = omsNanoTs;
        this.sorNanoTs = sorNanoTs;
        this.adapterNanoTs = adapterNanoTs;
        this.execNanoTs = execNanoTs;
        this.persistNanoTs = persistNanoTs;
    }

    public long latencyOms() { return omsNanoTs - originNanoTs; }
    public long latencySor() { return sorNanoTs - omsNanoTs; }
    public long latencyAdapter() { return adapterNanoTs - sorNanoTs; }
    public long latencyExec() { return execNanoTs - adapterNanoTs; }
    public long latencyPersist() { return persistNanoTs - execNanoTs; }
    public long latencyTotal() { return persistNanoTs - originNanoTs; }
}
