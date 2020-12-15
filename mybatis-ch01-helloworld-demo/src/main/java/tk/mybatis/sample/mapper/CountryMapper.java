package tk.mybatis.sample.mapper;


import org.apache.ibatis.annotations.Param;
import tk.mybatis.sample.model.Country;
import tk.mybatis.sample.param.CountryParam;

public interface CountryMapper {

    public void saveCountry(CountryParam param);

    public Country selectCountryById(@Param("id") Long id);


}
