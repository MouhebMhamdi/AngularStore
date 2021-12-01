package tn.esprit.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User getUserByEmail(String email);

    User getUserByEmailAndPassword(String email,String password);



}
