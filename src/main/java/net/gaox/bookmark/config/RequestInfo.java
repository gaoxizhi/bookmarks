package net.gaox.bookmark.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p> 请求信息 </p>
 *
 * @author gaox·Eric
 * @date 2023-04-19 01:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class RequestInfo {

    /**
     * session id
     */
    private String sessionId;

}
