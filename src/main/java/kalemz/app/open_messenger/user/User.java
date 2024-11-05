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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
