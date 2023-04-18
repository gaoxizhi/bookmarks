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

    private Integer code;
    private T data;
    private Boolean success;

    public Result() {
        this.success = true;
        this.code = 0;
    }

    public Result(T data) {
        this.success = true;
        this.code = 0;
        this.data = data;
    }

    public static Result success() {
        Result result = new Result<>()
                .setSuccess(true)
                .setCode(0);
        return result;
    }

    public static Result fail() {
        Result result = new Result<>()
                .setSuccess(false)
                .setCode(1);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result<>()
                .setSuccess(true)
                .setCode(0)
                .setData(data);
        return result;
    }
}
