package net.gaox.bookmark.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import net.gaox.bookmark.entity.Bookmark;
import net.gaox.bookmark.service.BookmarkService;

/**
 * <p> 书签表 前端控制器 </p>
 *
 * @author: gaox·Eric
 * @since 2018-11-28
 */
@RestController
@RequestMapping("/bookmark")
@AllArgsConstructor
public class BookmarkController {

    private BookmarkService bookmarkService;

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Bookmark getBookmark(@PathVariable("id") Long id) {
        return bookmarkService.getById(id);
    }

    /**
     * 插入一条记录
     *
     * @param name     书签名
     * @param orderNum 排序
     * @param parentId 父目录
     * @return
     */

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public Bookmark save(String name, Integer orderNum, Long parentId) {
        Bookmark bookmark = new Bookmark();
        bookmark.setName(name);
        bookmark.setParentId(parentId);
        bookmark.setOrderNum(orderNum);

        bookmarkService.save(bookmark);
        bookmark = bookmarkService.getById(bookmark.getId());
        return bookmark;
    }


}
