package org.forbes.dal.mapper;

import org.forbes.dal.entity.MemberCartItem;

public interface MemberCartItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberCartItem record);

    int insertSelective(MemberCartItem record);

    MemberCartItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberCartItem record);

    int updateByPrimaryKey(MemberCartItem record);
}