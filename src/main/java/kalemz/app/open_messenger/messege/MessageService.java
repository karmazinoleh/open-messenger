package kalemz.app.open_messenger.messege;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kalemz.app.open_messenger.user.User;

import kalemz.app.open_messenger.user.UserRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public Message sendMessage(String senderNickname, String receiverNickname, String content) {
        List<User> senderList = userRepository.findByNickname(senderNickname);
        List<User> receiverList = userRepository.findByNickname(receiverNickname);

        if (senderList.isEmpty()) {
            throw new IllegalArgumentException("Sender not found with nickname: " + senderNickname);
        }
        if (receiverList.isEmpty()) {
            throw new IllegalArgumentException("Receiver not found with nickname: " + receiverNickname);
        }

        User sender = senderList.get(0);
        User receiver = receiverList.get(0);

        Message message = Message.builder()
                .sender(sender)
                .receiver(receiver)
                .content(content)
                .isRead(false)
                .build();

        return messageRepository.save(message);
    }

    public List<Message> getReceivedMessages(String receiverNickname){
        User receiver = userRepository.findByNickname(receiverNickname).get(0); // 0 -> id
        return messageRepository.findByReceiver(receiver);
    }

    public void markMessageAsRead(Long messageId){
        Message message = messageRepository.findById(messageId).orElseThrow();
        message.setRead(true);
        messageRepository.save(message);
    }

    
}
