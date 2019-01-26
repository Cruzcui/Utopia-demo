package utopia.dao;

import org.apache.ibatis.annotations.Param;

import utopia.model.TbUser;

public interface TbUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
    
    TbUser findByKeyword(@Param("keyword") String keyword);
}