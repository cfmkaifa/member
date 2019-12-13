package org.forbes.dal.mapper;

import org.forbes.dal.entity.MemberAttach;

public interface MemberAttachMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberAttach record);

    int insertSelective(MemberAttach record);

    MemberAttach selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberAttach record);

    int updateByPrimaryKey(MemberAttach record);
}