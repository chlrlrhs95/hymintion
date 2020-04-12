package kr.ac.hanyang.hyminton.hyminton.db;

import kr.ac.hanyang.hyminton.hyminton.vo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.db.UserDao
 * Author: 최기곤
 * Date  : 2020-04-12
 * Email : chlrlrhs95@gmail.com
 */
@Mapper
public interface UserDao {
    @Insert("INSERT INTO users VALUES(#{kakaoId},#{pw})")
    int insertUser(User user);
    @Update("UPDATE users SET pw=#{pw} WHERE kakao_id=#{kakaoId}")
    int updateUser(User user);
    @Delete("DELETE FROM users WHERE kakao_id=#{kakaoId}")
    int deleteUser(String kakaoId);
    @Select("SELECT kakao_id AS kakaoId, pw FROM users WHERE kakao_id=#{kakaoId}")
    User selectUser(String kakaoId);
    @Select("SELECT kakao_id AS kakaoId, pw FROM users")
    List<User> selectAllUser();
}
