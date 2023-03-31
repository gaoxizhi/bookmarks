package site.gaox.bookmark.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.gaox.bookmark.entity.Bookmark;

import java.util.List;

/**
 * <p> BookmarkService Test </p>
 *
 * @author gaox·Eric
 * @date 2023-04-01 00:18
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookmarkServiceImplTest {

    @Autowired
    private BookmarkService bookmarkService;

    @Test
    public void find() {
        Bookmark bookmark = new Bookmark();
        String name = "书签2";
        bookmark.setName(name);
        List<Bookmark> bookmarks = bookmarkService.find(bookmark);
        log.info("get named = {}, list {}", name, bookmarks);
    }

    @Test
    public void getById() {
        Bookmark bookmark = bookmarkService.getById(1L);
        log.info("get {}", bookmark);
    }

}