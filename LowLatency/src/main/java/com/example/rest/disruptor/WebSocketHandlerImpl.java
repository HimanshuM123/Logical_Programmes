

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class WebSocketHandlerImpl extends TextWebSocketHandler {
    private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }

    public void broadcastExecution(ExecutionReport exec){
        try{
            String json = mapper.writeValueAsString(exec);
            sessions.forEach(s -> {
                try{ if(s.isOpen()) s.sendMessage(new TextMessage(json)); }
                catch(Exception e){ e.printStackTrace(); }
            });
        }catch(Exception e){ e.printStackTrace(); }
    }
}
