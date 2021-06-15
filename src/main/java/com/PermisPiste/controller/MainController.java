package com.PermisPiste.controller;

import com.PermisPiste.domains.LogiParam;
import com.PermisPiste.entity.*;
import com.PermisPiste.repository.*;
import com.PermisPiste.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class MainController {

    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private IndicatorRepository indicatorRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private InscriptionActionRepository inscriptionActionRepository;
    @Autowired
    private LearnerRepository learnerRepository;
    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private AuthentificationService unAuthenService;

    @GetMapping("/test")
    @ResponseBody
    public String showAllActions(@RequestParam(name = "msg") String msg){
        return msg;
    }

/*
    @GetMapping("/action/{id}")
    @ResponseBody
    public Action showActionById(@PathVariable Integer id){
        return actionRepository.findById(id).orElse(null);
    }

    @GetMapping("/action/{wording}/{scoreMinimum}")
    @ResponseBody
    public Action createAction(@PathVariable String wording, @PathVariable Integer scoreMinimum){
        Action action = new Action();
        action.setWording(wording);
        action.setScoreMinimum(scoreMinimum);
        return actionRepository.save(action);
    }*/

    @GetMapping("/")
    public String showIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // code de reset mdp
        final int ID_USER = 1;
        final String NEW_MDP = "bob";
        LogiParam unUtiParam = new LogiParam();
        Learner l = learnerRepository.findById(ID_USER).orElseThrow(Exception::new);
        unUtiParam.setNomUtil(l.getForname());
        unAuthenService.resetPassword(unUtiParam, NEW_MDP);



        return "index";
    }

    // region [- Apprenant -]

    @GetMapping("/apprenant/liste")
    public String GetListApprenant(Model model) throws Exception {
        model.addAttribute("apprenants",learnerRepository.findAll());
        return "apprenant/liste";
    }

    @GetMapping("/apprenant/{id}")
    public String GetApprenant(@PathVariable("id") Integer id, Model model) throws Exception {
        Optional<Learner> learner = learnerRepository.findById(id);
        if(learner.isPresent()) {
            model.addAttribute("learner",learner.get());
            model.addAttribute("inscriptions",inscriptionRepository.getInscriptionOfLearner(id));
        }
        else{
            model.addAttribute("error","Apprennant introuvable");
        }
        return "apprenant/voir";
    }

    @GetMapping("/apprenant/update/{id}")
    public String GetApprenantUpdate(@PathVariable("id") Integer id, Model model) throws Exception {
        model.addAttribute("updating",true);
        return GetApprenant(id, model);
    }

    @GetMapping("/apprenant/create/{surname}/{forname}/{salt}/{email}/{mdp}/{role}")
    public String CreateApprenant(@PathVariable("surname") String surname,
                                  @PathVariable("forname") String forname,
                                  @PathVariable("salt") String salt,
                                  @PathVariable("email") String email,
                                  @PathVariable("mdp") String mdp,
                                  @PathVariable("role") String role, Model model) throws Exception {
        Learner learner = new Learner();
        learner.setSurname(surname);
        learner.setForname(forname);
        learner.setSalt(salt);
        learner.setEmail(email);
        learner.setMdp(mdp);


        learner = learnerRepository.save(learner);

        return GetApprenant(learner.getId(), model);
    }

    @GetMapping("/apprenant/delete/{id}")
    public String DeleteApprenant(@PathVariable("id") Integer id, Model model) throws Exception {
        learnerRepository.deleteById(id);

        model.addAttribute("result", !learnerRepository.findById(id).isPresent());

        return GetListApprenant(model);
    }

    @RequestMapping(value = "/apprenant/{id}/update",method = RequestMethod.POST)
    public String UpdateApprenant(@PathVariable("id") Integer id,
                                  @RequestParam(name = "surname") String surname,
                                  @RequestParam(name = "forname") String forname,
                                  @RequestParam(name = "salt") String salt,
                                  @RequestParam(name = "email") String email,
                                  @RequestParam(name = "mdp") String mdp,
                                  @RequestParam(name = "role") String role, Model model) throws Exception {
        Optional<Learner> optionalLearner = learnerRepository.findById(id);
        if(optionalLearner.isPresent()) {
            Learner learner = optionalLearner.get();
            learner.setSurname(surname);
            learner.setForname(forname);
            learner.setSalt(salt);
            learner.setEmail(email);
            learner.setMdp(mdp);

            model.addAttribute("result", learnerRepository.save(learner));
        }
        else{
            model.addAttribute("error","Apprennant introuvable");
        }



        return GetApprenant(id, model);
    }

    // endregion Apprennant

    // region [- Mission -]
    @GetMapping("/mission/liste")
    public String GetListMission(Model model) throws Exception {
        model.addAttribute("missions", missionRepository.findAll());
        return "mission/liste";
    }

    @GetMapping("/mission/{id}")
    public String GetMission(@PathVariable("id") Integer id, Model model) throws Exception {
        Optional<Mission> mission = missionRepository.findById(id);
        if(mission.isPresent()) {
            model.addAttribute("mission",mission.get());
            model.addAttribute("actions",actionRepository.getActionOfMission(id));
        }
        else{
            model.addAttribute("error","Mission introuvable");
        }
        return "mission/voir";
    }

    @GetMapping("/mission/{id}/update")
    public String GetMissionUpdate(@PathVariable("id") Integer id, Model model) throws Exception {
        model.addAttribute("updating",true);
        return GetMission(id, model);
    }

    @GetMapping("/mission/{id}/register")
    public String RegisterToMission(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id, Model model) throws Exception {
        System.out.println("Registering......................................................");
        HttpSession session = request.getSession();
        Random random = new Random();

        Optional<Mission> optionalMission = missionRepository.findById(id);
        if(!optionalMission.isPresent()) {
            request.setAttribute("MesErreurs", "Mission introuvable");
            return "Erreur";
        }

        if(session.getAttribute("id") == null) {
            request.setAttribute("MesErreurs", "Non connecté");
            return "Erreur";
        }
        Optional<Learner> optionalLearner = learnerRepository.findById((Integer) session.getAttribute("id"));
        if(!optionalLearner.isPresent()) {
            request.setAttribute("MesErreurs", "Non connecté");
            return "Erreur";
        }


        Inscription inscription = new Inscription();
        inscription.setFk_mission(optionalMission.get());
        inscription.setFk_learner(optionalLearner.get());
        inscription = inscriptionRepository.save(inscription);

        List<Action> actions = actionRepository.getActionOfMission(optionalMission.get().getId());
        int score, i = 0;
        for (Action action: actions) {
            InscriptionAction inscriptionAction = new InscriptionAction();
            inscriptionAction.setFk_inscription(inscription);
            inscriptionAction.setFk_action(action);
            inscriptionAction.setSort(i++);

            List<Indicator> indicators = indicatorRepository.getIndicatorsOfAction(action.getId());
            score = 0;
            for (Indicator indicator: indicators) {
                if(random.nextBoolean()){
                    score += indicator.getValueIfCheck();
                }else{
                    score += indicator.getValueIfUnCheck();
                }
            }
            inscriptionAction.setScore(score);
            inscriptionActionRepository.save(inscriptionAction);
        }

        model.addAttribute("learner", optionalLearner.get());
        model.addAttribute("inscriptions",inscriptionRepository.getInscriptionOfLearner((Integer) session.getAttribute("id")));
        return "apprenant/voir";
    }

    @GetMapping("/mission/{id}/delete")
    public String DeleteMission(@PathVariable("id") Integer id, Model model) throws Exception {
        missionRepository.deleteById(id);

        model.addAttribute("result", !missionRepository.findById(id).isPresent());

        return GetListMission(model);
    }

    @RequestMapping(value = "/mission/{id}/update", method = RequestMethod.POST)
    public String UpdateMission(@PathVariable("id") Integer id,
                                @RequestParam(name = "wording") String wording, Model model) throws Exception {
        Optional<Mission> optionalMission = missionRepository.findById(id);
        if(optionalMission.isPresent()) {
            Mission mission = optionalMission.get();
            mission.setWording(wording);

            model.addAttribute("result", missionRepository.save(mission));
        }
        else{
            model.addAttribute("error","Mission introuvable");
        }

        return GetMission(id, model);
    }

    // endregion [- Mission -]

    // region [- Action -]
    @GetMapping("/action/liste")
    public String GetListAction(Model model) throws Exception {
        model.addAttribute("actions", actionRepository.findAll());
        return "action/liste";
    }

    @GetMapping("/action/{id}")
    public String GetAction(@PathVariable("id") Integer id, Model model) throws Exception {
        Optional<Action> action = actionRepository.findById(id);
        if(action.isPresent()) {
            model.addAttribute("action",action.get());
            model.addAttribute("indicators",indicatorRepository.getIndicatorsOfAction(id));
        }
        else{
            model.addAttribute("error","Action introuvable");
        }
        return "action/voir";
    }

    @GetMapping("/action/{id}/update")
    public String GetActionUpdate(@PathVariable("id") Integer id, Model model) throws Exception {
        model.addAttribute("updating",true);
        return GetAction(id, model);
    }

    @GetMapping("/action/create/{wording}/{scoreMinimum}")
    public String CreateAction(@PathVariable("wording") String wording,
                               @PathVariable("scoreMinimum") Integer scoreMinimum,
                               Model model) throws Exception {
        Action action = new Action();
        action.setWording(wording);
        action.setScoreMinimum(scoreMinimum);
        action = actionRepository.save(action);

        return GetAction(action.getId(), model);
    }

    @GetMapping("/action/{id}/delete")
    public String DeleteAction(@PathVariable("id") Integer id, Model model) throws Exception {
        actionRepository.deleteById(id);

        model.addAttribute("result", !actionRepository.findById(id).isPresent());

        return GetListAction(model);
    }

    @RequestMapping(value="/action/{id}/update", method = RequestMethod.POST)
    public String UpdateAction(@PathVariable("id") Integer id,
                               @RequestParam(name = "wording") String wording,
                               @RequestParam(name = "scoreMinimum") Integer scoreMinimum,
                               Model model) throws Exception {
        Optional<Action> optionalAction = actionRepository.findById(id);
        if(optionalAction.isPresent()) {
            Action action = optionalAction.get();
            action.setWording(wording);
            action.setScoreMinimum(scoreMinimum);

            model.addAttribute("result", actionRepository.save(action));
            return GetAction(action.getId(), model);
        }
        else{
            model.addAttribute("error","Action introuvable");
            return "Erreur";
        }


    }

    // endregion [- Actions -]


}
