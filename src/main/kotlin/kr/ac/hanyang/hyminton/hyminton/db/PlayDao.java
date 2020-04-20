package kr.ac.hanyang.hyminton.hyminton.db;

import kr.ac.hanyang.hyminton.hyminton.vo.Play;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
