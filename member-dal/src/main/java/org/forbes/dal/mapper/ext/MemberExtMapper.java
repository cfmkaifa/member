package org.forbes.dal.mapper.ext;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.forbes.comm.vo.MemberVo;
import org.forbes.dal.entity.Member;

/**
 * @ClassName
 * @Description TODO
 * @Author
 * @Date 2019/12/17 14:38
 * @Version 1.0
 **/
public interface MemberExtMapper extends BaseMapper<Member>{

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
}
