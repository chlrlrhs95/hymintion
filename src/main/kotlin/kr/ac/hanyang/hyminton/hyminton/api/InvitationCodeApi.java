package kr.ac.hanyang.hyminton.hyminton.api;

import kr.ac.hanyang.hyminton.hyminton.db.InvitationCodeDao;
import kr.ac.hanyang.hyminton.hyminton.vo.InvitationCode;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * kr.ac.hanyang.hyminton.hyminton.api.InvitationCodeApi
 * Created by HyunI Kim.
 * Date: 2020-04-19
 * Email: jbhyunikim@gmail.com
 */
@RestController
@RequestMapping("/api/invitation")
@RequiredArgsConstructor
public class InvitationCodeApi {
    private final InvitationCodeDao invitationCodeDao;
    private final Random random;

    @RequestMapping(method = RequestMethod.GET)
    List<InvitationCode> getAllInvitationCodes() {
        return invitationCodeDao.selectAllInvitationCodes();
    }

    @RequestMapping(method = RequestMethod.POST)
    String addInvitationCode(@RequestBody String memo) {
        String code = generateRandomCode();
        InvitationCode invitationCode = new InvitationCode(code, memo);
        invitationCodeDao.insertInvitationCode(invitationCode);
        return code;
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    ResponseEntity<InvitationCode> getInvitationCode(@PathVariable String code) {
        Optional<InvitationCode> invitationCode
                = Optional.ofNullable(invitationCodeDao.selectInvitationCode(code));
        return ResponseEntity.of(invitationCode);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteInvitationCode(@RequestBody String code) {
        invitationCodeDao.deleteInvitationCode(code);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity<Void> updateInvitationCode(@RequestBody InvitationCode invitationCode) {
        int result = invitationCodeDao.updateInvitationCode(invitationCode);
        if (result == 1) return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }

    private String generateRandomCode() {
        while (true) {
            String code = generateValidCode();
            InvitationCode invitationCode = invitationCodeDao.selectInvitationCode(code);
            if (invitationCode == null) return code;
        }
    }

    private String generateValidCode() {
        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(10);
            codeBuilder.append(r);
        }
        return codeBuilder.toString();
    }
}
