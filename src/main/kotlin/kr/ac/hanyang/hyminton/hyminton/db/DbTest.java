package kr.ac.hanyang.hyminton.hyminton.db;

import kr.ac.hanyang.hyminton.hyminton.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * kr.ac.hanyang.hyminton.hyminton.db.DbTest
 * Author: 최기곤
 * Date  : 2020-04-12
 * Email : chlrlrhs95@gmail.com
 */
@RestController
@RequiredArgsConstructor
public class DbTest {
    private final UserDao userDao;

    @GetMapping("/user")
    public List<User> getAll() {
        return userDao.selectAllUser();
    }
    @GetMapping("/user/{kakaoId}")
    public User getOne(@PathVariable("kakaoId") String kakaoId) {
        return userDao.selectUser(kakaoId);
    }
    @DeleteMapping("/user")
    public int deleteOne(@RequestBody String kakaoId){
        return userDao.deleteUser(kakaoId);
    }
    @PutMapping("/user")
    public int putOne(@RequestBody User user){
        return userDao.updateUser(user);
    }
    @PostMapping("/user")
    public int postOne(@RequestBody User user){
        return userDao.insertUser(user);
    }

}
