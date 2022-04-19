package GensParkProject.FProject.Services;


import GensParkProject.FProject.Pojos.User;
import GensParkProject.FProject.Repositories.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserDetailRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = repo.findByUserName(username);
       if(user==null ){
           throw new UsernameNotFoundException("User not found with user name"+ username);
       }
        return user;
    }
}
