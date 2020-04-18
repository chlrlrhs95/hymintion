package kr.ac.hanyang.hyminton.hyminton.vo;

import lombok.Data;

/**
 * kr.ac.hanyang.hyminton.hyminton.vo.User
 * Author: 최기곤
 * Date  : 2020-04-12
 * Email : chlrlrhs95@gmail.com
 */
@Data
public class User {
    private int kakaoId;
    private String name;
    private String university;
    private String department;
    private String major;
    private String studentId;
    private long joinDate;
    private String joinType;
    private int type = -1;
}