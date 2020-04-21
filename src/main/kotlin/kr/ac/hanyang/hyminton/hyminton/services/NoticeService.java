package kr.ac.hanyang.hyminton.hyminton.services;

import kr.ac.hanyang.hyminton.hyminton.db.NoticeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * kr.ac.hanyang.hyminton.hyminton.services.NoticeService
 * Created by HyunI Kim.
 * Date: 2020-04-21
 * Email: jbhyunikim@gmail.com
 */
@Service
@RequiredArgsConstructor
public class NoticeService {
    private final RandomService random;
    private final NoticeDao noticeDao;

    private static final char[] VALID_ID_CHARS
            = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public String generateRandomId() {

        return "123";
    }
}
