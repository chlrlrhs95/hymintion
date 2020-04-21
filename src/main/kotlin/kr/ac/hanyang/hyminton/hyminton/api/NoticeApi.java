package kr.ac.hanyang.hyminton.hyminton.api;

import kr.ac.hanyang.hyminton.hyminton.db.NoticeDao;
import kr.ac.hanyang.hyminton.hyminton.db.UserDao;
import kr.ac.hanyang.hyminton.hyminton.services.RandomService;
import kr.ac.hanyang.hyminton.hyminton.vo.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.api.NoticeApi
 * Created by HyunI Kim.
 * Date: 2020-04-21
 * Email: jbhyunikim@gmail.com
 */
@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeApi {
    private final NoticeDao noticeDao;
    private final UserDao userDao;
    private final RandomService random;

    @RequestMapping(method = RequestMethod.GET)
    List<Notice> getNoticeTitles() {
        return noticeDao.selectNoticeTitles();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Notice> getNotice(@PathVariable String id) {
        Notice notice = noticeDao.selectNotice(id);
        if (notice == null) return ResponseEntity.notFound().build();

        notice.setAuthorDetails(userDao.selectUser(notice.getAuthor()));

        return ResponseEntity.ok(notice);
    }

    @RequestMapping(method = RequestMethod.POST)
    String postNotice(@RequestBody Notice notice) {
        notice.setId(generateValidId());
        int result = noticeDao.insertNotice(notice);
        if (result != 1) return null;
        return notice.getId();
    }

    private String generateValidId() {
        while (true) {
            String id = random.generateRandomId(15);
            Notice notice = noticeDao.selectNotice(id);
            if (notice == null) return id;
        }
    }
}
