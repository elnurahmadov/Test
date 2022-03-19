package com.aykan.service.user;

import com.aykan.domain.user.PasswordResetToken;
import com.aykan.domain.user.User;

import java.util.Date;
import java.util.List;

public interface PasswordResetTokenService {
    PasswordResetToken savePasswordResetToken(PasswordResetToken passwordResetToken);

    PasswordResetToken updatePasswordResetToken(PasswordResetToken passwordResetToken);

    PasswordResetToken deletePasswordResetToken(PasswordResetToken passwordResetToken);

    PasswordResetToken findPasswordResetTokenByToken(String token);

    PasswordResetToken findPasswordResetTokenByUser(User user);

    PasswordResetToken findPasswordResetTokenFindById(Long id);

    List<PasswordResetToken> findAllByExpiryDateLessThan(Date date);

    boolean deleteAllExpiredSince(Date date);
}
