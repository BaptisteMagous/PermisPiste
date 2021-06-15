package com.PermisPiste.service;

import com.PermisPiste.domains.LogiParam;
import com.PermisPiste.entity.Learner;
import com.PermisPiste.mesExceptions.MonException;
import com.PermisPiste.repository.LearnerRepository;
import com.PermisPiste.utilitaires.MonMotPassHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements com.PermisPiste.service.IAuthentificationService {

    private LearnerRepository learnerRepository;

    @Autowired
    public AuthentificationService(LearnerRepository LearnerRepository) {
        this.learnerRepository = LearnerRepository;
    }

    @Override
    public Learner authentification(LogiParam unUti) throws Exception {
        Learner learner = null;
        String message;
        String login = unUti.getNomUtil();
        String pwd = unUti.getMotPasse();
        learner = learnerRepository.findByName(unUti.getNomUtil());
        if (learner != null) {
            try {
                // on récupère le sel
                String sel = learner.getSalt();
                // on récupère le mot de passe
                String mdp = learner.getMdp();
                // on génère le mot de passe avec les données de connexion
                byte[] salt = MonMotPassHash.transformeEnBytes(sel);
                char[] pwd_char = MonMotPassHash.converttoCharArray(pwd);
                byte[] monpwdCo = MonMotPassHash.generatePasswordHash(pwd_char, salt);
                // on récupère le mot de passe enregistré
                byte[] mdp_byte = MonMotPassHash.transformeEnBytes(mdp);
                if (!MonMotPassHash.verifyPassword(monpwdCo, mdp_byte)) {
                    message = "mot de passe erroné";
                    return null;
                }
            } catch (MonException e) {
                throw e;
            } catch (Exception e) {
                throw e;
            }
        }
        return learner;
    }
}
