package anno;

import java.lang.annotation.*;
import java.util.LinkedHashMap;

/**
 * @Author guojianfeng.
 * @Date Created in  2018/12/12
 * @Description：
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceAnno {
    String describe() default "";
    String note() default "";
}
