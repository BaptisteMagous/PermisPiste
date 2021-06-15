package com.PermisPiste.service;
import com.PermisPiste.domains.LogiParam;
import com.PermisPiste.entity.Learner;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface IAuthentificationService {

    public Learner authentification(@RequestBody LogiParam unUti) throws Exception;
    public void resetPassword(LogiParam unUti, String pwd) throws Exception;

}
