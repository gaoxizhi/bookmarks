package net.gaox.bookmark.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * <p> 状态枚举 </p>
 *
 * @author gaox·Eric
 * @date 2023-04-18 20:37
 */

@Getter
@AllArgsConstructor
public enum StateEnum {

    DELETE(0, "删除"),
    NORMAL(1, "正常"),
    DISABLE(2, "禁用"),
    ;

    private final Integer code;
    private final String name;


    public static StateEnum getByName(Integer code) {

        Optional<StateEnum> first = Arrays.stream(StateEnum.values()).filter(s -> s.getCode().equals(code)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }
}
