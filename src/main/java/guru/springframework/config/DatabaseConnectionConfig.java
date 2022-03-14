package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConnectionConfig {


    private Environment env;

    public DatabaseConnectionConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource ();
        ds.setDriverClassName(env.getProperty("datasource.driver-class-name"));
        ds.setUrl(env.getProperty("datasource.url"));
        ds.setUsername(env.getProperty("datasource.username"));
        ds.setPassword(env.getProperty("datasource.password"));

        return ds;
    }
}
