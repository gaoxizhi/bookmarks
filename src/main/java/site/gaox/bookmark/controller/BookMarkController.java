package site.gaox.bookmark.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.gaox.bookmark.entity.BookMark;
import site.gaox.bookmark.service.BookMarkService;

/**
 * <p>
 * 书签表 前端控制器
 * </p>
 *
 * @author gaox
 * @since 2018-11-28
 */
@RestController
@RequestMapping("/bookMark")
public class BookMarkController {
    @Autowired
    private BookMarkService bookMarkService;
    @GetMapping(value = "{id}")
    public BookMark getBookMark(Long id){
        return bookMarkService.getById(id);
    }

    //插入一条记录
    @PostMapping(value = "/add")
    public Boolean save(String name,Integer orderNum, Integer parentId){
        BookMark bookMark = new BookMark();
        bookMark.setName(name);
        bookMark.setParentId(parentId);
        bookMark.setOrderNum(orderNum);
        return bookMarkService.save(bookMark);
    }


}
