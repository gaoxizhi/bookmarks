package site.gaox.bookmark.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.gaox.bookmark.entity.BookMark;
import site.gaox.bookmark.entity.user;

import java.util.Date;
import java.util.HashMap;

/**
 * @Description: <p>  </p>
 * @Auther: gaox·Eric
 * @Date: 2018/11/24 18:35
 */
@RestController
public class index {
    @GetMapping(value = "/")
    public JSONObject getInfo(){
        JSONObject js = new JSONObject();
        js.put("info","hello ,have a good time!");
        return js;
    }

    @GetMapping(value = "date")
    public String get(){
        return new Date().toString();
    }
    
    //返回一个对象
    @GetMapping(value = "/bookmark")
    public BookMark getB() {

        HashMap<String, Object> map = new HashMap<>(16);
        map.put("name","gaox");
        map.put("orderNum",1);
        map.put("parentId",0);

    	return null;
    }
    
    //返回一个对象
    @GetMapping(value = "/user")
    public user us() {
    	user use =new user();
    	use.setId(9725);
    	use.setbDate(new Date());
    	use.setName("小花花");
    	return use;
    }

}