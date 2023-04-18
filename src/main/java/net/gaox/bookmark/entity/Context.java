package net.gaox.bookmark.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p> 内容表 </p>
 *
 * @author gaox·Eric
 * @since 2023-04-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Context对象", description = "内容表")
public class Context extends Model<Context> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "session id")
    @TableField("session")
    private String session;

    @ApiModelProperty(value = "版本号")
    @TableField("version")
    private Integer version;

    @ApiModelProperty(value = "内容")
    @TableField("context")
    private String context;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
