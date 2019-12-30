package org.forbes.dal.mapper.ext;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.forbes.comm.model.MemberGradePageDto;
import org.forbes.comm.vo.MemberGradeVo;

public interface MemberGradeExtMapper {

    /***
     * memberGradePage方法概述:获取分页会员等级列表
     * @param pageDto
     * @return
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/27
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    IPage<MemberGradeVo> memberGradePage(IPage<MemberGradeVo> page, @Param("pageDto") MemberGradePageDto pageDto);
}
