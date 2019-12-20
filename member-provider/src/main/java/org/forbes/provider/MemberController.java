package org.forbes.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.forbes.api.service.ISysUserService;
import org.forbes.biz.IMemberService;
import org.forbes.comm.constant.DataColumnConstant;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.MemberDto;
import org.forbes.comm.model.SysLoginModel;
import org.forbes.comm.model.SysUser;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.LoginVo;
import org.forbes.comm.vo.MemberVo;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName
 * @Description TODO
 * @Author xfx
 * @Date 2019/12/17 13:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("/memeber")
@Api(tags={"会员"})
@Slf4j
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @Autowired
    private ISysUserService sysUserService;


    /***
     * login方法概述:会员登录
     * @param sysLoginModel
     * @return org.forbes.comm.vo.Result<org.forbes.dal.entity.Member>
     * @创建人 xfx
     * @创建时间 2019/12/17
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation("会员登录")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = Result.LOGIN_MSG),
            @ApiResponse(code = 500,message = Result.LOGIN_MSG_ERROR)
    })
    public Result<Member> login(@RequestBody @Valid SysLoginModel sysLoginModel){
        Result<Member> result=new Result<Member>();
        String username=sysLoginModel.getUsername();
        Result<LoginVo> sysUser=sysUserService.login(sysLoginModel);
        if(ConvertUtils.isEmpty(sysUser)){//根据user_id 验证用户是否存在，跨库
            result.setBizCode(BizResultEnum.USER_EXIST.getBizCode());
            result.setMessage(BizResultEnum.USER_EXIST.getBizMessage());
            return result;
        }
        Member member=memberService.getOne(new QueryWrapper<Member>().eq(DataColumnConstant.USER_ID,sysUser.getResult().getUserInfo().getId()));
        if(ConvertUtils.isEmpty(member)){
            result.setBizCode(BizResultEnum.MEMBER_EXIST.getBizCode());
            result.setMessage(BizResultEnum.MEMBER_EXIST.getBizMessage());
            return result;
        }
        result.setResult(member);
        return result;
    }

    /***
     * 方法概述:分页查询会员
     * @param basePageDto memberDto
     * @return 
     * @创建人 xfx
     * @创建时间 2019/12/19
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation("分页查询会员")
    @ApiResponses(value={
            @ApiResponse(code=500,message= Result.PAGE_MSG_ERROR),
            @ApiResponse(code=200,message = Result.PAGE_MSG)
    })
    public Result<IPage<Member>> page(BasePageDto basePageDto,MemberDto memberDto){
        Result<IPage<Member>> result=new Result<IPage<Member>>();
        QueryWrapper<Member> qw=new QueryWrapper<>();
        if(ConvertUtils.isNotEmpty(memberDto)){
            if(ConvertUtils.isNotEmpty(memberDto.getPhone())){
                qw.eq(DataColumnConstant.PHONE,memberDto.getPhone());
            }
        }
        IPage<Member> page=new Page<>(basePageDto.getPageNo(),basePageDto.getPageSize());
        IPage<Member> memberIPage=memberService.page(page,qw);
        result.setResult(memberIPage);
        return result;
    }

    /***
     * regist方法概述:会员注册
     * @param memberDto
     * @return org.forbes.comm.vo.Result<org.forbes.comm.model.MemberDto>
     * @创建人 xfx
     * @创建时间 2019/12/17
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ApiOperation("会员注册")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = Result.REGIST_MSG),
            @ApiResponse(code=500,message = Result.REGIST_MSG_ERROR)
    })
    public Result<MemberDto> regist(@RequestBody @Valid MemberDto memberDto){
        Result<MemberDto> result=new Result<MemberDto>();
        if(ConvertUtils.isNotEmpty(memberDto.getPhone())){
            String phone = memberDto.getPhone();
            int phonecount = memberService.count(new QueryWrapper<Member>().eq(DataColumnConstant.PHONE, phone));
            if(phonecount > 0){
                result.setBizCode(BizResultEnum.PHONE_EXISTS.getBizCode());
                result.setMessage(String.format(BizResultEnum.PHONE_EXISTS.getBizFormateMessage(), phone));
                return result;
            }
        }
        //根据联系方式验证用户是否存在
        SysUser sysUser=sysUserService.getUserByName(memberDto.getPhone());
        if(!ConvertUtils.isEmpty(sysUser)){
            result.setBizCode(BizResultEnum.USERNAME_EXISTS.getBizCode());
            result.setMessage(BizResultEnum.USERNAME_EXISTS.getBizMessage());
            return result;
        }

        if(ConvertUtils.isNotEmpty(memberDto.getEmail())){
            String email = memberDto.getEmail();
            int emailcount = memberService.count(new QueryWrapper<Member>().eq(DataColumnConstant.EMAIL, email));
            if(emailcount > 0){
                result.setBizCode(BizResultEnum.USER_EMAIL_EXISTS.getBizCode());
                result.setMessage(String.format(BizResultEnum.USER_EMAIL_EXISTS.getBizFormateMessage(), email));
                return result;
            }
        }
        if(ConvertUtils.isNotEmpty(memberDto.getFax())){
            String fax = memberDto.getFax();
            int faxcount = memberService.count(new QueryWrapper<Member>().eq(DataColumnConstant.FAX, fax));
            if(faxcount > 0){
                result.setBizCode(BizResultEnum.FAX.getBizCode());
                result.setMessage(String.format(BizResultEnum.FAX.getBizFormateMessage(), fax));
                return result;
            }
        }
        if(ConvertUtils.isNotEmpty(memberDto.getOrgCode())){//校验机构代码
            String orgcode = memberDto.getOrgCode();
            int orgcodecount = memberService.count(new QueryWrapper<Member>().eq(DataColumnConstant.ORG_CODE, orgcode));
            if(orgcodecount > 0){
                result.setBizCode(BizResultEnum.ORG_CODE.getBizCode());
                result.setMessage(String.format(BizResultEnum.ORG_CODE.getBizFormateMessage(), orgcode));
                return result;
            }
        }
        memberService.addMember(memberDto);
        result.setResult(memberDto);
        return result;
    }


    /***
     * detail方法概述:会员详情
     * @param id
     * @return org.forbes.comm.vo.Result<org.forbes.dal.entity.Member>
     * @创建人 xfx
     * @创建时间 2019/12/17
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    @ApiOperation("会员详情")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = Result.MEMBER_MSG),
            @ApiResponse(code=500,message = Result.MEMBER_MSG_ERROR)
    })
    public Result<MemberVo> detail(@RequestParam(name ="id",required = true)Long id){
        Result<MemberVo> result=new  Result<MemberVo>();
        MemberVo membervo=memberService.detail(id);
        result.setResult(membervo);
        return result;
    }


    /***
     * update方法概述:
     * @param memberDto
     * @return org.forbes.comm.vo.Result<org.forbes.comm.model.MemberDto>
     * @创建人 xfx
     * @创建时间 2019/12/19
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/update-member",method = RequestMethod.PUT)
    @ApiOperation("会员修改")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message =Result.UPD_MEMBER_MSG),
            @ApiResponse(code = 500,message = Result.UPD_MEMBER_MSG_ERROR)
    })
    public Result<MemberDto> update(@RequestBody MemberDto memberDto){
        Result<MemberDto> result=new Result<MemberDto>();
        Member member=memberService.getById(memberDto.getId());
        if(ConvertUtils.isEmpty(member)){//判断会员是否为空
            result.setBizCode(BizResultEnum.MEMBER_EXIST.getBizCode());
            result.setMessage(String.format(BizResultEnum.MEMBER_EXIST.getBizFormateMessage(),memberDto.getId()));
            return result;
        }

        String email = memberDto.getEmail();
        if(!email.equalsIgnoreCase(member.getEmail())){
            if(ConvertUtils.isNotEmpty(memberDto.getEmail())){
                int emailcount = memberService.count(new QueryWrapper<Member>().eq(DataColumnConstant.EMAIL, email));
                if(emailcount > 0){
                    result.setBizCode(BizResultEnum.USER_EMAIL_EXISTS.getBizCode());
                    result.setMessage(String.format(BizResultEnum.USER_EMAIL_EXISTS.getBizFormateMessage(), email));
                    return result;
                }
            }
        }
        String phone = memberDto.getPhone();
        if(!phone.equalsIgnoreCase(member.getPhone())){
            if(ConvertUtils.isNotEmpty(memberDto.getPhone())){
                int phonecount = memberService.count(new QueryWrapper<Member>().eq(DataColumnConstant.PHONE, phone));
                if(phonecount > 0){
                    result.setBizCode(BizResultEnum.PHONE_EXISTS.getBizCode());
                    result.setMessage(String.format(BizResultEnum.PHONE_EXISTS.getBizFormateMessage(), phone));
                    return result;
                }
            }
        }

        String fax = memberDto.getFax();
        if(!fax.equalsIgnoreCase(member.getFax())){
            if(ConvertUtils.isNotEmpty(memberDto.getFax())){
                int faxcount = memberService.count(new QueryWrapper<Member>().eq(DataColumnConstant.FAX, fax));
                if(faxcount > 0){
                    result.setBizCode(BizResultEnum.FAX.getBizCode());
                    result.setMessage(String.format(BizResultEnum.FAX.getBizFormateMessage(), fax));
                    return result;
                }
            }
        }

        String orgcode = memberDto.getOrgCode();
        if(!orgcode.equalsIgnoreCase(member.getOrgCode())){
            if(ConvertUtils.isNotEmpty(memberDto.getOrgCode())){//校验机构代码
                int orgcodecount = memberService.count(new QueryWrapper<Member>().eq(DataColumnConstant.ORG_CODE, orgcode));
                if(orgcodecount > 0){
                    result.setBizCode(BizResultEnum.ORG_CODE.getBizCode());
                    result.setMessage(String.format(BizResultEnum.ORG_CODE.getBizFormateMessage(), orgcode));
                    return result;
                }
            }
        }
        memberService.editMember(memberDto);
        result.setResult(memberDto);
        return result;
    }
}
