package mx.com.interware.ssync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import lombok.extern.slf4j.Slf4j;

/**
 * Service start class
 * 
 * @author Interware
 *
 */
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
@OpenAPIDefinition(info = @Info(
        title = "Spring Boot Hexagonal Example",
        version = "1.0",
        description = "Spring Boot Hexagonal Example",
        license = @License(name = "Copyright@ InterWare", url = "https://www.interware.com.mx/"),
        contact = @Contact(name = "IW", url = "https://www.interware.com.mx/")))
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableCaching
@Slf4j
public class StreamSyncerApplication {

    /**
     * Spring main method.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(StreamSyncerApplication.class, args);
        log.info("The service has been successfully initialized {}.", applicationContext);
    }

}
