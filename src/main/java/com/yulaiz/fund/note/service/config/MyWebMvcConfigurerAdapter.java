package com.yulaiz.fund.note.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {
    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }

    //    //关键，将拦截器作为bean写入配置中
//    @Bean
//    public AuthInterceptor myAuthInterceptor() {
//        return new AuthInterceptor();
//    }

    /**
     * 自定义拦截器，并指定拦截路径
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
//        registry.addInterceptor(this.myAuthInterceptor())
//                //配置拦截的路径
//                .addPathPatterns("/**")
//                //配置不拦截的路径
//                .excludePathPatterns("**/swagger-ui.html");
        //还可以注册其它的拦截器

    }

    /**
     * 增加转化器或者格式化器
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //这边不仅可以把时间转化成你需要时区或者样式。
        //还可以自定义转化器和你数据库做交互，比如传进来userId，经过转化可以拿到user对象。
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(currentTokenMethodArgumentResolver());
//        resolvers.add(currentUserMethodArgumentResolver());
    }

//    @Bean
//    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
//        return new CurrentUserMethodArgumentResolver();
//    }
//
//    @Bean
//    public CurrentTokenMethodArgumentResolver currentTokenMethodArgumentResolver() {
//        return new CurrentTokenMethodArgumentResolver();
//    }
}
