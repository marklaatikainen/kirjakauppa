package fi.haagahelia.kirjakauppa.control;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import fi.haagahelia.kirjakauppa.model.User;
import fi.haagahelia.kirjakauppa.model.UserRepository;

@Controller
public class UserController {
	
	@Bean
	public CommandLineRunner addUsers(UserRepository repository) {
		return (args) -> {
			repository.save(new User("user", "$2a$10$o0uurcpsJHpHjOqqOmeLvePQrWcZ2JrNitkqhmlY2pLKkXxK/g45W", "email@user.com", "USER"));
			repository.save(new User("mark", "$2a$10$o0uurcpsJHpHjOqqOmeLvePQrWcZ2JrNitkqhmlY2pLKkXxK/g45W", "mark.laatikainen@myy.haaga-helia.fi", "ADMIN"));
		};
	}
}
