package jp.co.stylez.pth.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class MethodLoggingAspect {

	@Around("execution(* *..*ServiceImpl.*(..))")
	public Object log(ProceedingJoinPoint jp)throws Throwable{
		System.out.println("メソッド開始(Around)："+ jp.getSignature());
		try{
			Object result = jp.proceed();
			System.out.println("メソッド正常終了(Around)：" + jp.getSignature() + "戻り値：" + result);
			return result;
		}catch(Exception e){
			System.out.println("メソッド異常終了(Around):" + jp.getSignature());
			e.printStackTrace();
			throw e;
		}

	}
}
