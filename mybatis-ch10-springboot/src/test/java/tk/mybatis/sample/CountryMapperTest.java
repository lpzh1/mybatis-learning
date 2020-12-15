package tk.mybatis.sample;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.sample.mapper.CountryMapper;
import tk.mybatis.sample.model.Country;

public class CountryMapperTest extends ApplicationTest {
    @Autowired
    CountryMapper countryMapper;

    @Test
    public void insert() {
        Country country = new Country();
        country.setCountryname("美國");
        country.setCountrycode("088");
        countryMapper.insert(country);
    }


    @Test
    public void selectAll(){
        countryMapper.selectAll();
    }
}
