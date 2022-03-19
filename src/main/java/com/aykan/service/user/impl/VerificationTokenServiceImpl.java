package com.aykan.service.user.impl;

import com.aykan.dao.user.UserRepository;
import com.aykan.dao.user.VerificationTokenRepository;
import com.aykan.domain.user.User;
import com.aykan.domain.user.VerificationToken;
import com.aykan.service.user.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private UserRepository userRepository;
    public static final String TOKEN_INVALID = "invalidToken";
    public static final String TOKEN_EXPIRED = "expired";
    public static final String TOKEN_VALID = "valid";

    @Override
    public String validateVerificationToken(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findVerificationTokenByToken(token);
        if (verificationToken == null) {
            return TOKEN_INVALID;
        }
        Calendar calendar = Calendar.getInstance();
        if (verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime() <= 0) {
            return TOKEN_EXPIRED;
        }
        User user = verificationToken.getUser();
        user.setEnabled(true);
        userRepository.updateUser(user);
        return TOKEN_VALID;
    }


    @Override
    public VerificationToken saveVerificationToken(VerificationToken verificationToken) {
        return null;
    }

    @Override
    public VerificationToken updateVerificationToken(VerificationToken verificationToken) {
        return null;
    }

    @Override
    public VerificationToken deleteVerificationToken(VerificationToken verificationToken) {
        return null;
    }

    @Override
    public VerificationToken findVerificationTokenByToken(String token) {
        return null;
    }

    @Override
    public VerificationToken findVerificationTokenByUser(User user) {
        return null;
    }

    @Override
    public List<VerificationToken> findAllExpiryDateLessThan(Date date) {
        return null;
    }

    @Override
    public boolean deleteAllExpiredSince(Date date) {
        return false;
    }
}
