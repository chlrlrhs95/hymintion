package kr.ac.hanyang.hyminton.hyminton.vo;

import lombok.Data;

/**
 * kr.ac.hanyang.hyminton.hyminton.vo.InvitationCode
 * Created by HyunI Kim.
 * Date: 2020-04-19
 * Email: jbhyunikim@gmail.com
 */
@Data
public class InvitationCode {
    private String code;
    private String name;
    private String joinMonth;
    private String joinType;

    public InvitationCode() {}

    public InvitationCode(String code, String name, String joinMonth, String joinType) {
        this.code = code;
        this.name = name;
        this.joinMonth = joinMonth;
        this.joinType = joinType;
    }
}
