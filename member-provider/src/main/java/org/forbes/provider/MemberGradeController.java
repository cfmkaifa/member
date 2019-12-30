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
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.MemberDto;
import org.forbes.comm.model.MemberGradePageDto;
import org.forbes.comm.vo.MemberGradeVo;
import org.forbes.comm.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        log.debug("传入参数为:" + JSON.toJSONString(result.getResult()));
        return result;
    }



    /***
     * addMemberType方法概述:
     * @param  memberGradeDto
     * @return MemberGradeVo
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/27
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/add-Member-grade", method = RequestMethod.POST)
    @ApiOperation("获取分页会员等级列表")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.MEMBER_GRADE_ERROR_MSG),
            @ApiResponse(code = 200, message = Result.MEMBER_GRADE_MSG)
    })
    public Result<IPage<MemberGradeVo>> add(MemberGradeDto memberGradeDto){
        log.debug("传入参数为:" + JSON.toJSONString(pageDto));
        Result<IPage<MemberGradeVo>> result = new Result<>();
        IPage<MemberGradeVo> page = new Page<MemberGradeVo>(basePageDto.getPageNo(),basePageDto.getPageSize());
        memberGradeService.memberGradePage(page,pageDto);
        log.debug("传入参数为:" + JSON.toJSONString(result.getResult()));
        return result;
    }



}
