package com.example.rest.disruptor;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PersistenceService {
    private final String url = "jdbc:Cache://localhost:1972/USER";
    private final String user = "_SYSTEM";
    private final String password = "SYS";

    public void persistExecution(ExecutionReport exec){
        try(Connection conn = DriverManager.getConnection(url,user,password)){
            String sql = "INSERT INTO ExecutionReport(orderId, clientOrderId, status, filledQty, fillPx, execTs) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, exec.getOrderId());
            ps.setString(2, exec.getClientId());
            ps.setString(3, exec.getStatus());
            ps.setInt(4, exec.getFilledQty());
            ps.setDouble(5, exec.getFilledQty());
            ps.setLong(6, exec.getTimestamp());
            ps.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
