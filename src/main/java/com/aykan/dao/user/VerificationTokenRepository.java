package com.aykan.dao.user;

import com.aykan.domain.user.User;
import com.aykan.domain.user.VerificationToken;

import java.util.Date;
import java.util.List;

public interface VerificationTokenRepository {
    VerificationToken saveVerificationToken(VerificationToken verificationToken);

    VerificationToken updateVerificationToken(VerificationToken verificationToken);

    VerificationToken deleteVerificationToken(VerificationToken verificationToken);

    VerificationToken findVerificationTokenByToken(String token);

    VerificationToken findVerificationTokenByUser(User user);

    List<VerificationToken> findAllExpiryDateLessThan(Date date);

    boolean deleteAllExpiredSince(Date date);
}
