package kr.ac.hanyang.hyminton.hyminton.vo;

import lombok.Data;

/**
 * kr.ac.hanyang.hyminton.hyminton.vo.Warning
 * Created by HyunI Kim.
 * Date: 2020-04-19
 * Email: jbhyunikim@gmail.com
 */
@Data
public class Warning {
    private int id;
    private int kakaoId;
    private String date;
    private String reason;
}
