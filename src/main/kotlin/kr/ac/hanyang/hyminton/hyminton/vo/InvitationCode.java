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
    private String memo;

    public InvitationCode() {}

    public InvitationCode(String code, String memo) {
        this.code = code;
        this.memo = memo;
    }
}
