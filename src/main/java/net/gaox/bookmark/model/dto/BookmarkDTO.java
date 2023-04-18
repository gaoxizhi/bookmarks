package net.gaox.bookmark.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import net.gaox.bookmark.model.BookmarkModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p> dto </p>
 *
 * @author gaox·Eric
 * @date 2023-04-18 23:38
 */

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class BookmarkDTO implements Serializable {

    @ApiModelProperty(value = "书签名")
    private String name;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "书签图标")
    private String icon;

    @ApiModelProperty(value = "书签类型: 0 url,1 folder")
    private Boolean type;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "在目录中的顺序")
    private Integer orderNum;

    @ApiModelProperty(value = "父级目录  父级目录0时是根目录")
    private Long parentId;

    @ApiModelProperty(value = "父级目录列表")
    private String parentIds;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "上次修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 子节点
     */
    private List<BookmarkModel> children;

}