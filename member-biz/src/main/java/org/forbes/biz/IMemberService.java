package org.forbes.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import org.forbes.comm.model.MemberDto;
import org.forbes.comm.vo.MemberVo;
import org.forbes.dal.entity.Member;

/**
 * @Author xfx
 * @Date 13:07 s
 * @Param 
 * @return 
 **/
public interface IMemberService extends IService<Member> {


    /***
     * 方法概述: 根据会员id查看会员详情
     * @param 
     * @return 
     * @创建人 xfx
     * @创建时间 2019/12/17
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    MemberVo detail(Long id);

    /***
     * 方法概述:会员注册
     * @param 
     * @return 
     * @创建人 xfx
     * @创建时间 2019/12/17
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    void addMember(MemberDto memberDto);

    /** 修改会员
     * @Author xfx
     * @Date 16:27 2019/12/17
     * @Param
     * @return
     **/
    void editMember(MemberDto memberDto);


}
