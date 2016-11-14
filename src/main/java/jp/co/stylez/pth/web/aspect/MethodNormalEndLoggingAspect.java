package jp.co.stylez.pth.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodNormalEndLoggingAspect {

	@AfterReturning("execution(* *..*ServiceImpl.*(..))")
	public void endLog(JoinPoint jp){
		System.out.println("メソッド正常終了："+ jp.getSignature());
	}
}
