package kr.ac.hanyang.hyminton.hyminton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * kr.ac.hanyang.hyminton.hyminton.GlobalConfiguration
 * Created by HyunI Kim.
 * Date: 2020-04-19
 * Email: jbhyunikim@gmail.com
 */
@Configuration
public class GlobalConfiguration {
    @Bean
    Random randomBean() {
        return new Random();
    }
}
