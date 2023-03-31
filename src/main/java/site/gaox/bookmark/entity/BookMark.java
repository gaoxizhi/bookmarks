package site.gaox.bookmark.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p> 书签表 </p>
 *
 * @author: gaox·Eric
 * @since 2018-11-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("book_mark")
public class Bookmark extends BaseEntity implements Serializable {

    /**
     * 书签名
     */
    private String name;

    /**
     * 书签图标
     */
    private String icon;

    /**
     * 在目录中的顺序
     */
    private Integer orderNum;

    /**
     * 父级目录  父级目录0时是根目录
     */
    private Integer parentId;

}
