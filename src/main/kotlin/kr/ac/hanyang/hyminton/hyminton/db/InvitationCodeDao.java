package kr.ac.hanyang.hyminton.hyminton.db;

import kr.ac.hanyang.hyminton.hyminton.vo.InvitationCode;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.db.InvitationCodeDao
 * Created by HyunI Kim.
 * Date: 2020-04-19
 * Email: jbhyunikim@gmail.com
 */
@Mapper
public interface InvitationCodeDao {
    @Insert("INSERT INTO invitation_code VALUES(#{code}, #{name}, #{joinMonth}, #{joinType})")
    void insertInvitationCode(InvitationCode invitationCode);

    @Select("SELECT * FROM invitation_code")
    List<InvitationCode> selectAllInvitationCodes();

    @Select("SELECT * FROM invitation_code WHERE code=#{code}")
    InvitationCode selectInvitationCode(String code);

    @Delete("DELETE FROM invitation_code WHERE code=#{code}")
    int deleteInvitationCode(String code);
}
