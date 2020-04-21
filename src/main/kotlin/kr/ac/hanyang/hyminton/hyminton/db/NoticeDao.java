package kr.ac.hanyang.hyminton.hyminton.db;

import kr.ac.hanyang.hyminton.hyminton.vo.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.db.NoticeDao
 * Created by HyunI Kim.
 * Date: 2020-04-21
 * Email: jbhyunikim@gmail.com
 */
@Mapper
public interface NoticeDao {
    @Insert("INSERT INTO notices VALUES(#{id}, #{title}, #{content}, #{time}, #{author}, #{type})")
    int insertNotice(Notice notice);

    @Select("SELECT id, title, time, type FROM notices")
    List<Notice> selectNoticeTitles();

    @Select("SELECT * FROM notices WHERE id=#{id}")
    Notice selectNotice(String id);
}
