package org.forbes.dal.mapper;

import org.forbes.dal.entity.MemberAddress;

public interface MemberAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberAddress record);

    int insertSelective(MemberAddress record);

    MemberAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberAddress record);

    int updateByPrimaryKey(MemberAddress record);
}