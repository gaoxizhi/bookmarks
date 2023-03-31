package site.gaox.bookmark.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p> 书签目录表 </p>
 *
 * @author: gaox·Eric
 * @since 2018-11-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("folder")
public class Folder extends BaseEntity implements Serializable {

    /**
     * 目录名
     */
    private String name;

    /**
     * 目录图标
     */
    private String icon;

    /**
     * 在页面上的顺序
     */
    private Integer orderNum;

    /**
     * 父级目录  父级目录0时是根目录
     */
    private Integer parentId;

}
