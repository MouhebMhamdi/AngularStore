package tn.esprit.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.PasswordResetTokenRepository;
import tn.esprit.model.PasswordResetToken;
import tn.esprit.model.User;

import java.util.List;
@Service
public class passwordResetTokenServiceImpl implements passwordResetTokenService{
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;
    @Override
    public PasswordResetToken getToken(String Token) {
        return passwordResetTokenRepository.getPasswordResetTokenByToken(Token);
    }

    @Override
    public List<PasswordResetToken> getAllTokenByUser(User user) {
        return passwordResetTokenRepository.getPasswordResetTokenByUser(user);
    }

    @Override
    public void saveToken(PasswordResetToken token) {
        passwordResetTokenRepository.save(token);
    }
}
