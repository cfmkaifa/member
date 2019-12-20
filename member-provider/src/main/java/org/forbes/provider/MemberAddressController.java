package org.forbes.provider;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IMemberAddressService;
import org.forbes.biz.IMemberService;
import org.forbes.comm.constant.SaveValid;
import org.forbes.comm.constant.UpdateValid;
import org.forbes.comm.enums.AddressStausEnum;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.enums.MemberStausEnum;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.PageMemberDto;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.MemberVo;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.Member;
import org.forbes.dal.entity.MemberAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lzw
 * @date 2019/12/13 15:09
 */
@RestController
@RequestMapping("/address")
@Api(tags={"会员地址管理"})
@Slf4j
public class MemberAddressController {
    @Autowired
    IMemberAddressService memberAddressService;

    @Autowired
    private IMemberService memberService;

    /***
     * selectAllAddress方法概述:
     * @param
     * @return org.forbes.comm.vo.Result<java.util.List<org.forbes.dal.entity.MemberAddress>>
     * @创建人 Tom
     * @创建时间 2019/12/13 15:33
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation("查询用户地址信息(当前用户跨库待补充)")
    @ApiResponses(value = {
            @ApiResponse(code=200,message =Result.ADDRESS_LIST_MSG),
            @ApiResponse(code = 500,message = Result.ADDRESS_LIST_ERROR_MSG)
    })
    public Result<List<MemberAddress>> selectAllAddress(){
        Result<List<MemberAddress>> result=new Result<>();
        List<MemberAddress> memberAddresses = memberAddressService.list();
        result.setResult(memberAddresses);
        return result;
    }

    @ApiOperation("添加地址信息")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = Result.COMM_ACTION_MSG),
            @ApiResponse(code=500,message = Result.COMM_ACTION_ERROR_MSG)
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<MemberAddress> addAddress(@RequestBody @Validated(value=SaveValid.class)MemberAddress memberAddress){
        log.debug("传入的参数为"+ JSON.toJSONString(memberAddress));
        Result<MemberAddress> result=new Result<MemberAddress>();
        memberAddressService.save(memberAddress);
        result.setResult(memberAddress);
        return result;
    }

    /***
     * updateAddress方法概述:
     * @param memberAddress
     * @return org.forbes.comm.vo.Result<org.forbes.dal.entity.MemberAddress>
     * @创建人 Tom
     * @创建时间 2019/12/13 15:58
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    @ApiOperation("编辑地址信息")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = Result.COMM_ACTION_MSG),
            @ApiResponse(code=500,message = Result.COMM_ACTION_ERROR_MSG)
    })
    public  Result<MemberAddress> updateAddress(@RequestBody @Validated(value=UpdateValid.class) MemberAddress memberAddress){
        log.debug("传入的参数为"+JSON.toJSONString(memberAddress));
        Result<MemberAddress> result=new Result<MemberAddress>();
        MemberAddress oldAddress = memberAddressService.getById(memberAddress.getId());
        if(ConvertUtils.isEmpty(oldAddress)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        memberAddressService.updateById(memberAddress);
        result.setResult(memberAddress);
        return result;
    }

    @ApiOperation("删除地址信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id",value = "地址ID",required = true)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<MemberAddress> delete(@RequestParam(name="id",required=true) String id) {
        Result<MemberAddress> result = new Result<MemberAddress>();
        MemberAddress memberAddress = memberAddressService.getById(id);
        if(ConvertUtils.isEmpty(memberAddress)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        memberAddressService.removeById(id);
        return result;
    }

    @RequestMapping(value = "/freeze-thaw",method = RequestMethod.PUT)
    @ApiOperation("是否默认地址")
    @ApiImplicitParam(value="status",name="地址状态",required=false)
    @ApiResponses(value = {
            @ApiResponse(code=500,message = Result.COMM_ACTION_ERROR_MSG),
            @ApiResponse(code=200,message = Result.COMM_ACTION_MSG)
    })
    public Result<MemberAddress> freezeOrThaw(@RequestParam(value="id",required=true) Long id,
                                        @RequestParam(value="isDefault",required=true)String isDefault){
        Result<MemberAddress> result=new Result<MemberAddress>();
        boolean isUserStatus = AddressStausEnum.existsAddressStausEnum(isDefault);
        if(!isUserStatus){
            result.setBizCode(BizResultEnum.ADRESS_STATUS_NO_EXISTS.getBizCode());
            result.setMessage(String.format(BizResultEnum.ADRESS_STATUS_NO_EXISTS.getBizFormateMessage(), isDefault));
            return result;
        }
        MemberAddress memberAddress = memberAddressService.getById(id);
        if(ConvertUtils.isEmpty(memberAddress)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        memberAddress.setIsDefault(isDefault);
        memberAddressService.updateById(memberAddress);
        return result;
    }

    /***
     * freeOrThaw方法概述:冻结/解冻会员
     * @param id, state
     * @return org.forbes.comm.vo.Result<org.forbes.dal.entity.Member>
     * @创建人 Tom
     * @创建时间 2019/12/18 9:29
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/free-thaw/{id}",method = RequestMethod.PUT)
    @ApiOperation("冻结/解冻会员")
    @ApiImplicitParam(value="state",name="会员状态",required=false)
    @ApiResponses(value = {
            @ApiResponse(code=500,message = Result.COMM_ACTION_ERROR_MSG),
            @ApiResponse(code=200,message = Result.COMM_ACTION_MSG)
    })
    public Result<Member> freeOrThaw(@PathVariable Long id,
                                     @RequestParam(value="status",required=true)String state){
        Result<Member> result=new Result<Member>();
        boolean isUserStatus = MemberStausEnum.existsMemberStausEnum(state);
        if(!isUserStatus){
            result.setBizCode(BizResultEnum.MEMBER_STATUS_NO_EXISTS.getBizCode());
            result.setMessage(String.format(BizResultEnum.MEMBER_STATUS_NO_EXISTS.getBizFormateMessage(), state));
            return result;
        }
        Member member = memberService.getById(id);
        if(ConvertUtils.isEmpty(member)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        member.setState(state);
        memberService.updateById(member);
        return result;
    }

    /***
     * pageUsers方法概述:分页查询会员详情
     * @param
     * @return
     * @创建人 Tom
     * @创建时间 2019/12/18 9:38
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ApiOperation("会员分页查询")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = Result.SELECT_LIST_MEMBER_AND_ROLE_MSG),
            @ApiResponse(code=500,message = Result.SELECT_LIST_MEMBER_AND_ROLE_ERROR_MSG)
    })
    public Result<IPage<MemberVo>> pageMember(BasePageDto basePageDto, PageMemberDto pageMemberDto){
        log.debug("=============="+JSON.toJSONString(basePageDto));
        Result<IPage<MemberVo>> result=new Result<IPage<MemberVo>>();
        IPage<MemberVo> page = new Page<MemberVo>(basePageDto.getPageNo(),basePageDto.getPageSize());
        IPage<MemberVo> pageUsers =  memberAddressService.pageMember(page, pageMemberDto);
        result.setResult(pageUsers);
        return result;
    }

}
