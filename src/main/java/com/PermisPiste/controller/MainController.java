package com.PermisPiste.controller;

import com.PermisPiste.entity.Action;
import com.PermisPiste.entity.Learner;
import com.PermisPiste.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private IndicatorRepository indicatorRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private LearnerRepository learnerRepository;
    @Autowired
    private MissionRepository missionRepository;

    @GetMapping("/actions")
    @ResponseBody
    public List<Action> showAllActions(){
        return actionRepository.findAll();
    }

    @GetMapping("/action/{id}")
    @ResponseBody
    public Action showActionById(@PathVariable Integer id){
        return actionRepository.findById(id).orElse(null);
    }

    @GetMapping("/action/{wording}/{scoreMinimum}")
    @ResponseBody
    public Action showActionById(@PathVariable String wording, @PathVariable Integer scoreMinimum){
        Action action = new Action();
        action.setWording(wording);
        action.setScoreMinimum(scoreMinimum);
        return actionRepository.save(action);
    }

    @GetMapping("/")
    public String showIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getParameter("blablabla");
        return "index";
    }

    @GetMapping("/getListApprenant")
    public String getListApprenant(Model model) throws Exception {
        model.addAttribute("apprenants",learnerRepository.findAll());
        return "listApprenant";
    }

    @GetMapping("/getApprenant/{id}/")
    public String getApprenant(@PathVariable("id") Integer id, Model model) throws Exception {
        Optional<Learner> learner = learnerRepository.findById(id);
        if(learner.isPresent()) {
            model.addAttribute("apprenant",learner.get());
            return "getApprenant";
        }
    }
}
