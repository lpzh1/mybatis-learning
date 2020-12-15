package tk.mybatis.sample.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 基本思路：参考mybatis已实现的类型转换！
 */
// Enabled 类型处理器
public class EnabledTypeHandle implements TypeHandler<Enabled> {
   private final Map<Integer,Enabled> enabledMap = new HashMap<>();

    public EnabledTypeHandle(){
        for (Enabled  enabled : Enabled.values()) {
          enabledMap.put(enabled.getValue(),enabled);
        }
        
    }
    @Override
    public void setParameter(PreparedStatement ps, int i, Enabled parameter, JdbcType jdbcType) throws SQLException {
        // 设置参数：java类型 ==> SQL参数（数据库类型）
        ps.setInt(i,parameter.getValue());
    }

    // 以下三个方法都是: 数据库类型 ===> java类型
    @Override
    public Enabled getResult(ResultSet rs, String columnName) throws SQLException {
        Integer value = rs.getInt(columnName);

        return enabledMap.get(value);
    }

    @Override
    public Enabled getResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer value = rs.getInt(columnIndex);

        return enabledMap.get(value);
    }

    @Override
    public Enabled getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer value = cs.getInt(columnIndex);

        return enabledMap.get(value);
    }
}
