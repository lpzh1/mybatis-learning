package tk.mybatis.sample.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import tk.mybatis.sample.param.CountryParam;
import tk.mybatis.sample.util.SqlSessionUtil;

@Slf4j
public class CountryMapperTest {

    @Before
    public void init() {

    }

    @Test
    public void selectCountryById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Long id = 2L;
        Object country = sqlSession.selectOne("selectCountryById", id);
        log.info("{}", country);
    }

    @Test
    public void saveCountry() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CountryParam countryParam = new CountryParam();
        countryParam.setCountryname("中国");
        countryParam.setCountrycode("002");
        sqlSession.insert("saveCountry", countryParam);
        // 提交事务
        // 事务 默认是回滚的
        sqlSession.commit();
    }
}
