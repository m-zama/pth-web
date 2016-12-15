package jp.co.stylez.pth.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ControllerLoggingAspectA {

//	@Before("execution(* jp.co.stylez.pth.web.controller.*.*(..))")
//	public void startLog(JoinPoint jp){
//		System.out.println("Aコントローラー開始："+ jp.getSignature());
//	}
//	
//	@AfterReturning("execution(* jp.co.stylez.pth.web.controller.*.*(..))")
//	public void endLog(JoinPoint jp){
//		System.out.println("Aコントローラー正常終了："+ jp.getSignature());
//	}
	
	
	@Around("execution(* jp.co.stylez.pth.web.controller.*.*(..))")
	public Object log(ProceedingJoinPoint jp)throws Throwable{
		System.out.println("コントローラー開始(Around)："+ jp.getSignature());
		try{
			Object result = jp.proceed();
			System.out.println("コントローラー正常終了(Around)：" + jp.getSignature() + "戻り値：" + result);
			return result;
		}catch(Exception e){
			System.out.println("コントローラー異常終了(Around):" + jp.getSignature());
			e.printStackTrace();
			throw e;
		}

	}

}
