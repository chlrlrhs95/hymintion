package kr.ac.hanyang.hyminton.hyminton.db;

import kr.ac.hanyang.hyminton.hyminton.vo.Play;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.db.Play
 * Created by HyunI Kim.
 * Date: 2020-04-20
 * Email: jbhyunikim@gmail.com
 */
@Mapper
public interface PlayDao {
    @Insert("INSERT INTO plays(location, type, start, end, expires, `limit`) " +
            "VALUES(#{location}, #{type}, #{start}, #{end}, #{expires}, #{limit})")
    int insertPlay(Play play);

    @Select("SELECT * FROM plays")
    List<Play> selectPlays();

    @Select("SELECT * FROM plays WHERE id=#{id}")
    Play selectPlay(int id);

    @Update("<script>" +
            "UPDATE plays " +
            "SET " +

            "<if test='location != null'>" +
            "location = #{location}, " +
            "</if>" +

            "<if test='type != null'>" +
            "type = #{type}, " +
            "</if>" +

            "<if test='start != 0'>" +
            "start = #{start}, " +
            "</if>" +

            "<if test='end != 0'>" +
            "end = #{end}, " +
            "</if>" +

            "<if test='expires != -1'>" +
            "expires = #{expires}, " +
            "</if>" +

            "<if test='limit != -1'>" +
            "limit = #{limit}, " +
            "</if>" +

            "id = #{id} " +

            "WHERE id = #{id}" +
            "</script>")
    int updatePlay(Play play);
}
