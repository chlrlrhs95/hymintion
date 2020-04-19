package kr.ac.hanyang.hyminton.hyminton.api;

import kr.ac.hanyang.hyminton.hyminton.db.WarningDao;
import kr.ac.hanyang.hyminton.hyminton.vo.Warning;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.api.WarningApi
 * Created by HyunI Kim.
 * Date: 2020-04-19
 * Email: jbhyunikim@gmail.com
 */
@RestController
@RequestMapping("/api/warning")
@RequiredArgsConstructor
public class WarningApi {
    private final WarningDao warningDao;

    @RequestMapping(value = "/{kakaoId}", method = RequestMethod.GET)
    List<Warning> getWarnings(@PathVariable int kakaoId) {
        return warningDao.selectWarnings(kakaoId);
    }

    @RequestMapping(method = RequestMethod.POST)
    int postWarning(@RequestBody Warning warning) {
        return warningDao.insertWarning(warning);
    }
}
