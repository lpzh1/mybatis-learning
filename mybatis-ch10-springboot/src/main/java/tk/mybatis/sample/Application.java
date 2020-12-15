package tk.mybatis.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.sample.mapper.CountryMapper;

@SpringBootApplication
public class Application  implements CommandLineRunner {
    @Autowired
    CountryMapper countryMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


    @Override
    public void run(String... args) throws Exception {
        countryMapper.selectAll();
    }
}
