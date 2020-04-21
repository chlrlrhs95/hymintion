package kr.ac.hanyang.hyminton.hyminton.services;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * kr.ac.hanyang.hyminton.hyminton.services.RandomService
 * Created by HyunI Kim.
 * Date: 2020-04-21
 * Email: jbhyunikim@gmail.com
 */
@Service
public class RandomService {
    private Random random = new Random();

    private static final char[] VALID_ID_CHARS
            = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public String generateRandomId(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomCharIdx = random.nextInt(VALID_ID_CHARS.length);
            char randomChar = VALID_ID_CHARS[randomCharIdx];
            builder.append(randomChar);
        }
        return builder.toString();
    }

    public String generateRandomCode(int length) {
        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int r = random.nextInt(10);
            codeBuilder.append(r);
        }
        return codeBuilder.toString();
    }
}
