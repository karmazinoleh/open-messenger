package kalemz.app.open_messenger.messege;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import kalemz.app.open_messenger.user.User;

public interface MessageRepository extends JpaRepository<Message, Long>{

    List<Message> findByReceiver(User receiver);

    List<Message> findBySender(User sender);

    List<Message> findByReceiverAndIsReadFalse(User receiver);
    
}
