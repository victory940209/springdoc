package com.victory.aop;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableAspectJAutoProxy
@Aspect
@Component
public class LogAspect {


	@Around("execution(* com.victory..*Controller.*(..))")
	public Object LogBefore(ProceedingJoinPoint joinpoint)throws Throwable{

		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		Object proceed = joinpoint.proceed();
		Enumeration eheader = request.getHeaderNames();
//		while(eheader.hasMoreElements()) {
//			String nm = (String) eheader.nextElement();
//			log.info("==== headernm : " + nm + "  value : " + request.getHeader(nm));
//		}
//		log.info("==== TraceId : " + request.getHeader("X-B3-TraceId"));
//		log.info("==== IP Address : {}", request.getRemoteAddr());
//		log.info("==== host : {}", request.getHeader("host"));
//		log.info("==== connection {}: ", request.getHeader("connection"));
//		log.info("==== referer : {}", request.getHeader("referer"));
//		log.info("==== cookie: : {}", request.getHeader("cookie"));
//		log.info("==== sessionId : {}", session.getId());
//        log.info("==== reqParam : {}", joinpoint.getArgs()[0]);
//        log.debug("==== resParam : {}", proceed);

        Map<String, Object> resMap = new HashMap<String, Object>();

        if(proceed instanceof Map) {
        	ObjectMapper mapper = new ObjectMapper();	//
        	resMap.put("resultValue", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(proceed));
        }else {
        	resMap.put("resultValue", proceed);
        }

        return proceed;
	}
}
