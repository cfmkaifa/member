package org.forbes.dal.mapper.ext;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.forbes.comm.model.PageMemberDto;
import org.forbes.comm.vo.MemberVo;
import org.forbes.dal.entity.MemberAddress;

/**
 * @author lzw
 * @date 2019/12/13 14:44
 */
public interface MemberAddressExtMapper extends BaseMapper<MemberAddress> {

    /***
     * pageUsers方法概述:分页查询会员详情
     * @param
     * @return
     * @创建人 Tom
     * @创建时间 2019/12/18 9:38
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    IPage<MemberVo> pageMember(IPage<MemberVo> page, @Param("pageMemberDto") PageMemberDto pageMemberDto);
}
