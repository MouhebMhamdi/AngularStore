package tn.esprit.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import tn.esprit.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    void ajouterUser(User user);
    Optional<User> chercherUserByID(long id);


    User getUserByEmail(String email);

    void supprimerUser(long id);
    void supprimerToutLesUsers();
    List<User> chercherUser();

    void  updateUser(User user, long id );
    void updateUserPassword(String password,long id);
    User getUserByEmailAndPassword(String email,String Password);

    void addRoleToUser(String email,String role);

  User getUserByIdClient(long id);

}
