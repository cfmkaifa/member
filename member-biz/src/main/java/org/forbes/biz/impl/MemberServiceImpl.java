package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IMemberService;
import org.forbes.comm.constant.DataColumnConstant;
import org.forbes.comm.model.MemberAttachDto;
import org.forbes.comm.model.MemberDto;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.MemberVo;
import org.forbes.dal.entity.Member;
import org.forbes.dal.entity.MemberAttach;
import org.forbes.dal.mapper.MemberAttachMapper;
import org.forbes.dal.mapper.MemberMapper;
import org.forbes.dal.mapper.ext.MemberExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author
 * @Date 2019/12/17 13:07
 * @Version 1.0
 **/
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper,Member> implements IMemberService {


    @Autowired
    private MemberAttachMapper memberAttachMapper;

    @Autowired
    private MemberExtMapper memberExtMapper;

    /***
     * 方法概述: 根据会员id查看会员详情
     * @param
     * @return
     * @创建人 xfx
     * @创建时间 2019/12/17
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @Override
    public MemberVo detail(Long id) {
        return memberExtMapper.detail(id);
    }

    /***
     * 方法概述:会员注册
     * @param
     * @return
     * @创建人 xfx
     * @创建时间 2019/12/17
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void addMember(MemberDto memberDto) {
        Member member=new Member();
        BeanCopier.create(MemberDto.class,Member.class ,false)
                .copy(memberDto, member, null);
        baseMapper.insert(member);

        //会员附件关联
        List<MemberAttachDto> memberAttachDtos=memberDto.getMemberAttachDtos();
        if(ConvertUtils.isNotEmpty(memberAttachDtos)){
            Long memberId = member.getId();
            memberAttachDtos.stream().forEach(temp -> {
                MemberAttach memberAttach=new MemberAttach();
                memberAttach.setCnName(temp.getCnName());
                memberAttach.setDataId(memberId);
                memberAttach.setEnName(temp.getEnName());
                memberAttach.setDataType(temp.getDataType());
                memberAttach.setOrdersSort(temp.getOrdersSort());
                memberAttach.setFilePath(temp.getFilePath());
                memberAttach.setSuffix(temp.getSuffix());
                memberAttach.setType(temp.getType());
                memberAttachMapper.insert(memberAttach);
            });
        }
    }

   /***
    * 方法概述:会员编辑
    * @param
    * @return
    * @创建人 xfx
    * @创建时间 2019/12/17
    * @修改人 (修改了该文件，请填上修改人的名字)
    * @修改日期 (请填上修改该文件时的日期)
    */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public void editMember(MemberDto memberDto) {
        Member member=new Member();
        BeanCopier.create(MemberDto.class,Member.class ,false)
                .copy(memberDto, member, null);
        baseMapper.updateById(member);
        //先删后加
        memberAttachMapper.delete(new QueryWrapper<MemberAttach>().eq(DataColumnConstant.ID, memberDto.getId()));
        List<MemberAttachDto> memberAttachDtos=memberDto.getMemberAttachDtos();
        if(ConvertUtils.isNotEmpty(memberAttachDtos)){
            Long memberId = member.getId();
            memberAttachDtos.stream().forEach(temp -> {
                MemberAttach memberAttach=new MemberAttach();
                memberAttach.setCnName(temp.getCnName());
                memberAttach.setDataId(memberId);
                memberAttach.setEnName(temp.getEnName());
                memberAttach.setDataType(temp.getDataType());
                memberAttach.setOrdersSort(temp.getOrdersSort());
                memberAttach.setFilePath(temp.getFilePath());
                memberAttach.setSuffix(temp.getSuffix());
                memberAttach.setType(temp.getType());
                memberAttachMapper.insert(memberAttach);
            });
        }
    }
}
