package com.aykan.service.user.impl;

import com.aykan.dao.user.PasswordResetTokenRepository;
import com.aykan.domain.user.PasswordResetToken;
import com.aykan.domain.user.User;
import com.aykan.service.user.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public PasswordResetToken savePasswordResetToken(PasswordResetToken passwordResetToken) {
        return passwordResetTokenRepository.savePasswordResetToken(passwordResetToken);
    }

    @Override
    public PasswordResetToken updatePasswordResetToken(PasswordResetToken passwordResetToken) {
        return passwordResetTokenRepository.updatePasswordResetToken(passwordResetToken);
    }

    @Override
    public PasswordResetToken deletePasswordResetToken(PasswordResetToken passwordResetToken) {
        return passwordResetTokenRepository.deletePasswordResetToken(passwordResetToken);
    }

    @Override
    public PasswordResetToken findPasswordResetTokenByToken(String token) {
        return passwordResetTokenRepository.findPasswordResetTokenByToken(token);
    }

    @Override
    public PasswordResetToken findPasswordResetTokenByUser(User user) {
        return passwordResetTokenRepository.findPasswordResetTokenByUser(user);
    }

    @Override
    public PasswordResetToken findPasswordResetTokenFindById(Long id) {
        return passwordResetTokenRepository.findPasswordResetTokenFindById(id);
    }

    @Override
    public List<PasswordResetToken> findAllByExpiryDateLessThan(Date date) {
        return passwordResetTokenRepository.findAllByExpiryDateLessThan(date);
    }

    @Override
    public boolean deleteAllExpiredSince(Date date) {
        return passwordResetTokenRepository.deleteAllExpiredSince(date);
    }
}
