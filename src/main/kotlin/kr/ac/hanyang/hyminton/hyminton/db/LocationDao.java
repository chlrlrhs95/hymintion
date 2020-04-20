package kr.ac.hanyang.hyminton.hyminton.db;

import kr.ac.hanyang.hyminton.hyminton.vo.Location;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.db.LocationDao
 * Created by HyunI Kim.
 * Date: 2020-04-20
 * Email: jbhyunikim@gmail.com
 */
@Mapper
public interface LocationDao {
    @Insert("INSERT INTO locations VALUES(" +
            "#{name}, #{address}, #{lat}, #{lng}, " +
            "#{weekdayFee}, #{weekendFee}, #{courtCount}" +
            ")")
    int insertLocation(Location location);

    @Select("SELECT * FROM locations WHERE name=#{name}")
    Location selectLocation(String name);

    @Select("SELECT * FROM locations")
    List<Location> selectAllLocations();

}
