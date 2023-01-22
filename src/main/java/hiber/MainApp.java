package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      User user1 = new User("Max","One","max@mail.ru");
      User user2 = new User("Vasya","Two","vasya@mail.ru");
      User user3 = new User("Dima","Three","dima@mail.ru");
      User user4 = new User("Misha","Four","misha@mail.ru");
      Car lada = new Car("Granta",1111);
      Car nissan = new Car("NV200",2222);
      Car bmw = new Car("X5",3333);
      Car mercedes = new Car("Maybach",4444);

      userService.add(user1.setCar(lada).setUser(user1));
      userService.add(user2.setCar(nissan).setUser(user2));
      userService.add(user3.setCar(bmw).setUser(user3));
      userService.add(user4.setCar(mercedes).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }
      context.close();
   }
}