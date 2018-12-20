package biz;

import anno.ResourceAnno;

/**
 * @Author guojianfeng.
 * @Date Created in  2018/12/12
 * @Description：
 */
public class UserBiz {

    @ResourceAnno(describe="获取用户",note = "测试")
    public void getUser(String arg){
        System.out.println(String.format("%s方法 参数是 %s 执行了。。。","getUser()",arg));
    }
}
