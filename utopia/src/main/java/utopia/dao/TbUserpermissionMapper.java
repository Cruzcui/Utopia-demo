package utopia.dao;

import utopia.model.TbUserpermission;

public interface TbUserpermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserpermission record);

    int insertSelective(TbUserpermission record);

    TbUserpermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserpermission record);

    int updateByPrimaryKey(TbUserpermission record);
}