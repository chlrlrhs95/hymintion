package kr.ac.hanyang.hyminton.hyminton.api;

import kr.ac.hanyang.hyminton.hyminton.db.InvitationCodeDao;
import kr.ac.hanyang.hyminton.hyminton.db.UserDao;
import kr.ac.hanyang.hyminton.hyminton.vo.InvitationCode;
import kr.ac.hanyang.hyminton.hyminton.vo.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * kr.ac.hanyang.hyminton.hyminton.api.SignUpApi
 * Created by HyunI Kim.
 * Date: 2020-04-19
 * Email: jbhyunikim@gmail.com
 */
@RestController
@RequestMapping("/api/signup")
@RequiredArgsConstructor
public class SignUpApi {
    private final InvitationCodeDao invitationCodeDao;
    private final UserDao userDao;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestBody body) {
        User user = body.user;
        String code = body.code;

        InvitationCode invitationCode = invitationCodeDao.selectInvitationCode(code);

        if (invitationCode == null)
            return ResponseEntity.badRequest().body("Wrong invitation code");

        int insertResult = userDao.insertUser(user);
        if (insertResult == 0)
            return ResponseEntity.badRequest().body("Cannot add new user");

        invitationCodeDao.deleteInvitationCode(code);

        return ResponseEntity.ok().build();
    }

    @Data
    static class SignUpRequestBody {
        private User user;
        private String code;
    }
}
