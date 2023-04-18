package net.gaox.bookmark.model.api;

import com.alibaba.fastjson.JSON;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> response包装类 </p>
 *
 * @author gaox·Eric
 * @date 2019/5/4 00:27
 */
public class ApiResponse extends HashMap<String, Object> {


    private static final long serialVersionUID = 774692171307304899L;

    /**
     * 成功消息封装
     *
     * @return
     */
    public static ApiResponse success() {
        ApiResponse apiResult = new ApiResponse();
        apiResult.put("success", true);
        return apiResult;
    }

    /**
     * 错误消息封装
     *
     * @return
     */
    public static ApiResponse fail() {
        ApiResponse apiResult = new ApiResponse();
        apiResult.put("success", false);
        return apiResult;
    }

    /**
     * 添加消息体
     *
     * @param key
     * @param object
     * @return
     */
    public ApiResponse and(String key, Object object) {
        this.put(key, object);
        return this;
    }

    /**
     * 异常信息放入
     *
     * @param msg
     * @return
     */
    public ApiResponse error(String msg) {
        this.put("msg", msg);
        return this;
    }

    /**
     * 异常信息，包含异常码及异常信息
     *
     * @param error
     * @return
     */
    public ApiResponse error(ApiError error) {
        this.put("msg", error.getMsg());
        this.put("code", error.getCode());
        return this;
    }

    /**
     * tostring方法
     *
     * @return
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    /**
     * 放入一个包含data属性的内容
     *
     * @param data
     * @return
     */
    public ApiResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    /**
     * 封装response的response
     *
     * @param data
     * @return
     */
    @SuppressWarnings("unchecked")
    public ApiResponse putData(Map<String, Object> data) {
        if (this.containsKey("data")) {
            Map<String, Object> object = (Map<String, Object>) this.get("data");
            object.putAll(data);
        } else {
            this.put("data", data);
        }
        return this;
    }

    /**
     * 封装集合类型消息
     * 会覆盖之前相同项消息
     *
     * @param map
     * @return
     */
    public ApiResponse and(Map<String, Object> map) {
        for (Entry<String, Object> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    /**
     * 消息模型
     *
     * @param obj
     * @param clazz
     * @return
     */
    public ApiResponse andModel(Object obj, Class<?> clazz) {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(clazz);
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
        PropertyDescriptor[] ps = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor p : ps) {
            if ("class".equals(p.getName())) {
                continue;
            }
            Method method = p.getReadMethod();
            try {
                Object value = method.invoke(obj);
                this.put(p.getName(), value);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }
}