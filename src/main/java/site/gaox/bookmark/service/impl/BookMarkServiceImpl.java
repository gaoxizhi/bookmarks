package site.gaox.bookmark.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.gaox.bookmark.entity.Bookmark;
import site.gaox.bookmark.mapper.BookmarkMapper;
import site.gaox.bookmark.service.BookmarkService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p> 书签表 服务实现类 </p>
 *
 * @author: gaox·Eric
 * @since 2018-11-28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BookmarkServiceImpl extends ServiceImpl<BookmarkMapper, Bookmark> implements BookmarkService {

    @Resource
    private BookmarkMapper bookmarkMapper;

    @Override
    public Bookmark insert(Bookmark bookmark) {
        save(bookmark);
        return bookmark;
    }

    @Override
    public Bookmark update(Bookmark bookmark) {
        bookmarkMapper.updateById(bookmark);
        return bookmark;
    }

    @Override
    public Bookmark delOne(Bookmark bookmark) {
        QueryWrapper<Bookmark> wrapper = new QueryWrapper<Bookmark>();
        wrapper.eq("id", bookmark.getId());
        Bookmark bookmark1 = getById(bookmark.getId());
        remove(wrapper);
        return bookmark1;
    }

    @Override
    public List<Bookmark> find(Bookmark bookmark) {

        QueryWrapper<Bookmark> wrapper = new QueryWrapper<>();
        wrapper.eq("name", bookmark.getName());
        List<Bookmark> list = list(wrapper);
        return list;
    }

}
