package kr.ac.hanyang.hyminton.hyminton;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * kr.ac.hanyang.hyminton.hyminton.SampleController
 * Created by HyunI Kim.
 * Date: 2020-04-12
 * Email: jbhyunikim@gmail.com
 */
@RestController
public class ExampleController {
    @GetMapping("/")
    public String getSample() {
        return "example";
    }
}
