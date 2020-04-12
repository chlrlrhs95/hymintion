package kr.ac.hanyang.hyminton.hyminton

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/** kr.ac.hanyang.hyminton.hyminton.HymintonApplication
 * Created by HyunI Kim.
 * Date: 2020-04-12
 * Email: jbhyunikim@gmail.com
 */

@SpringBootApplication
@MapperScan(basePackages = ["kr.ac.hanyang.hyminton.hyminton"])
class HymintonApplication

fun main(args: Array<String>) {
    runApplication<HymintonApplication>(*args)
}