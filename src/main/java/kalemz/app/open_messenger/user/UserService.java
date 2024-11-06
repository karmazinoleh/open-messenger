package kalemz.app.open_messenger.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String nickname, String password){

        User user = User.builder()
            .nickname(nickname)
            .password(password)
            .accountLocked(false)
            .build();
        return userRepository.save(user);
    }
    
}
