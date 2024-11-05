package kalemz.app.open_messenger.user;

import java.security.Principal;
import java.time.LocalDateTime;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(unique = true)
    private String nickname;
    private String password;

    //private boolean accountLocked;
    //private boolean enabled;

    /*@CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime localDateTime;
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;*/

}
