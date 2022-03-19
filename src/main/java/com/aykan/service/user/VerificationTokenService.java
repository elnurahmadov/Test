package com.aykan.service.user;

import com.aykan.domain.user.User;
import com.aykan.domain.user.VerificationToken;

import java.util.Date;
import java.util.List;

public interface VerificationTokenService {
    String validateVerificationToken(String token);

    VerificationToken saveVerificationToken(VerificationToken verificationToken);

    VerificationToken updateVerificationToken(VerificationToken verificationToken);

    VerificationToken deleteVerificationToken(VerificationToken verificationToken);

    VerificationToken findVerificationTokenByToken(String token);

    VerificationToken findVerificationTokenByUser(User user);

    List<VerificationToken> findAllExpiryDateLessThan(Date date);

    boolean deleteAllExpiredSince(Date date);
}
