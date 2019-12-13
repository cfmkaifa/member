package org.forbes.dal.mapper;

import org.forbes.dal.entity.MemberCart;

public interface MemberCartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberCart record);

    int insertSelective(MemberCart record);

    MemberCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberCart record);

    int updateByPrimaryKey(MemberCart record);
}