package net.gaox.bookmark.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import net.gaox.bookmark.entity.Bookmark;

/**
 * <p> BookmarkController Test </p>
 *
 * @author gaox·Eric
 * @date 2023-04-01 00:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookmarkControllerTest {

    /**
     * Mock 要注入的类
     */
    @Autowired
    private BookmarkController bookmarkController;

    @Test
    public void getBookmark() {
        Bookmark bookmark = bookmarkController.getBookmark(2L);
        System.out.println(bookmark);
    }
}