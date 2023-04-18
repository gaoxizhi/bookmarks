package net.gaox.bookmark.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p> 书签目录表 </p>
 *
 * @author: gaox·Eric
 * @since 2018-11-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName("folder")
public class Folder extends Model<Folder> implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "目录名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "目录图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "书签类型: 0 url,1 folder")
    @TableField("type")
    private Boolean type;

    @ApiModelProperty(value = "层级")
    @TableField("level")
    private Integer level;

    @ApiModelProperty(value = "在目录中的顺序")
    @TableField("order_num")
    private Integer orderNum;

    @ApiModelProperty(value = "父级目录  父级目录0时是根目录")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "父级目录列表")
    @TableField("parent_ids")
    private String parentIds;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "上次修改时间")
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "禁用/启用 （0,1）")
    @TableField("state")
    private Integer state;

}
