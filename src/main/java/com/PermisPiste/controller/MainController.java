package com.PermisPiste.controller;

import com.PermisPiste.entity.Action;
import com.PermisPiste.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ActionRepository actionRepository;

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
}
