package kr.ac.hanyang.hyminton.hyminton.db;

import kr.ac.hanyang.hyminton.hyminton.vo.Participate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.db.ParticipateDao
 * Created by HyunI Kim.
 * Date: 2020-04-20
 * Email: jbhyunikim@gmail.com
 */
@Mapper
public interface ParticipateDao {
    @Select("SELECT user_id FROM participates WHERE play_id=#{playId}")
    List<Integer> getParticipants(int playId);

    @Select("SELECT COUNT(user_id) FROM participates WHERE play_id=#{playId}")
    int countParticipants(int playId);

    @Select("SELECT COUNT(user_id) FROM participates WHERE play_id=#{playId} AND user_id=#{userId}")
    int checkParticipate(int playId, int userId);

    @Insert("INSERT INTO participates VALUES(#{playId}, #{userId})")
    int insertParticipate(Participate participate);

    @Delete("DELETE FROM participates WHERE play_id=#{playId} AND user_id=#{userId}")
    int deleteParticipate(Participate participate);
}
