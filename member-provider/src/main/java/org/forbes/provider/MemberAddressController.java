package org.forbes.provider;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IMemberAddressService;
import org.forbes.comm.constant.SaveValid;
import org.forbes.comm.constant.UpdateValid;
import org.forbes.comm.enums.AdressStausEnum;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
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
    @ApiOperation("查询所有地址信息")
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
    @ApiImplicitParam(value="status",name="用户状态",required=false)
    @ApiResponses(value = {
            @ApiResponse(code=500,message = Result.COMM_ACTION_ERROR_MSG),
            @ApiResponse(code=200,message = Result.COMM_ACTION_MSG)
    })
    public Result<MemberAddress> freezeOrThaw(@RequestParam(value="id",required=true) Long id,
                                        @RequestParam(value="isDefault",required=true)String isDefault){
        Result<MemberAddress> result=new Result<MemberAddress>();
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



}
