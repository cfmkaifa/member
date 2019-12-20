package org.forbes.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.forbes.comm.model.PageMemberDto;
import org.forbes.comm.vo.MemberVo;
import org.forbes.dal.entity.MemberAddress;

/**
 * @author lzw
 * @date 2019/12/13 15:05
 */
public interface IMemberAddressService extends IService<MemberAddress> {

    /***
     * pageUsers方法概述:分页查询会员详情
     * @param
     * @return
     * @创建人 Tom
     * @创建时间 2019/12/18 9:38
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    IPage<MemberVo> pageMember(IPage<MemberVo> page, PageMemberDto pageMemberDto);

}
