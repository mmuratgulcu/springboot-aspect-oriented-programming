package com.gulcu.murat.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.gulcu.murat.entities.Person;

@Aspect
@Component
public class PersonServiceAspect {
	
	 /**
     * @param joinPoint -> O an ki durumu yakalar. Çağırılacak method kim, parametresi ne, dönüş tipi ne gibi tüm süreci
     *                  taşır. Biz bu joinpoint içinden istediğimizi alıp kullanacağız.
     *                  
     *com.gulcu.murat.service.impl.*.* -> Service paketinin altındaki bütün classların içindeki bütün
     *                  methodlardan önce devreye gir demek.
     *                  
     *(..) -> parametre alabilirde almayabilirde anlamına gelir.
     *
     *(*) -> İlk baştaki yıldız dönüş tipini belirtir. Public void vs...
     *(*) -> En sondaki yıldız parametre alan metodları belirtir.
     */
	
	//@Before("execution(public void com.gulcu.murat.api.*.*(..))")
	//@Before("execution(public * com.gulcu.murat.api.*.*(..))")
	//@Before("execution(public * com.gulcu.murat.api.*.*(*))")
	//@Before("execution(public * save(..))") -> Bütün projedeki public olan save methodlarını yakalar.
	//@Before("execution(* save(..))") -> Bütün projedeki save methodlarını yakalar.
	//@Before("within (ccom.gulcu.murat.api.*)") -> paketi altındaki classlardaki bütün methodları yakalar.

	@Pointcut("execution(* com.gulcu.murat.service.*.*(..))")
	public void pointCutTest() {
		
	}
	
	@Before("execution(* com.gulcu.murat.service.*.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Method öncesi çalışacak..");
	}
	
	@After("pointCutTest()")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("Method sonrası çalışacak..");
	}
	
	/**
	 * Return değerini yakalarız.
	 * @param joinPoint
	 * @param person
	 */
	@AfterReturning(pointcut = "execution(* com.gulcu.murat.service.*.*(..))",returning="person")
	public void afterReturningAdvice(JoinPoint joinPoint,ResponseEntity<Person> person) {
		System.out.println("Return edilen değer : " + person);
	}
	
	/**
	 * Hata'yı yakalarız.
	 * @param joinPoint
	 * @param exception
	 */
	@AfterThrowing(pointcut = "execution(* com.gulcu.murat.service.*.*(..))",throwing ="exception")
	public void afterThrowingAdvice(JoinPoint joinPoint,Exception exception) {
		System.out.println("Hata : " + exception.getMessage()+ "\n");
	}
	
	@Around(value="within (com.gulcu.murat.service.*)")
	public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Around başladı."+proceedingJoinPoint);
		proceedingJoinPoint.proceed();
		System.out.println("Around bitti."+proceedingJoinPoint);
	}
	
	@Around("@annotation(com.gulcu.murat.annotation.LogAnnotation)")
	public void specialAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Around başladı."+proceedingJoinPoint);
		proceedingJoinPoint.proceed();
		System.out.println("Around bitti."+proceedingJoinPoint);
	}
	
	
}
