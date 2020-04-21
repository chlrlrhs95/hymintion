package kr.ac.hanyang.hyminton.hyminton.vo;

import lombok.Data;

/**
 * kr.ac.hanyang.hyminton.hyminton.vo.Notice
 * Created by HyunI Kim.
 * Date: 2020-04-21
 * Email: jbhyunikim@gmail.com
 */
@Data
public class Notice {
    private String id;
    private String title;
    private String content;
    private long time;
    private int author;
    private int type;

    private User authorDetails;
}
