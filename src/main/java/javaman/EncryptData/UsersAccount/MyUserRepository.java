package javaman.EncryptData.UsersAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MyUserRepository extends JpaRepository<myUser,Long> {

    Optional<myUser> findByUsername(String username);
}
