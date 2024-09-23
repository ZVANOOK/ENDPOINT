import org.springframework.stereotype.Service;
import java.util.Map; // Импорт для использования Map

@Service
public class CommandService {

    public void processMessage(CommandMessage commandMessage) {
        // Логика обработки сообщения и маршрутизации команды
        String gameId = commandMessage.getGameId();
        String objectId = commandMessage.getObjectId();
        String operationId = commandMessage.getOperationId();
        Map<String, Object> args = commandMessage.getArgs();

        // Здесь добавьте вашу логику для обработки команды
    }
}
