package zuul.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/7/17.
 */
@Configuration
public class FilterConfig {
    private static final Logger log = LoggerFactory.getLogger(FilterConfig.class);
//    @Autowired
//    MyFilter filter;
    @Bean
    public CorsFilter myFilter(){
        CorsFilter filter = new CorsFilter();
        log.info(filter+"--------------------------------");
        return filter;
    }
}
