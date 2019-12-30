package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IMemberGradeService;
import org.forbes.comm.model.MemberGradePageDto;
import org.forbes.comm.vo.MemberGradeVo;
import org.forbes.dal.entity.MemberGrade;
import org.forbes.dal.mapper.MemberGradeMapper;
import org.forbes.dal.mapper.ext.MemberGradeExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberGradeServiceImpl extends ServiceImpl<MemberGradeMapper,MemberGrade> implements IMemberGradeService {

    @Autowired
    MemberGradeExtMapper memberGradeExtMapper;


    /***
     * memberGradePage方法概述:获取分页会员等级列表
     * @param pageDto
     * @return
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/27
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @Override
    public IPage<MemberGradeVo> memberGradePage(IPage<MemberGradeVo> page, MemberGradePageDto pageDto) {
        return memberGradeExtMapper.memberGradePage(page,pageDto);
    }
}
