package tk.mybatis.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("tk.mybatis.sample.mapper")
@SpringBootApplication
public class TkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkApplication.class);
    }
}
