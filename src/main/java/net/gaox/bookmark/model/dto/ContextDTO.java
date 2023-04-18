package net.gaox.bookmark.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * <p> 内容 DTO </p>
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
public class ContextDTO {

    @ApiModelProperty(value = "内容")
    private String context;

}
