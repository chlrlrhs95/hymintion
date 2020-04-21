package kr.ac.hanyang.hyminton.hyminton.api;

import kr.ac.hanyang.hyminton.hyminton.db.InvitationCodeDao;
import kr.ac.hanyang.hyminton.hyminton.services.RandomService;
import kr.ac.hanyang.hyminton.hyminton.vo.InvitationCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    private final RandomService random;

    @RequestMapping(method = RequestMethod.GET)
    List<InvitationCode> getAllInvitationCodes() {
        return invitationCodeDao.selectAllInvitationCodes();
    }

    @RequestMapping(method = RequestMethod.POST)
    String addInvitationCode(@RequestBody InvitationCode invitationCode) {
        String code = generateValidCode();
        invitationCode.setCode(code);
        invitationCodeDao.insertInvitationCode(invitationCode);
        return code;
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    ResponseEntity<InvitationCode> getInvitationCode(@PathVariable String code) {
        Optional<InvitationCode> invitationCode
                = Optional.ofNullable(invitationCodeDao.selectInvitationCode(code));
        return ResponseEntity.of(invitationCode);
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteInvitationCode(@PathVariable String code) {
        int result = invitationCodeDao.deleteInvitationCode(code);
        if (result == 0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    private String generateValidCode() {
        while (true) {
            String code = random.generateRandomCode(6);
            InvitationCode invitationCode = invitationCodeDao.selectInvitationCode(code);
            if (invitationCode == null) return code;
        }
    }
}
