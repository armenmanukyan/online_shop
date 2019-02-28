package shop;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import shop.entity.UserEntity;
import shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import shop.dto.Role;
import org.springframework.context.annotation.ComponentScan;
import shop.service.impl.UserServiceImpl;

@ComponentScan
@EnableJpaRepositories("shop.repository")
@SpringBootApplication
public class ShopServer implements CommandLineRunner {

  @Autowired
  private UserService userService;

  public static void main(String[] args) {
    SpringApplication.run(ShopServer.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean UserService userService() {
    return new UserServiceImpl();
  }

  @Override
  public void run(String... params) throws Exception {
    UserEntity admin = new UserEntity();
    admin.setUsername("admin");
    admin.setPassword("admin");
      admin.setEmail("admin@gmail.com");
    admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.register(admin);

    UserEntity client = new UserEntity();
    client.setUsername("buyer");
    client.setPassword("buyer");
    client.setEmail("buyer@gmail.com");
    client.setRoles(new ArrayList<Role>(Arrays.asList(Role.GENERAL_USER)));

    userService.register(client);
  }

}
