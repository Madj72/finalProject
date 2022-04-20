package GensParkProject.FProject.Repositories;



import GensParkProject.FProject.Pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailRepo extends JpaRepository <User ,Long> {
   User findByUserName(String userName);
}
