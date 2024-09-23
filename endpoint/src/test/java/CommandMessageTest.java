import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CommandMessageTest {

    @Test
    void testCommandMessage() {
        // Создаем объект CommandMessage
        CommandMessage commandMessage = new CommandMessage();

        // Устанавливаем значения
        commandMessage.setGameId("1");
        commandMessage.setObjectId("548");
        commandMessage.setOperationId("move");

        // Проверяем значения
        assertEquals("1", commandMessage.getGameId());
        assertEquals("548", commandMessage.getObjectId());
        assertEquals("move", commandMessage.getOperationId());

        // Добавляем аргументы
        Map<String, Object> args = new HashMap<>();
        args.put("speed", 2);
        commandMessage.setArgs(args);

        // Проверяем, что аргументы установлены правильно
        assertEquals(args, commandMessage.getArgs());
        assertEquals(2, commandMessage.getArgs().get("speed")); // Дополнительная проверка
    }
}