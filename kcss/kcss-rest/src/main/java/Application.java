import com.kcss.rest.config.RestConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RestConfig.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
