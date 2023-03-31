package site.gaox.bookmark.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.gaox.bookmark.entity.Bookmark;

import java.util.List;

/**
 * <p> 书签表 服务类 </p>
 *
 * @author: gaox·Eric
 * @since 2018-11-28
 */
@Service
@Transactional
public interface BookmarkService extends IService<Bookmark> {

    /**新增*/
    Bookmark insert(Bookmark bookmark);
    /**修改*/
    Bookmark update(Bookmark bookmark);
    /**删除*/
    Bookmark delOne(Bookmark bookmark);
    /**查找根据id*/
    List<Bookmark> find(Bookmark bookmark);
}
