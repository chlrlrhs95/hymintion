package kr.ac.hanyang.hyminton.hyminton.api;

import kr.ac.hanyang.hyminton.hyminton.db.UserDao;
import kr.ac.hanyang.hyminton.hyminton.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.api.UserApi
 * Created by HyunI Kim.
 * Date: 2020-04-19
 * Email: jbhyunikim@gmail.com
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApi {
    private final UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {
        return userDao.selectAllUser();
    }
    @RequestMapping(value = "/{kakaoId}", method = RequestMethod.GET)
    public User getOne(@PathVariable("kakaoId") int kakaoId) {
        return userDao.selectUser(kakaoId);
    }
    @RequestMapping(method = RequestMethod.POST)
    public int postOne(@RequestBody User user){
        return userDao.insertUser(user);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public int updateUser(@RequestBody User user) {
        return userDao.updateUser(user);
    }
}
