package net.gaox.bookmark.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.gaox.bookmark.entity.Bookmark;

import java.util.List;

/**
 * <p> 书签表 服务类 </p>
 *
 * @author: gaox·Eric
 * @since 2018-11-28
 */
public interface BookmarkService extends IService<Bookmark> {

    /**
     * 新增
     *
     * @param bookmark bookmark
     * @return bookmark
     */
    Bookmark insert(Bookmark bookmark);

    /**
     * 修改
     *
     * @param bookmark bookmark
     * @return bookmark
     */
    Bookmark update(Bookmark bookmark);

    /**
     * 删除
     *
     * @param bookmark bookmark
     * @return bookmark
     */
    Bookmark delOne(Bookmark bookmark);

    /**
     * 查找根据 name
     *
     * @param bookmark bookmark
     * @return bookmarks
     */
    List<Bookmark> find(Bookmark bookmark);
}
