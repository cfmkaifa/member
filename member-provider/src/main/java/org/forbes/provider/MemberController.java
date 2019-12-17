package org.forbes.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IMemberService;
import org.forbes.comm.constant.DataColumnConstant;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.model.MemberDto;
import org.forbes.comm.utils.ConvertUtils;
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


    /***
     * login方法概述:会员登录
     * @param username, passwords
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
    public Result<Member> login(@RequestParam(value = "username",required = true)String username,@RequestParam(value = "password",required = true)String password){
        Result<Member> result=new Result<Member>();
        //根据user_id 验证用户是否存在，跨库



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
        //根据联系方式验证用户是否存在，复制user_id（跨库）




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

        if(ConvertUtils.isNotEmpty(memberDto.getEmail())){
            String email = memberDto.getEmail();
            int emailcount = memberService.count(new QueryWrapper<Member>().eq(DataColumnConstant.EMAIL, email));
            if(emailcount > 0){
                result.setBizCode(BizResultEnum.USER_EMAIL_EXISTS.getBizCode());
                result.setMessage(String.format(BizResultEnum.USER_EMAIL_EXISTS.getBizFormateMessage(), email));
                return result;
            }
        }
        if(ConvertUtils.isNotEmpty(memberDto.getPhone())){
            String phone = memberDto.getPhone();
            int phonecount = memberService.count(new QueryWrapper<Member>().eq(DataColumnConstant.PHONE, phone));
            if(phonecount > 0){
                result.setBizCode(BizResultEnum.PHONE_EXISTS.getBizCode());
                result.setMessage(String.format(BizResultEnum.PHONE_EXISTS.getBizFormateMessage(), phone));
                return result;
            }
        }
        //根据联系方式验证用户是否存在，复制user_id（跨库）



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
        memberService.editMember(memberDto);
        result.setResult(memberDto);
        return result;
    }
}
