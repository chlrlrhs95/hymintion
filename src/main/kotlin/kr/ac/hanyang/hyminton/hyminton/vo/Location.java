package kr.ac.hanyang.hyminton.hyminton.vo;

import lombok.Data;

/**
 * kr.ac.hanyang.hyminton.hyminton.vo.Location
 * Created by HyunI Kim.
 * Date: 2020-04-20
 * Email: jbhyunikim@gmail.com
 */
@Data
public class Location {
    private String name;
    private String address;
    private double lat;
    private double lng;
    private int weekdayFee;
    private int weekendFee;
    private int courtCount;
}
