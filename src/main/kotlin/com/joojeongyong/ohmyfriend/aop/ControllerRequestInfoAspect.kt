package com.joojeongyong.ohmyfriend.aop

import com.joojeongyong.ohmyfriend.common.Log
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class ControllerRequestInfoAspect {
    companion object : Log()

    @Before(value = "execution(* com.joojeongyong.ohmyfriend.api.*.*(..))")
    fun infoLog(joinPoint: JoinPoint) {
        log.info("[RequestLog] method : {}, args : {}", joinPoint.toShortString(), joinPoint.args)
    }
}