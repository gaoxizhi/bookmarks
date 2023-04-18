package net.gaox.bookmark.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p> 统一结果集封装 </p>
 *
 * @author gaox·Eric
 * @date 2023-04-18 23:05
 */
@Data
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Result<T> implements Serializable {
}
