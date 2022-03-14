package com.aykan.dao.user.impl;

import com.aykan.dao.user.VerificationTokenRepository;
import com.aykan.domain.user.User;
import com.aykan.domain.user.VerificationToken;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class VerificationRepositoryImpl implements VerificationTokenRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public VerificationToken saveVerificationToken(VerificationToken verificationToken) {
        entityManager.persist(verificationToken);
        return verificationToken;
    }

    @Override
    public VerificationToken updateVerificationToken(VerificationToken verificationToken) {
        VerificationToken updatedToken = entityManager.merge(verificationToken);
        entityManager.flush();
        return updatedToken;
    }

    @Override
    public VerificationToken deleteVerificationToken(VerificationToken verificationToken) {
        if (entityManager.contains(verificationToken)) {
            entityManager.remove(verificationToken);
            return verificationToken;
        }
        VerificationToken deleteToken = findVerificationTokenByToken(verificationToken.getToken());
        entityManager.remove(deleteToken);
        return deleteToken;
    }

    @Override
    public VerificationToken findVerificationTokenByToken(String token) {
        System.out.println("dao token: " + token);
        if (token.trim().length() <= 0 || token == null) {
            throw new RuntimeException("Invalid token");
        }
        return entityManager.createNamedQuery("VerificationToken.findByToken", VerificationToken.class).setParameter("token", token).getSingleResult();
    }

    @Override
    public VerificationToken findVerificationTokenByUser(User user) {
        if (user == null)
            return null;
        TypedQuery<VerificationToken> typedQuery = entityManager.createNamedQuery("VerificationToken.findByUserId", VerificationToken.class);
        typedQuery.setParameter("userId", user.getId());
        return typedQuery.getSingleResult();
    }


    @Override
    public List<VerificationToken> findAllExpiryDateLessThan(Date date) {
        TypedQuery<VerificationToken> typedQuery = entityManager.createNamedQuery("VerificationToken.findAllExpiryDateLessThan", VerificationToken.class);
        typedQuery.setParameter("expiryDate", date);
        return typedQuery.getResultList();
    }

    @Override
    public boolean deleteAllExpiredSince(Date date) {
        Query query = entityManager.createNamedQuery("VerificationToken.deleteExpiryDateToken");
        int count = query.setParameter("date", date, TemporalType.TIMESTAMP).executeUpdate();
        return count != -1;
    }
}
