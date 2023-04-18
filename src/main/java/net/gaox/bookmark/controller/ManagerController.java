package net.gaox.bookmark.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import net.gaox.bookmark.model.api.ApiResponse;
import net.gaox.bookmark.model.dto.BookmarkDTO;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("获取书签内容")
    @GetMapping
    public ApiResponse get(@RequestParam(value = "v", required = false) Integer v) {
        return ApiResponse.success();
    }

    @ApiOperation("导入")
    @PostMapping
    public ApiResponse post(@RequestBody BookmarkDTO bookmark) {
        return ApiResponse.success();
    }

    @ApiOperation("更新")
    @PutMapping
    public ApiResponse put(@RequestBody BookmarkDTO bookmark) {
        return ApiResponse.success();
    }

    @ApiOperation("获取书签版本列表")
    @GetMapping("/list")
    public ApiResponse listVersion() {
        return ApiResponse.success();
    }

}
