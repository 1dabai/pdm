package com.szpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan("com.szpx.mapper")
public class DemoApplication extends SpringBootServletInitializer {

    /*
     * TODO 此方法的用途:
     *
     * 使用外置tomcat部署
     * configure
     *
     * @return org.springframework.boot.builder.SpringApplicationBuilder
     * @author
     * @since 2023/4/4 23:46
     * 从Idea提交至仓库时，偶尔提交不成功，连续几次都提交不成功的话，可以在Settings中将绑定的Gitee账户删除，重新绑定即可
     * 根据.gitignore文件的过滤要求，不上传非自己编译的文件
     *
     * git rm -r --cached .idea 清理多余的不上传的项目配置文件
     * https://gitee.com/lijiang_lishihui/demo.git
     *
     *
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(DemoApplication.class);
    }

    /**
     * 灰灰老师测试
     */


    /*
     * TODO 此方法的用途:
     *
     * 程序启动主入口--请勿修改
     *
     * 访问地址为：127.0.0.1:8086
     *
     * @return
     * @author
     * @since 2023/3/22 0:11

        2024年3月20日，测试提交--灰灰老师

     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
