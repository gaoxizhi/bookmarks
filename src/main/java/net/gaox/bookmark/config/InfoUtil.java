package net.gaox.bookmark.config;

import java.util.Objects;
import java.util.Optional;

/**
 * <p> info 工具类 </p>
 *
 * @author gaox·Eric
 * @date 2023-04-19 01:31
 */
public class InfoUtil {

    private static final ThreadLocal<RequestInfo> info = new ThreadLocal<>();

    public static void set(RequestInfo i) {
        info.set(i);
    }

    public static void remove() {
        info.remove();
    }

    public static void setSessionId(String sessionId) {
        RequestInfo i = Optional.ofNullable(info)
                .filter(Objects::nonNull).map(ThreadLocal::get)
                .orElse(new RequestInfo());

        i.setSessionId(sessionId);
        set(i);
    }

    public static String getSessionId() {
        return info.get().getSessionId();
    }

}
