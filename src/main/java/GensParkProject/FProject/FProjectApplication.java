package GensParkProject.FProject;

import GensParkProject.FProject.Pojos.Authority;
import GensParkProject.FProject.Pojos.User;
import GensParkProject.FProject.Repositories.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FProjectApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailRepo userDetailRepo;

	public static void main(String[] args) {
		SpringApplication.run(FProjectApplication.class, args);
	}



	@PostConstruct
	protected void init (){
		List <Authority> authorityList = new ArrayList<>();
		authorityList.add(createAuthority("USER","User role"));
		authorityList.add(createAuthority("ADMIN","Admin role"));

		User user = new User();
		user.setUserName("testinguser");
		user.setFirstName("firstNameTest");
		user.setLastName("lastNameTest");
		user.setPassword(passwordEncoder.encode("test@123"));
		user.setEnabled(true);

		userDetailRepo.save(user);
	}

	private Authority createAuthority(String roleCode, String roleDescription){
		Authority authority = new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}






}



