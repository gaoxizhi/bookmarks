package net.gaox.bookmark.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import net.gaox.bookmark.entity.Bookmark;

import java.util.Date;
import java.util.HashMap;

/**
 * <p>  </p>
 *
 * @author: gaox·Eric
 * @Date: 2018/11/24 18:35
 */
@RestController
public class Index {
    @GetMapping(value = "/")
    public JSONObject getInfo() {
        JSONObject js = new JSONObject();
        js.put("info", "hello ,have a good time!");
        return js;
    }

    @GetMapping(value = "date")
    public String get() {
        return new Date().toString();
    }

    //返回一个对象
    @GetMapping(value = "/bookmark")
    public Bookmark getB() {

        HashMap<String, Object> map = new HashMap<>(16);
        map.put("name", "gaox");
        map.put("orderNum", 1);
        map.put("parentId", 0);

        return null;
    }

}