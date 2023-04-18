package net.gaox.bookmark.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import net.gaox.bookmark.model.api.Result;
import net.gaox.bookmark.model.dto.ContextDTO;
import net.gaox.bookmark.model.vo.ContextVO;
import net.gaox.bookmark.service.ContextService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p> 书签管理 </p>
 *
 * @author gaox·Eric
 * @date 2023-04-18 20:52
 */

@Api("bookmark")
@RestController
@RequestMapping("/b")
@AllArgsConstructor
public class ManagerController {

    private ContextService contextService;

    @ApiOperation("获取书签内容")
    @GetMapping
    public Result<ContextVO> get(@RequestParam(value = "v", required = false) Integer v) {
        ContextVO context = contextService.get(v);
        if (null != context) {
            return Result.success(context);
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("导入")
    @PostMapping
    public Result<Long> post(@RequestBody ContextDTO context) {
        Integer version = contextService.saveOne(context);
        if (null != version) {
            return Result.success(version);
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("更新")
    @PutMapping
    public Result<Long> put(@RequestBody ContextDTO context) {
        Integer version = contextService.updateOne(context);
        if (null != version) {
            return Result.success(version);
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("获取书签版本列表")
    @GetMapping("/list")
    public Result listVersion() {
        List<Integer> versions = contextService.listVersion();
        return Result.success(versions);
    }

}
