package tk.mybatis.sample.service.impl;

// import com.sun.istack.internal.NotNull;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.sample.mapper.DictMapper;
import tk.mybatis.sample.model.SysDict;
import tk.mybatis.sample.service.DictService;

import java.util.List;


@Service
public class DictServiceImpl implements DictService {

    @Autowired
    DictMapper dictMapper;

    @Override
    public SysDict findById(Long id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysDict> findBySysDict(SysDict sysDict, Integer offset, Integer limit) {
        RowBounds rowBounds = RowBounds.DEFAULT;

        if (offset != null && limit != null) {
            rowBounds = new RowBounds(offset, limit);
        }
        return dictMapper.selectBySysDict(sysDict, rowBounds);
    }

    @Override
    public boolean saveOrUpdate(SysDict sysDict) {
        if (sysDict.getId() == null) {
            return dictMapper.insertDict(sysDict) == 1;
        }
        return dictMapper.updateById(sysDict) == 1;
    }

    @Override
    public boolean deleteById(Long id) {
        return dictMapper.deleteById(id) == 1;
    }
}
