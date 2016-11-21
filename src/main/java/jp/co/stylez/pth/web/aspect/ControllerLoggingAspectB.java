package jp.co.stylez.pth.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
//@Order(0)
public class ControllerLoggingAspectB {

	@Order(1)
	@Before("execution(* jp.co.stylez.pth.web.controller.*.*(..))")
	public void startLogA(JoinPoint jp){
		System.out.println("(startLogA)Bコントローラー開始："+ jp.getSignature());
	}
	
	@Order(0)
	@Before("execution(* jp.co.stylez.pth.web.controller.*.*(..))")
	public void startLogB(JoinPoint jp){
		System.out.println("(startLogB)Bコントローラー開始："+ jp.getSignature());
	}
	
	@Order(0)
	@AfterReturning("execution(* jp.co.stylez.pth.web.controller.*.*(..))")
	public void endLogA(JoinPoint jp){
		System.out.println("(endLogA)Bコントローラー正常終了："+ jp.getSignature());
	}
	
	@Order(1)
	@AfterReturning("execution(* jp.co.stylez.pth.web.controller.*.*(..))")
	public void endLogB(JoinPoint jp){
		System.out.println("(endLogB)Bコントローラー正常終了："+ jp.getSignature());
	}
}
