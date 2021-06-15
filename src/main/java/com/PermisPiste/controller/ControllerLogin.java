package com.PermisPiste.controller;

import com.PermisPiste.domains.LogiParam;
import com.PermisPiste.entity.Learner;
import com.PermisPiste.mesExceptions.MonException;
import com.PermisPiste.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class ControllerLogin {
    // on initialise
    @Autowired
    private AuthentificationService unAuthenService;


    @RequestMapping("/login")
    public ModelAndView pageLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("formLogin");
    }

    @RequestMapping("/accueil")
    public ModelAndView pageIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("index");
    }

    ///
    //
    //// Contrôle Login
    ///
    ////
    @RequestMapping(method = RequestMethod.POST, value = "/getLogin")
    public ModelAndView controleLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        LogiParam unUtiParam = new LogiParam();
        HttpSession session;

        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
        unUtiParam.setNomUtil(login);
        unUtiParam.setMotPasse(pwd);
        String message = "";
        try {
            Learner learner = unAuthenService.authentification(unUtiParam);
            if (learner != null) {
                session = request.getSession();
                session.setAttribute("id", learner.getId());
                destinationPage = "index";
            } else {
                message = "mot de passe erroné";
                request.setAttribute("message", message);
                destinationPage = "formLogin";
            }
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }

        return new ModelAndView(destinationPage);
    }

}


