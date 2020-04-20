package kr.ac.hanyang.hyminton.hyminton.api;

import kr.ac.hanyang.hyminton.hyminton.db.LocationDao;
import kr.ac.hanyang.hyminton.hyminton.db.PlayDao;
import kr.ac.hanyang.hyminton.hyminton.vo.Location;
import kr.ac.hanyang.hyminton.hyminton.vo.Play;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
                })
                .collect(Collectors.toList());
    }
}
