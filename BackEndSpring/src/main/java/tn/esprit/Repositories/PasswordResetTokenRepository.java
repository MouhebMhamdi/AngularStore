package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.model.PasswordResetToken;
import tn.esprit.model.User;

import java.util.List;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Long> {
    PasswordResetToken getPasswordResetTokenByToken(String Token);

    List<PasswordResetToken> getPasswordResetTokenByUser(User user);
}
