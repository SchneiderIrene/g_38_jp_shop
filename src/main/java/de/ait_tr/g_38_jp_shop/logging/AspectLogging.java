package de.ait_tr.g_38_jp_shop.logging;

import de.ait_tr.g_38_jp_shop.domain.dto.ProductDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Aspect
@Component
public class AspectLogging {

    private Logger logger = LoggerFactory.getLogger(AspectLogging.class);

    @Pointcut("execution(* de.ait_tr.g_38_jp_shop.service.ProductServiceImpl.save(..))")
    public void saveProduct() {}

    @Before("saveProduct()")
    public void beforeSavingProduct(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        logger.info("Method save of the class ProductServiceImpl was called with parameter {}", args[0]);
    }

    @After("saveProduct()")
    public void afterSavingProduct() {
        logger.info("Method save of the class ProductServiceImpl finished its work");
    }

    @Pointcut("execution(* de.ait_tr.g_38_jp_shop.service.ProductServiceImpl.getById(..))")
    public void getProductById() {}

    @AfterReturning(pointcut = "getProductById()", returning = "result")
    public void afterReturningProductById(Object result) {
        logger.info("Method getById of the class ProductServiceImpl successfully returned result: {}", result);
    }

    @AfterThrowing(pointcut = "getProductById()", throwing = "e")
    public void afterThrowingAnExceptionWhileGettingProductById(Exception e) {
        logger.info("Method getById of the class ProductServiceImpl threw an exception: {}", e.getMessage());
    }

    @Pointcut("execution(* de.ait_tr.g_38_jp_shop.service.ProductServiceImpl.getAll(..))")
    public void getAllProducts() {}

    @Around("getAllProducts()")
    public Object aroundGettingAllProducts(ProceedingJoinPoint joinPoint) {
        logger.info("Method getAll of the class ProductServiceImpl called");

        List<ProductDto> result = null;

        try {
            result = ((List<ProductDto>) joinPoint.proceed())
                    .stream()
                    .filter(x -> x.getPrice().compareTo(new BigDecimal(100)) > 0)
                    .toList();
        } catch (Throwable e) {
            logger.error("Method getAll of the class ProductServiceImpl threw an exception: {}", e.getMessage());
        }

        logger.info("Method getAll of the class ProductServiceImpl finished its work");
        return result;
    }

    // 1. Создать поинткат, который относится не к одному методу, а ко всем методам определенного класса.
    // 2. Создать поинткат, который относится не к одному методу или классу, а ко всем классам определенного пакета.
}