package kalemz.app.open_messenger.messege;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController{

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public String sendMessage(@RequestBody MessageRequest request) {
        if (request.getReceiver() == null) {
            throw new IllegalArgumentException("Recipient cannot be null");
        }

        messageService.sendMessage(
                request.getSender(),
                request.getReceiver(),
                request.getContent()
        );
        return "Message sent successfully";
    }
}
