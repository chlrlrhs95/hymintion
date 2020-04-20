package kr.ac.hanyang.hyminton.hyminton.api;

import kr.ac.hanyang.hyminton.hyminton.db.LocationDao;
import kr.ac.hanyang.hyminton.hyminton.db.ParticipateDao;
import kr.ac.hanyang.hyminton.hyminton.db.PlayDao;
import kr.ac.hanyang.hyminton.hyminton.db.UserDao;
import kr.ac.hanyang.hyminton.hyminton.vo.Location;
import kr.ac.hanyang.hyminton.hyminton.vo.Participate;
import kr.ac.hanyang.hyminton.hyminton.vo.Play;
import kr.ac.hanyang.hyminton.hyminton.vo.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * kr.ac.hanyang.hyminton.hyminton.api.PlayApi
 * Created by HyunI Kim.
 * Date: 2020-04-20
 * Email: jbhyunikim@gmail.com
 */
@RestController
@RequestMapping("/api/play")
@RequiredArgsConstructor
public class PlayApi {
    private final PlayDao playDao;
    private final LocationDao locationDao;
    private final ParticipateDao participateDao;
    private final UserDao userDao;

    @RequestMapping(method = RequestMethod.POST)
    int postPlay(@RequestBody Play play) {
        return playDao.insertPlay(play);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Play> getPlays() {
        return playDao.selectPlays().stream()
                .peek(play -> {
                    Location location = locationDao.selectLocation(play.getLocation());
                    play.setLocationDetails(location);

                    int participants = participateDao.countParticipants(play.getId());
                    play.setParticipants(participants);
                })
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/expire", method = RequestMethod.POST, consumes = "application/json")
    int expirePlay(@RequestBody ExpireRequestBody body) {
        Play play = new Play();
        play.setId(body.playId);
        play.setExpires(body.expires);
        return playDao.updatePlay(play);
    }

    @RequestMapping(value = "/participate", method = RequestMethod.POST)
    int participate(@RequestBody Participate participate) {
        return participateDao.insertParticipate(participate);
    }

    @RequestMapping(value = "/participate/{playId}/{userId}", method = RequestMethod.DELETE)
    int cancelParticipate(@PathVariable int playId, @PathVariable int userId) {
        Participate p = new Participate() {{
            setPlayId(playId);
            setUserId(userId);
        }};

        return participateDao.deleteParticipate(p);
    }

    @RequestMapping(value = "/participate/{playId}", method = RequestMethod.GET)
    ResponseEntity<List<User>> getParticipants(@PathVariable int playId) {
        Play play = playDao.selectPlay(playId);
        if (play == null) return ResponseEntity.notFound().build();
        List<User> result = participateDao.getParticipants(playId).stream()
                .map(userDao::selectUser)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/participate/{playId}/{userId}", method = RequestMethod.GET)
    boolean checkIfUserParticipated(@PathVariable int playId, @PathVariable int userId) {
        return participateDao.checkParticipate(playId, userId) == 1;
    }

    @Data
    static class ExpireRequestBody {
        int playId;
        long expires;
    }
}
