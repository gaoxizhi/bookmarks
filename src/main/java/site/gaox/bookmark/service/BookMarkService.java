package site.gaox.bookmark.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.gaox.bookmark.entity.BookMark;

import java.util.List;

/**
 * <p>
 * 书签表 服务类
 * </p>
 *
 * @author gaox
 * @since 2018-11-28
 */
@Service
@Transactional
public interface BookMarkService extends IService<BookMark> {

    /**新增*/
    BookMark inster(BookMark bookMark);
    /**修改*/
    BookMark updata(BookMark bookMark);
    /**删除*/
    BookMark delOne(BookMark bookMark);
    /**查找根据id*/
    List<BookMark> find(BookMark bookMark);
}
