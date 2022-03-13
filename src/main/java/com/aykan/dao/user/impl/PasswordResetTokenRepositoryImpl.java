package com.aykan.dao.user.impl;

import com.aykan.dao.user.PasswordResetTokenRepository;
import com.aykan.domain.user.PasswordResetToken;
import com.aykan.domain.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class PasswordResetTokenRepositoryImpl implements PasswordResetTokenRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PasswordResetToken savePasswordResetToken(PasswordResetToken passwordResetToken) {
        entityManager.persist(passwordResetToken);
        return passwordResetToken;
    }

    @Override
    public PasswordResetToken updatePasswordResetToken(PasswordResetToken passwordResetToken) {
        PasswordResetToken updatedPasswordResetToken = entityManager.merge(passwordResetToken);
        entityManager.flush();
        return updatedPasswordResetToken;
    }

    @Override
    public PasswordResetToken deletePasswordResetToken(PasswordResetToken passwordResetToken) {
        if (entityManager.contains(passwordResetToken)) {
            entityManager.remove(passwordResetToken);
            return passwordResetToken;
        }
        PasswordResetToken deletePasswordResetToken = findPasswordResetTokenFindById(passwordResetToken.getId());
        entityManager.refresh(deletePasswordResetToken);
        return deletePasswordResetToken;
    }

    @Override
    public PasswordResetToken findPasswordResetTokenByToken(String token) {
        TypedQuery<PasswordResetToken> typedQuery = entityManager.createNamedQuery("PasswordResetToken.findByToken", PasswordResetToken.class);
        typedQuery.setParameter("token", token);
        return typedQuery.getSingleResult();
    }

    @Override
    public PasswordResetToken findPasswordResetTokenByUser(User user) {
        TypedQuery<PasswordResetToken> typedQuery = entityManager.createNamedQuery("PasswordResetToken.findByUserId", PasswordResetToken.class);
        typedQuery.setParameter("userId", user.getId());
        return typedQuery.getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public PasswordResetToken findPasswordResetTokenFindById(Long id) {
        return entityManager.find(PasswordResetToken.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PasswordResetToken> findAllByExpiryDateLessThan(Date date) {
        TypedQuery<PasswordResetToken> typedQuery = entityManager.createNamedQuery("PasswordResetToken.findAllByExpiryDateLessThan", PasswordResetToken.class);
        typedQuery.setParameter("expiryDate", date, TemporalType.TIMESTAMP);
        return typedQuery.getResultList();
    }

    @Override
    public boolean deleteAllExpiredSince(Date date) {
        Query query = entityManager.createNamedQuery("PasswordResetToken.deleteExpiryDateToken");
        query.setParameter("date", date, TemporalType.TIMESTAMP);
        int i = query.executeUpdate();
        return i != -1;
    }
}
