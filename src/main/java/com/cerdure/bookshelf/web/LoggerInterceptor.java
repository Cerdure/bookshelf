package com.cerdure.bookshelf.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Slf4j
@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter {

    //controller로 보내기 전 이벤트 작동(false - controller로 요청을 안함)
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("============================== START ==============================");
        log.info(" Class       \t:  " + handler.getClass());
        log.info(" Request URI \t:  " + request.getRequestURI());
        log.info(" Servlet URI \t:  " + request.getServletPath());

        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String key = (String) paramNames.nextElement();
            String value = request.getParameter(key);
            log.info("# RequestParameter: " + key + "=" + value + "");
        }
        log.info("==================================================================== ");

        return super.preHandle(request, response, handler);
    }

    //controller 처리 이후 이벤트 작동
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //log.info("================================ END ================================");
    }

    //view 처리 이후 이벤트 작동
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("================================ END ================================");
    }
}