package tk.mybatis.sample.entities;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

// TkMybatis默认使用继承Mapper接口中传入的实体类对象去数据库寻找对应的表,
// 因此如果表名与实体类名不满足对应规则时,会报错,这时使用@Table为实体类指定表。(这种对应规则为驼峰命名规则)
//下面以一个实体类Custoemr为例：
// @Table指定该实体类对应的表名,如表名为base_customer,类名为BaseCustomer可以不需要此注解
@Data
@Table(name = "t_customer")
public class Customer {

    // @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示使用数据库自带的主键生成策略.
    // @GeneratedValue中generator配置为"JDBC",在数据插入完毕之后,会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long id;

    private String name;

    private String code;

    private String status;

    private Date createDate;

    private Date lastUpdate;
}