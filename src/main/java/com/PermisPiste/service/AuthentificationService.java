package com.PermisPiste.service;

import com.PermisPiste.domains.LogiParam;
import com.PermisPiste.entity.Learner;
import com.PermisPiste.mesExceptions.MonException;
import com.PermisPiste.repository.LearnerRepository;
import com.PermisPiste.utilitaires.MonMotPassHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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
                System.out.println("sel = " + sel);
                // on récupère le mot de passe
                String mdp = learner.getMdp();
                System.out.println("mdp = " + mdp);
                // on génère le mot de passe avec les données de connexion
                byte[] salt = MonMotPassHash.transformeEnBytes(sel);
                System.out.println("salt = " + salt);
                char[] pwd_char = MonMotPassHash.converttoCharArray(pwd);
                System.out.println("pwd_char = " + pwd_char);
                byte[] monpwdCo = MonMotPassHash.generatePasswordHash(pwd_char, salt);
                System.out.println("monpwdCo = " + monpwdCo);
                // on récupère le mot de passe enregistré
                byte[] mdp_byte = MonMotPassHash.transformeEnBytes(mdp.trim());
                System.out.println("mdp_byte = " + mdp_byte);
                if (!MonMotPassHash.verifyPassword(monpwdCo, mdp_byte)) {
                    message = "mot de passe erroné";
                    return null;
                }
            } catch (MonException e) {
                e.printStackTrace();
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
        return learner;
    }

    @Override
    public void resetPassword(LogiParam unUti, String pwd) throws Exception {
        Learner learner = null;
        learner = learnerRepository.findByName(unUti.getNomUtil());
        if (learner != null) {
            try {
                byte[] bHash = MonMotPassHash.generatePasswordHash(MonMotPassHash.converttoCharArray(pwd), MonMotPassHash.transformeEnBytes(learner.getSalt()));
                String hash = MonMotPassHash.bytesToString(bHash);;
                System.out.println(hash);
                // le rajouter dans la base de données ?
            } catch (MonException e) {
                throw e;
            } catch (Exception e) {
                throw e;
            }
        }
    }

}
