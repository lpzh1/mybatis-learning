package tk.mybatis.sample.mapper;


import org.apache.ibatis.session.RowBounds;
import tk.mybatis.sample.model.SysDict;

import java.util.List;

public interface DictMapper {


    SysDict selectByPrimaryKey(Long id);

    List<SysDict> selectBySysDict(SysDict sysDict, RowBounds rowBounds);

    int insertDict(SysDict sysDict);

    int updateById(SysDict sysDict);

    int deleteById(Long id);
}
