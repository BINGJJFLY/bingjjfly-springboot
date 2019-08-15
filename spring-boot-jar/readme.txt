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
            port: 8082
    XML形式：
        <server>
            <port>8082</port>
        </server>

    YAML
        基本语法
            * k: v  表示一个键值对(空格必须有)以空格缩进表示层级关系（不允许使用tab键），相同层级元素左对齐
                server:
                    port: 8082
                    path: /hello
            * 属性值大小写敏感
        三种数据结构
            字面量（字符串、数字、布尔）
                形式如 k: v，可以直接写
                双引号 k: "v"，特殊字符转义，如 "\n" 会换行
                单引号 k: 'v'， 特殊字符不转义，如 '\n' 不会换行
            对象、Map（属性和值、键值对）
                一般写法：
                    user:
                        name: iss002
                        age: 18
                行内写法：
                    user: { name: iss002, age: 18 }
            数组（List、Set）
                一般写法：
                    pets:
                      - cat: { name: cat }
                      - dog: { name: dog }
                      - pig: { name: pig }
                行内写法：
                    pets: [ cat: { name: cat }, dog: { name: dog }, pig: { name: pig } ]

8、配置文件映射为Bean
   YAML方式：
        person:
          last-name: iss002
          age: 18
          man: true
          birthday: 2019/08/11
          dog:
            name: dog
            age: 7
          kvs: { id: 1, name: wjz }
          items:
            - spring
            - boot
   Properties方式：
        person.last-name=金饼
        person.age=18
        person.man=false
        person.birthday=2019/08/11
        person.dog.name=dog
        person.dog.age=7
        person.kvs.id=1
        person.kvs.name=wjz
        person.items=spring, boot

9、@ConfigurationProperties和@Value的区别
    功能                  批量映射                    逐一映射
    松散绑定                支持                       不支持
    SpEL                   不支持                      支持
    JSP303数据校验          支持                       不支持
    复杂类型                支持                       不支持

    * 松散绑定即last-name=lastName
    * JSP303数据校验即@Email等
    * 复杂类型即对象、Map、数组

11、@PropertySource&@ImportResource
    @PropertySource：指定配置Properties文件进行映射，无法加载YAML文件，@ConfigurationProperties默认映射全局配置文件
    @ImportResource：加载指定配置文件，配置在主程序上，配合XML文件使用
        SpringBoot更推荐使用注解方式进行配置

12、配置文件占位符
    * 随机数：${random.value}、${random.int}、${random.long}、${random.int(10)}、${random.int[1,100]}
    * 占位符：可获取之前的配置信息，可以设置默认值

    person.last-name=金饼
    person.age=${random.int}
    person.man=false
    person.birthday=2019/08/11
    person.dog.name=dog
    person.dog.age=7
    person.kvs.id=${random.uuid}
    person.kvs.name=wjz
    person.items=spring, boot, ${person.last-name}, ${hello:world}

13、Profile适配不同环境的配置信息
    多Profile文件
        主配置文件名可以使application-${profile}.properties/yml，默认使用application.properties的配置

    YAML支持多文档块（'---'分隔文档块）
        spring:
            profiles:
                active: dev

        ---
        server:
            port: 8080
        spring:
            profiles: dev

        ---
        server:
            port: 8081
        spring:
            profiles: prod

    激活指定profile
        * 配置文件指定
            application.properties配置文件中写
                spring.profiles.active=dev
            application.yml配置文件中写
                spring:
                    profiles:
                        active: dev
        * 命令行启动
            打好包之后运行命令
                java -jar spring-boot-jar-1.0.jar --spring.profiles.active=dev
            测试时可以传入命令行参数
                Edit Configurations -> program Args -> --spring.profiles.active=dev
        * 虚拟机参数
            Edit Configurations -> VM options -> -Dspring.profiles.active=dev

14、配置文件的加载顺序
    context-path/config/    ：项目路径下的config目录下
    context-path/   ： 项目路径下
    classpath/config/   ： 类路径下的config目录下
    classpath/  ： 类路径下

    优先级由高到低，高优先级相同配置会覆盖低优先级配置
    SpringBoot会全部加载四个位置的主配置文件；互补配置

    加载指定的配置文件（优先级最高，仍互补配置）
    命令行方式启动项目：java -jar spring-boot-jar-1.0.jar --spring.config.location=D:/application.properties

15、外部化配置
    参考官方文档：https://docs.spring.io/spring-boot/docs/2.1.7.RELEASE/reference/html/boot-features-external-config.html

16、主配置文件能写哪些配置？
    参考官方文档：https://docs.spring.io/spring-boot/docs/2.1.7.RELEASE/reference/html/common-application-properties.html

17、SpringBoot配置原理
    1) SpringBoot启动时加载主配置类，开启自动配置功能，@SpringBootApplication --> @EnableAutoConfiguration
    2) @EnableAutoConfiguration作用：
        利用AutoConfigurationImportSelector导入自动配置组件，@Import({AutoConfigurationImportSelector.class})
        将类路径下 META-INF/spring.factories 配置文件里org.springframework.boot.autoconfigure对应的值加载到容器中
            org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
            org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration,\
            org.springframework.boot.autoconfigure.aop.AopAutoConfiguration,\
            org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration,\
            org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration,\
            org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration,\




