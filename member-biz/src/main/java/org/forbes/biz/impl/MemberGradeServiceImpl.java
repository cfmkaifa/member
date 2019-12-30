package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IMemberGradeService;
import org.forbes.comm.constant.CommonConstant;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.exception.ForbesException;
import org.forbes.comm.model.MemberGradePageDto;
import org.forbes.comm.vo.MemberGradeVo;
import org.forbes.dal.entity.Member;
import org.forbes.dal.entity.MemberGrade;
import org.forbes.dal.mapper.MemberGradeMapper;
import org.forbes.dal.mapper.ext.MemberExtMapper;
import org.forbes.dal.mapper.ext.MemberGradeExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

@Service
public class MemberGradeServiceImpl extends ServiceImpl<MemberGradeMapper, MemberGrade> implements IMemberGradeService {

    @Autowired
    MemberGradeExtMapper memberGradeExtMapper;

    @Autowired
    MemberExtMapper memberExtMapper;


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
        return memberGradeExtMapper.memberGradePage(page, pageDto);
    }

    /***
     * deleteMemberGrade方法概述:批量删除会员等级
     * @param  idList
     * @return MemberGradeVo
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/27
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        idList.forEach(id -> {
            int childCount = memberExtMapper.selectCount(new QueryWrapper<Member>().eq(CommonConstant.GRADE_ID, id));//去会员表里查找有次会员等级的会员数量
            if (childCount > 0) {
                throw new ForbesException(
                        BizResultEnum.USER_GRADE_IN_USE.getBizCode(), BizResultEnum.USER_GRADE_IN_USE.getBizMessage()
                );
            }
        });
        return false;
    }
}
