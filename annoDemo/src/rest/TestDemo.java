package rest;

import anno.ResourceAnno;
import biz.UserBiz;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @Author guojianfeng.
 * @Date Created in  2018/12/12
 * @Description：
 */
public class TestDemo {

  @Test
  public void testAnno()throws Exception{
    Class<UserBiz> userBizClass = UserBiz.class;
    Method getUser = userBizClass.getMethod("getUser", String.class);
    getUser.invoke(userBizClass.newInstance(),"hahah");
    ResourceAnno annotation = getUser.getAnnotation(ResourceAnno.class);
    System.out.println(String.format("ResourceAnno：describe {%s}  note {%s}",annotation.describe(),annotation.note()));
  }
}
