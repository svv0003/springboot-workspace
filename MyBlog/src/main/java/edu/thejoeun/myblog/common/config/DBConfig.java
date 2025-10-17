package edu.thejoeun.myblog.common.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 기존에는 Java와 DB의 연결이 심하게 느렸다.
 * 미국 개발자인 Brett Wo... 누군가가 성능에 민감한 Java 어플리케이션 개발을 진행하면서
 * 기존 연결이 느려서 불만을 가져 만든 풀 HikariCP (Connection Pool)
 * 업계에서 가장 빠른 커넥션 풀이 생성되었다.
 * Spring Boot에서 Java-DB 연결할 때 기본으로 가져가는 속성이다.
 *
 * 자동적으로 pool-size 또는 다른 세팅이 기본적으로 적용되어 있느나,
 * 개발자가 원하는 속성으로 수정 가능하다.
 * 수정한 설정은 config.properties에 존재한다.
 *
 * 이 내용은 최초 1회만 작성하고, 수정은 안 한다.
 */
@Configuration
@PropertySource("classpath:/config.properties") // src/main/resources/config.properties 파일에 작성한 변수명들을 참고한다.
public class DBConfig {

    @Autowired
    private ApplicationContext applicationContext;  // 현재 프로젝트 파일 내용 모두 참고한다.

    @Value("${spring.datasource.url}")               // properties에 작성한 속성 명칭을 읽을 때 사용한다.
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    // HikariCP 설정

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariConfig hikariConfig() {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);

        // src/main/resources/config.properties 파일에서 읽어온
        // spring.datasource.hikari로 시작하는 모든 값을 이 설정 안에서 사용하겠다.
        // return new HikariConfig();
        return config;
    }

    // import javax.sql.DataSource;
    @Bean
    public DataSource dataSource(HikariConfig config) {
        DataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    // MyBatis 설정
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        // mappers 내부에 작성한 xml(SQL)이 모이는 경로를 설정한다.
        // MyBatis 코드 수행 시 mapper.xml 읽을 수 있도록 설정한다.
        // sessionFactory.setMapperLocations (현재 프로젝트에서 (어디에 위치한 mapper.xml 파일인지 위치 설정한다.));
        sessionFactory.setMapperLocations(
                applicationContext.getResources("classpath:/mappers/**/*.xml")
        );

        // application.properties에 작성한 model과 mapper를 연결해주는 속성 설정을 여기에 작성한다.
        // 해당 패키지 내 모든 클래스의 별칭을 등록하고,
        // mybatis는 특정 클래스 지정 시 패키지명.클래스명을 모두 작성해야 한다. -> 긴 이름을 짧게 부를 수 있도록 설정한다.
        sessionFactory.setTypeAliasesPackage("edu.thejoeun.myblog");

        // setTypeAliasesPackage ("패키지") 이용 시 클래스 파일명을 별칭으로 등록한다.
        sessionFactory.setConfigLocation(
                applicationContext.getResource("classpath:/mybatis-config.xml")
        );

        // 설정된 내용이 모두 적용된 상태로 객체 반환한다.
        return sessionFactory.getObject();
    }

    // DBCP (DataBase Connection Pool)
    // SqlSessionTemplate : Connection + DBCP + MyBatis + 트랜잭션 제어 처리
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
        return new SqlSessionTemplate(factory);
    }

    // save-point 또는 자동 커밋이 안 되는 oracle의 경우에는
    // 트랜잭션 매니저를 따로 작성해주지 않으면 insert update delete 할 때마다
    // 트랜잭션 코드를 service마다 작성을 하나하나 해줘야 한다.
    // 위 작업을 알아서 커밋하라. 개발자가 추가로
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}