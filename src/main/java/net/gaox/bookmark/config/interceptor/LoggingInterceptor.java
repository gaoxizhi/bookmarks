package net.gaox.bookmark.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import net.gaox.bookmark.config.InfoUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p> 日志拦截器 </p>
 *
 * @author gaox·Eric
 * @date 2023-04-19 01:16
 */
@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前
     * 登录检查写在这里，如果没有登录，就不执行目标方法
     *
     * @param request  请求
     * @param response 响应
     * @param handler  控制器
     * @return 通行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        log.info("session id = {}, URI = {}", sessionId, requestURI);
        InfoUtil.setSessionId(sessionId);

        return true;
    }

    /**
     * 目标方法执行完成以后
     *
     * @param request      请求
     * @param response     响应
     * @param handler      控制器
     * @param modelAndView modelAndView
     * @throws Exception ex
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        InfoUtil.remove();
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 页面渲染以后
     *
     * @param request  请求
     * @param response 响应
     * @param handler  控制器
     * @param ex       异常
     * @throws Exception exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}