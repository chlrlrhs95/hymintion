package kr.ac.hanyang.hyminton.hyminton.api;

import kr.ac.hanyang.hyminton.hyminton.db.LocationDao;
import kr.ac.hanyang.hyminton.hyminton.vo.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.api.LocationApi
 * Created by HyunI Kim.
 * Date: 2020-04-20
 * Email: jbhyunikim@gmail.com
 */
@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationApi {
    private final LocationDao locationDao;

    @RequestMapping(method = RequestMethod.GET)
    List<Location> getAllLocations() {
        return locationDao.selectAllLocations();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    ResponseEntity<Location> getLocation(@PathVariable String name) {
        Location location = locationDao.selectLocation(name);
        if (location == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(location);
    }

    @RequestMapping(method = RequestMethod.POST)
    int postLocation(@RequestBody Location location) {
        return locationDao.insertLocation(location);
    }
}
