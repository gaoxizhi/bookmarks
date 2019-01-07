package site.gaox.bookmark.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 书签表
 * </p>
 *
 * @author gaox
 * @since 2018-11-28
 */
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BookMark implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 书签名
     */
    private String name;

    /**
     * 书签图标
     */
    private Blob img;

    /**
     * 在目录中的顺序
     */
    private Integer orderNum;

    /**
     * 父级目录  父级目录0时是根目录
     */
    private Integer parentId;

    public BookMark() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "BookMark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img=" + img +
                ", orderNum=" + orderNum +
                ", parentId=" + parentId +
                '}';
    }
}
