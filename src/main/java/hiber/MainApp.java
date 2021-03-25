package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   private static EntityManager session;

   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user0 = new User("User0", "Lastname0", "user0@mail.ru");
      user0.setCar(new Car("bmw", 130));
      userService.add(user0);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(new Car("bmw", 330));
      userService.add(user1);

      User user2 = new User("User2", "Lastname2", "use2r@mail.ru");
      user2.setCar(new Car("bmw", 530));
      userService.add(user2);

      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setCar(new Car("bmw", 730));
      userService.add(user3);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      List <User> user = userService.getUser("bmw", 330);
      System.out.println(user);


      context.close();
   }

}
