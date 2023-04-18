package net.gaox.bookmark.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * <p> 书签类型 </p>
 *
 * @author gaox·Eric
 * @date 2023-04-18 19:30
 */

@Getter
@AllArgsConstructor
public enum TypeEnum {

    URL(0, "url"),
    FOLDER(1, "folder"),
    ;

    private final Integer code;
    private final String name;


    public static TypeEnum getByName(Integer code) {

        Optional<TypeEnum> first = Arrays.stream(TypeEnum.values()).filter(s -> s.getCode().equals(code)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

}
