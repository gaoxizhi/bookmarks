package net.gaox.bookmark.model.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApiError {
    /**
     * 异常代码
     */
    Integer code;
    /**
     * 异常信息
     */
    private String msg;
}