package site.gaox.bookmark.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.gaox.bookmark.entity.BookMark;
import site.gaox.bookmark.mapper.BookMarkMapper;
import site.gaox.bookmark.service.BookMarkService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 书签表 服务实现类
 * </p>
 *
 * @author gaox
 * @since 2018-11-28
 */
@Service
@Transactional
public class BookMarkServiceImpl extends ServiceImpl<BookMarkMapper, BookMark> implements BookMarkService {
@Autowired
private BookMarkMapper bookMarkMapper;
    @Override
    public BookMark inster(BookMark bookMark) {
        save(bookMark);
        return bookMark;
    }

    @Override
    public BookMark updata(BookMark bookMark) {
        saveOrUpdate(bookMark);
        return bookMark;
    }

    @Override
    public BookMark delOne(BookMark bookMark) {
        QueryWrapper<BookMark> wrapper = new QueryWrapper<BookMark>();
        wrapper.eq("id",bookMark.getId());
        BookMark bookMark1 = getById(bookMark.getId());
        remove(wrapper);
        return bookMark1;
    }

    @Override
    public List<BookMark> find(BookMark bookMark) {

        QueryWrapper<BookMark> wrapper = new QueryWrapper<BookMark>();
        wrapper.eq("name",bookMark.getName());
        List<Object> list = listObjs(wrapper);

        List<BookMark> bookMarks = new ArrayList<BookMark>();
        Iterator it = list.iterator();
        while (it.hasNext()){
            bookMarks.add((BookMark) it.next());
        }
        return bookMarks;

    }
}
