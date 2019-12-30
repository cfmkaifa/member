package org.forbes.provider;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IMemberGradeService;
import org.forbes.comm.constant.CommonConstant;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.exception.ForbesException;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.MemberDto;
import org.forbes.comm.model.MemberGradeDto;
import org.forbes.comm.model.MemberGradePageDto;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.utils.UUIDGenerator;
import org.forbes.comm.vo.MemberGradeVo;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.MemberGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/member-grade")
@Api(tags={"会员等级"})
@Slf4j
public class MemberGradeController {


    @Autowired
    IMemberGradeService memberGradeService;

    /***
     * page方法概述:
     * @param  pageDto
     * @return MemberGradeVo
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/27
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation("获取分页会员等级列表")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.MEMBER_GRADE_ERROR_MSG),
            @ApiResponse(code = 200, message = Result.MEMBER_GRADE_MSG)
    })
    public Result<IPage<MemberGradeVo>> page(BasePageDto basePageDto, MemberGradePageDto pageDto){
        log.debug("传入参数为:" + JSON.toJSONString(pageDto));
        Result<IPage<MemberGradeVo>> result = new Result<>();
        IPage<MemberGradeVo> page = new Page<MemberGradeVo>(basePageDto.getPageNo(),basePageDto.getPageSize());
        memberGradeService.memberGradePage(page,pageDto);
        log.debug("返回参数为:" + JSON.toJSONString(result.getResult()));
        return result;
    }



    /***
     * addMemberGrade方法概述:增加会员等级
     * @param  memberGradeDto
     * @return MemberGradeVo
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/27
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("增加会员等级")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.ADD_MEMBER_GRADE_ERROR_MSG),
            @ApiResponse(code = 200, message = Result.ADD_MEMBER_GRADE_MSG)
    })
    public Result<MemberGrade> addMemberGrade(@RequestBody MemberGradeDto memberGradeDto){
        log.debug("传入参数为:" + JSON.toJSONString(memberGradeDto));
        Result<MemberGrade> result = new Result<>();
        if(ConvertUtils.isEmpty(memberGradeDto)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        MemberGrade memberGrade = new MemberGrade();
        memberGrade.setGrade(memberGradeDto.getGrade());
        memberGrade.setGradeName(memberGradeDto.getGradeName());
        memberGrade.setConsumptionAmount(memberGradeDto.getConsumptionAmount());
        memberGrade.setIsDefault(memberGradeDto.getIsDefault());
        memberGrade.setCode(UUIDGenerator.generateString(8));
        memberGradeService.save(memberGrade);

        result.setResult(memberGrade);
        log.debug("返回参数为:" + JSON.toJSONString(result.getResult()));
        return result;
    }


    /***
     * addMemberGrade方法概述:修改会员等级
     * @param  memberGradeDto
     * @return MemberGradeVo
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/27
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    @ApiOperation("修改会员等级")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.UPDATE_MEMBER_GRADE_ERROR_MSG),
            @ApiResponse(code = 200, message = Result.UPDATE_MEMBER_GRADE_MSG)
    })
    public Result<MemberGrade> updateMemberGrade(@RequestBody MemberGradeDto memberGradeDto){
        log.debug("传入参数为:" + JSON.toJSONString(memberGradeDto));
        Result<MemberGrade> result = new Result<>();
        if(ConvertUtils.isEmpty(memberGradeDto)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        if(ConvertUtils.isEmpty(memberGradeDto.getId())){
            result.setBizCode(BizResultEnum.EMPTY.getBizCode());
            result.setMessage(BizResultEnum.EMPTY.getBizMessage());
            return result;
        }
        MemberGrade memberGrade = new MemberGrade();
        memberGrade.setId(memberGradeDto.getId());
        memberGrade.setGrade(memberGradeDto.getGrade());
        memberGrade.setGradeName(memberGradeDto.getGradeName());
        memberGrade.setConsumptionAmount(memberGradeDto.getConsumptionAmount());
        memberGrade.setIsDefault(memberGradeDto.getIsDefault());
        memberGradeService.updateById(memberGrade);

        result.setResult(memberGrade);
        log.debug("返回参数为:" + JSON.toJSONString(result.getResult()));
        return result;
    }


    /***
     * deleteMemberGrade方法概述:删除会员等级
     * @param  id
     * @return MemberGradeVo
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/27
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation("删除会员等级")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.UPDATE_MEMBER_GRADE_ERROR_MSG),
            @ApiResponse(code = 200, message = Result.UPDATE_MEMBER_GRADE_MSG)
    })
    public Result<MemberGradeVo> deleteMemberGrade(@PathVariable String id){
        log.debug("传入参数为:" + JSON.toJSONString(id));
        Result<MemberGradeVo> result = new Result<>();
        if(ConvertUtils.isEmpty(id)){
            result.setBizCode(BizResultEnum.EMPTY.getBizCode());
            result.setMessage(BizResultEnum.EMPTY.getBizMessage());
            return result;
        }
        memberGradeService.removeById(id);
        return result;
    }

    /***
     * deleteMemberGrade方法概述:批量删除会员等级
     * @param  ids
     * @return MemberGradeVo
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/27
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/delete-batch", method = RequestMethod.DELETE)
    @ApiOperation("批量删除会员等级")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.UPDATE_MEMBER_GRADE_ERROR_MSG),
            @ApiResponse(code = 200, message = Result.UPDATE_MEMBER_GRADE_MSG)
    })
    public Result<MemberGradeVo> deleteBatch(@RequestParam("ids") String ids){
        log.debug("传入参数为:" + JSON.toJSONString(ids));
        Result<MemberGradeVo> result = new Result<>();
        try {
            memberGradeService.removeByIds(Arrays.asList(ids.split(CommonConstant.SEPARATOR)));
        } catch (ForbesException e) {
           result.setBizCode( e.getErrorCode());
           result.setMessage( e.getErrorMsg());
        }
        return result;
    }

}
