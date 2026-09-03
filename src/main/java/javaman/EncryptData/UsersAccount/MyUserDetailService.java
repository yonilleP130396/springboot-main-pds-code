package javaman.EncryptData.UsersAccount;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final MyUserRepository myUserRepository;

   
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<myUser> user = myUserRepository.findByUsername(username);

        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRole(userObj))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRole(myUser user){
        if (user.getRole() == null){
            return new String[]{"USER","ADMIN"};
        }
        return user.getRole().split(",");
    }

    public String getCurrentUserFullName() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        Optional<myUser> user =
                myUserRepository.findByUsername(username);

        return user.map(myUser::getFullName)
                .orElse("Unknown User");
    }
}