1、创建一个maven的jar项目
2、添加依赖
    <parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.7.RELEASE</version>
	</parent>
	<dependencies>
    	<dependency>
    		<groupId>org.springframework.boot</groupId>
    		<artifactId>spring-boot-starter-web</artifactId>
    	</dependency>
    </dependencies>
3、部署
    添加maven插件
        <build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                </plugin>
            </plugins>
        </build>
    mvn package命令打包
    java -jar spring-boot-jar-1.0.jar命令运行
4、父依赖
   spring-boot-jar -> spring-boot-starter-parent -> spring-boot-dependencies
   覆盖父依赖：
        <properties>
            <jackson.version>2.9.8</jackson.version>
        </properties>
   启动器（spring-boot-starter）
        官网描述：https://docs.spring.io/spring-boot/docs/2.1.7.RELEASE/reference/html/using-boot-build-systems.html
        启动器包含许多依赖项是一组方便的依赖关系描述符
5、注解
    @SpringBootApplication内部修饰
        @Inherited
        @SpringBootConfiguration
        @EnableAutoConfiguration
        @ComponentScan(
            excludeFilters = {@Filter(
            type = FilterType.CUSTOM,
            classes = {TypeExcludeFilter.class}
        ), @Filter(
            type = FilterType.CUSTOM,
            classes = {AutoConfigurationExcludeFilter.class}
        )}
        )

    @SpringBootConfiguration内部修饰（SpringBoot配置注解）
        @Configuration：Spring注解，修饰配置类完成配置

    @EnableAutoConfiguration内部修饰（SpringBoot自动启动配置注解）
        @Inherited
        @AutoConfigurationPackage
        @Import({AutoConfigurationImportSelector.class})

    @AutoConfigurationPackage内部修饰（自动配置包注解）
        @Import(AutoConfigurationPackages.Registrar)：Spring注解，给容器导入一个组件

    AutoConfigurationPackages.Registrar：将主配置类所在的包及下面所有子包的组件扫描到容器内

    AutoConfigurationImportSelector：自动导入组件选择器
        将所有需要导入的组件以全类名的方式返回，以类加载器机制加载到容器中（给容器中导入诸多***AutoConfiguration的组件，XML配置转为注解配置）
        配置文件中配置的：autoconfigure包下的/META-INF/spring.factories文件
        如WebMvcAutoConfiguration：
            配置视图解析器
            @Bean
            @ConditionalOnMissingBean
            public InternalResourceViewResolver defaultViewResolver() {
                InternalResourceViewResolver resolver = new InternalResourceViewResolver();
                resolver.setPrefix(this.mvcProperties.getView().getPrefix());
                resolver.setSuffix(this.mvcProperties.getView().getSuffix());
                return resolver;
            }

6、Spring Initializer快速创建项目
    * 主程序已经创建好
    * resources目录结构已经创建好
        static
        templates（SpringBoot使用嵌入式的Tomcat，默认不支持JSP，可以使用Freemarker、Thymeleaf）
        application.properties（SpringBoot配置文件，可以修改默认配置如Tomcat端口号）

7、配置文件
    SpringBoot支持的全局配置文件（文件名是固定的）
        application.properties
        application.yml/application.yaml
    YAML标记语言：以数据为中心，比Json、XML更适合做配置文件
        server:
          port:8082
    XML形式：
        <server>
            <port>8082</port>
        </server>



