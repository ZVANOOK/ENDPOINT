import java.util.Map;
import java.util.HashMap;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = EndPoint_main.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)  // Добавьте это для поддержки Mockito
public class CommandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CommandService commandService;

    @BeforeEach
    public void setUp() {
        openMocks(this); // Инициализация моков перед каждым тестом
    }

    @Test
    public void testReceiveMessage() throws Exception {
        // Подготовка JSON payload
        String jsonPayload = "{\"gameId\":\"1\",\"objectId\":\"548\",\"operationId\":\"move\",\"args\":{\"speed\":2}}";

        // Выполнение пост-запроса
        mockMvc.perform(post("/api/messages")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk());

        // Проверка вызова метода
        ArgumentCaptor<CommandMessage> argumentCaptor = ArgumentCaptor.forClass(CommandMessage.class);
        verify(commandService).processMessage(argumentCaptor.capture());

        CommandMessage capturedMessage = argumentCaptor.getValue();

        // Проверка значений в захваченном CommandMessage
        assertEquals("1", capturedMessage.getGameId());
        assertEquals("548", capturedMessage.getObjectId());
        assertEquals("move", capturedMessage.getOperationId());
        Map<String, Object> expectedArgs = new HashMap<>();
        expectedArgs.put("speed", 2);
        assertEquals(expectedArgs, capturedMessage.getArgs());
    }
}
