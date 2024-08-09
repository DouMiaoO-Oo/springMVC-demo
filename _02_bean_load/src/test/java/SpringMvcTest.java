import org.example.config.SpringConfig;
import org.example.config.SpringMvcConfig;
import org.example.controller.UserController;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.Test;


public class SpringMvcTest {
    @Test
    public void getBeanTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(context.getBean(UserService.class));
    }
}
