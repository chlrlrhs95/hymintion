package kr.ac.hanyang.hyminton.hyminton.vo;

import lombok.Data;

/**
 * kr.ac.hanyang.hyminton.hyminton.vo.Play
 * Created by HyunI Kim.
 * Date: 2020-04-20
 * Email: jbhyunikim@gmail.com
 */
@Data
public class Play {
    private int id;
    private String location;
    private String type;
    private long start;
    private long end;
    private long expires;
    private int limit;

    private int participants;
    private Location locationDetails;
}
