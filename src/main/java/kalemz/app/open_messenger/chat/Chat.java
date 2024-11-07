package kalemz.app.open_messenger.chat;

import jakarta.persistence.*;
import kalemz.app.open_messenger.messege.Message;
import kalemz.app.open_messenger.user.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chats")
public class Chat {

    @Id
    private Long id;

    private String chatName;

    @ManyToMany
    private List<User> participants;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;
}
