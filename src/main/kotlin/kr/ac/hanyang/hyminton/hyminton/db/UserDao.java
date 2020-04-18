package kr.ac.hanyang.hyminton.hyminton.db;

import kr.ac.hanyang.hyminton.hyminton.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.db.UserDao
 * Author: 최기곤
 * Date  : 2020-04-12
 * Email : chlrlrhs95@gmail.com
 */
@Mapper
public interface UserDao {
    @Insert("INSERT INTO users VALUES(#{kakaoId},#{name},#{university},#{department},#{major},#{studentId},#{joinDate},#{joinType},#{type})")
    int insertUser(User user);

    @Select("SELECT * FROM users WHERE kakao_id=#{kakaoId}")
    User selectUser(int kakaoId);

    @Select("SELECT * FROM users")
    List<User> selectAllUser();

    @Update("<script>" +
            "UPDATE users " +
            "SET " +

            "<if test='name != null'>" +
            "name = #{name}, " +
            "</if>" +

            "<if test='university != null'>" +
            "university = #{university}, " +
            "</if>" +

            "<if test='department != null'>" +
            "department = #{department}, " +
            "</if>" +

            "<if test='major != null'>" +
            "major = #{major}, " +
            "</if>" +

            "<if test='studentId != null'>" +
            "student_id = #{studentId}, " +
            "</if>" +

            "<if test='joinDate != null'>" +
            "join_date = #{joinDate}, " +
            "</if>" +

            "<if test='joinType != null'>" +
            "join_type = #{joinType}, " +
            "</if>" +

            "<if test='type != null'>" +
            "type = #{type}, " +
            "</if>" +

            "kakao_id = #{kakaoId} " +

            "WHERE kakao_id = #{kakaoId}" +
            "</script>")
    int updateUser(User user);
}
