package kr.ac.hanyang.hyminton.hyminton.db;

import kr.ac.hanyang.hyminton.hyminton.vo.Warning;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.db.WarningDao
 * Created by HyunI Kim.
 * Date: 2020-04-19
 * Email: jbhyunikim@gmail.com
 */
@Mapper
public interface WarningDao {
    @Select("SELECT * FROM warnings WHERE kakao_id=#{kakaoId}")
    List<Warning> selectWarnings(int kakaoId);

    @Insert("INSERT INTO warnings(kakao_id, date, reason) " +
            "VALUES(#{kakaoId}, #{date}, #{reason})")
    int insertWarning(Warning warning);
}
