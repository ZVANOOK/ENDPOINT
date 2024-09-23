import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class CommandController {

    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    public void receiveMessage(@RequestBody CommandMessage commandMessage) {
        commandService.processMessage(commandMessage);
    }
}
