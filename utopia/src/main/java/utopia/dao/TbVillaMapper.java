package utopia.dao;

import utopia.model.TbVilla;

public interface TbVillaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbVilla record);

    int insertSelective(TbVilla record);

    TbVilla selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbVilla record);

    int updateByPrimaryKeyWithBLOBs(TbVilla record);

    int updateByPrimaryKey(TbVilla record);
}