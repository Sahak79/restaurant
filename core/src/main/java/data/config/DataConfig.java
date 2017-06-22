package data.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by SahakBabayan on 6/21/2017.
 */
@Configuration
@PropertySource("classpath:db-config.properties")
@EntityScan("common.data.model")
@EnableJpaRepositories("data")
@EnableTransactionManagement
public class DataConfig {
}
