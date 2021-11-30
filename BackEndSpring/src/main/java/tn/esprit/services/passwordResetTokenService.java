package tn.esprit.services;

import tn.esprit.model.PasswordResetToken;
import tn.esprit.model.User;

import java.util.List;

public interface passwordResetTokenService {
    public PasswordResetToken getToken(String Token);
    public List<PasswordResetToken> getAllTokenByUser(User user);
    public void saveToken(PasswordResetToken token);
}
