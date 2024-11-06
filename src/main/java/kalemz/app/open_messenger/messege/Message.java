package kalemz.app.open_messenger.messege;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import kalemz.app.open_messenger.user.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;
    
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private boolean isRead; // todo

    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }
}
