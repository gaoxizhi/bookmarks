package net.gaox.bookmark.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import net.gaox.bookmark.entity.Context;

/**
 * <p> 内容 VO </p>
 *
 * @author gaox·Eric
 * @date 2023-04-19 02:11
 */

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class ContextVO {

    @ApiModelProperty(value = "版本号")
    private Integer version;

    @ApiModelProperty(value = "内容")
    private String context;

    /**
     * 从 context 转 vo
     *
     * @param context context
     * @return vo
     */
    public static ContextVO from(Context context) {
        if (null == context) {
            return null;
        }
        ContextVO vo = new ContextVO(context.getVersion(), context.getContext());
        return vo;
    }
}
