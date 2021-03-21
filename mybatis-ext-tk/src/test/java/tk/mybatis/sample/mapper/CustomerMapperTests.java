package tk.mybatis.sample.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.sample.entities.Customer;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerMapperTests {
    @Autowired
    CustomerMapper customerMapper;
    @Test
    public void save(){
        Customer c = new Customer();
        c.setName("zhangSan");
        //customerMapper.insert(c);
        customerMapper.selectOne(c);
    }
}
