package tk.mybatis.sample.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionUtil {
    private static  SqlSessionFactory sqlSessionFactory;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory sessionFactory() throws IOException {
        return  sqlSessionFactory;
    }


    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
