package kr.ac.hanyang.hyminton.hyminton.api;

import kr.ac.hanyang.hyminton.hyminton.db.InvitationCodeDao;
import kr.ac.hanyang.hyminton.hyminton.vo.InvitationCode;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
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

    @RequestMapping(method = RequestMethod.GET)
    List<InvitationCode> getAllInvitationCodes() {
        return invitationCodeDao.selectAllInvitationCodes();
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<String> addInvitationCode(@RequestBody InvitationCode invitationCode) {
        try {
            invitationCodeDao.insertInvitationCode(invitationCode);
            return ResponseEntity.ok().build();
        } catch (DuplicateKeyException e) {
            return ResponseEntity.badRequest().body("Code already exists");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Unknown error");
        }
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
}
