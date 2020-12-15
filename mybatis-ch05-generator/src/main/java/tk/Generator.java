package tk;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static void main(String[] args) throws IOException, XMLParserException, SQLException, InterruptedException, InvalidConfigurationException {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;

        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");

        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        //   创建MBG
        MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
        // 执行生成代码
        generator.generate(null);
        // 输出警告信息
        for (String warn : warnings) {
            System.out.println(warn);
        }

    }

}
