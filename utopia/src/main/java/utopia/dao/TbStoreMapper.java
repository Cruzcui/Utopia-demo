package utopia.dao;

import utopia.model.TbStore;

public interface TbStoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbStore record);

    int insertSelective(TbStore record);

    TbStore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbStore record);

    int updateByPrimaryKey(TbStore record);
}