package site.gaox.bookmark.entity;

//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import java.io.Serializable;

/**
 * <p>
 * 书签目录表
 * </p>
 *
 * @author gaox ·Eric 
 * @since 2018-11-24
 */
public class BookmarkDirectory implements Serializable {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 目录名
     */
         private String name;

        /**
     * 目录图标
     */
         private Blob img;

        /**
     * 在页面上的顺序
     */
         private Integer orderNum;

        /**
     * 父级目录  父级目录0时是根目录
     */
         private Integer parentId;


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
        return "BookmarkDirectory{" +
        "id=" + id +
        ", name=" + name +
        ", img=" + img +
        ", orderNum=" + orderNum +
        ", parentId=" + parentId +
        "}";
    }
}
