package com.wjz;

import com.wjz.event.ApplicationStartingEventListener;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * 主程序
 * 类位置在必须com.wjz下，否则Bean扫描异常
 */
//@ImportResource({"classpathApplicationEventPublisher:spring-beans.xml"})
@EnableAdminServer
@SpringBootApplication
public class SpringBootJarApplication {
    public static void main(String[] args) {
//        SpringApplication.run(SpringBootJarApplication.class, args);
       /* SpringApplication app = new SpringApplication(SpringBootJarApplication.class);
        app.setBanner((e, c, o) -> o.println("BINGJJFLY") );
        app.run(args);*/
        new SpringApplicationBuilder(SpringBootJarApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .banner((e, c, o) -> o.println("BINGJJFLY"))
                .listeners(new ApplicationStartingEventListener())
//                .web(WebApplicationType.NONE)
                .addCommandLineProperties(false)
                .profiles("prev")
                .run(args);

        SpringApplication application = new SpringApplication(SpringBootJarApplication.class);
        application.setAdditionalProfiles("prev");
        application.run(args);
//        System.exit(SpringApplication.exit(SpringApplication.run(SpringBootJarApplication.class, args)));
    }

    @Bean
    public ExitCodeGenerator ecg() {
        return () -> 17;
    }

}
