package com.kcss.rest.accesslog;

import com.kcss.biz.record.auth.ParamterCheckException;
import com.kcss.core.exception.ErrorConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by xwf on 18/2/23.
 */
@Aspect
@Component
public class ParamInfoAspect {
    private final Logger logger = LoggerFactory.getLogger(ParamInfoAspect.class);
    @Pointcut("execution(* com.kcss.rest..*Controller.*(..))")
    public void controller() { }
    @Resource
    private Environment env;

    @Before("controller()")
    public void controller(JoinPoint point) {
        String check = env.getProperty("method.param.checkNull","true");
        if("false".equals(check)) return;
        MethodSignature signature = (MethodSignature) point.getSignature();
        Long count = Stream.of(signature.getMethod().getDeclaredAnnotations())
                .filter(annotation -> annotation.annotationType() == RequestMapping.class)
                .count();
        String requestPath = count >= 1 ? signature.getMethod().getAnnotation(RequestMapping.class).value()[0] : "";

        String info = String.format("path:%s | %s", requestPath, getMethodInfo(point));
        logger.info(info);
    }

    private String getMethodInfo(JoinPoint point) {
        String className = point.getSignature().getDeclaringType().getSimpleName();
        String methodName = point.getSignature().getName();
        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        Annotation[][] methodAnnotations = method.getParameterAnnotations();
        Class<?>[] params = method.getParameterTypes();
        StringBuilder sb = null;
        if (Objects.nonNull(parameterNames)) {
            sb = new StringBuilder();
            for (int i = 0; i < parameterNames.length; i++) {
                Annotation[] temp = methodAnnotations[i];
//                logger.info("param type {},注解个数 {}",params[i],temp.length);
                for(Annotation annotation: temp) {
                    if(gennerRequired(annotation)) {
                        //是否是必传参数 判空
                        Object obj = point.getArgs()[i];

                        if(!isPrimite(params[i])) {
//                            logger.info("必要参数校验--- {} ,{},{}",parameterNames[i],obj,annotation.annotationType());
                            //基本类型不判空
                            if(null ==obj){
                                logger.error("客户端缺少必要参数: {} ", parameterNames[i]);
                                throw new ParamterCheckException(ErrorConstants.ERR_MISSING_PARAMETER);
                            }
                        }else{
//                            logger.info("基本类型参数--- {} ,{},{}",parameterNames[i],obj,annotation.annotationType());
                        }
                    }
                }
                String value = point.getArgs()[i] != null ? point.getArgs()[i].toString() : "null";
                sb.append(parameterNames[i] + ":" + value + "; ");
            }
        }
        sb = sb == null ? new StringBuilder() : sb;
        String info = String.format("class:%s | method:%s | args:%s", className, methodName, sb.toString());
        return info;
    }

    /**
     * 判断是否为基本类型
     * @param clazz clazz
     * @return  true：是;     false：不是
     */
    private boolean isPrimite(Class<?> clazz){
        if (clazz.isPrimitive()){
            return true;
        }else {
            return false;
        }
    }


    /**
     1. 对于RequestHeader 注解的 参数如果不传 报 ServletRequestBindingException   500
     2. 对于RequestPart 注解 参数不传 报 MissingServletRequestPartException      500
     3. 对于RequestMapping 注解 参数类型检测异常 报ServletRequestBindingException 500
     4. 对于RequestMapping 注解参数不传 报ParamterCheckException                 405
     */
    private boolean gennerRequired(Annotation annotation) {
        if(annotation instanceof RequestParam ) {
            RequestParam a = (RequestParam)annotation;
            return a.required();
        }else if(annotation instanceof RequestPart ){
            RequestPart a = (RequestPart)annotation;
            return a.required();
        }else if(annotation instanceof RequestHeader ){
            RequestHeader a = (RequestHeader)annotation;
            return a.required();
        }else if(annotation instanceof PathVariable ){
            PathVariable a = (PathVariable)annotation;
            return a.required();
        }else if(annotation instanceof RequestBody ){
            RequestBody a = (RequestBody)annotation;
            return a.required();
        }
        return false;
    }

}
