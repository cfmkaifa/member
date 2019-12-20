package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IMemberAddressService;
import org.forbes.comm.model.PageMemberDto;
import org.forbes.comm.vo.MemberVo;
import org.forbes.dal.entity.MemberAddress;
import org.forbes.dal.mapper.MemberAddressMapper;
import org.forbes.dal.mapper.ext.MemberAddressExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/12/13 15:05
 */
@Service
public class MemberAddressServiceImpl extends ServiceImpl<MemberAddressMapper, MemberAddress> implements IMemberAddressService {

    @Autowired
    MemberAddressExtMapper memberAddressExtMapper;

    /***
     * pageUsers方法概述:分页查询会员详情
     * @param
     * @return
     * @创建人 Tom
     * @创建时间 2019/12/18 9:38
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @Override
    public IPage<MemberVo> pageMember(IPage<MemberVo> page, PageMemberDto pageMemberDto) {
        return memberAddressExtMapper.pageMember(page,pageMemberDto);
    }
}
