package cc.conyli.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    //没有使用多配置文件，这里不需要修改
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    //这是获取具体Servlet配置的方法，需要将刚才编写的配置类放进去
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                DemoAppConfig.class
        };
    }

    @Override
    //这是上边的servlet的映射，也是一个数组，与上边一对一
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }

}
