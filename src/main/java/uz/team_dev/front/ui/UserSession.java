package uz.team_dev.front.ui;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.team_dev.back.vo.auth.user.UserVO;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSession {
    private static UserSession instance;

    public static UserSession getSession() {
        synchronized (UserSession.class) {
            if (instance == null) {
                instance = new UserSession();
            }
        }
        return instance;
    }
    
    private UserVO userVO;
}
