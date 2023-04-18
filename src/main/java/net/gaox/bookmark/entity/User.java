package net.gaox.bookmark.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User {

    /**
     * 我们不想返回name? serialize:是否需要序列化属性.
     */
    @JSONField(serialize = false)
    private Long id;
    //com.alibaba.fastjson.annotation.JSONField
    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date bDate;

    private String name;

}
