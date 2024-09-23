import java.util.Map;
import java.util.HashMap;

public class CommandMessage {
    private String gameId;
    private String objectId;
    private String operationId;
    private Map<String, Object> args;

    public CommandMessage() {
        args = new HashMap<>();
    }

    // Геттеры и сеттеры
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public Map<String, Object> getArgs() {
        return args;
    }

    public void setArgs(Map<String, Object> args) {
        this.args = args;
    }
}