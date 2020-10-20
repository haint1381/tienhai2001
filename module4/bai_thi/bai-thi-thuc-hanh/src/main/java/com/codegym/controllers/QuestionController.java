package com.codegym.controllers;

import com.codegym.model.Question;
import com.codegym.service.QuestionService;
import com.codegym.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping({"","/question"})
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionTypeService questionTypeService;
    @GetMapping
    public String pageQuestion(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("questionList",questionService.getAll(pageable));
        return "question/list";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("question/create");
        modelAndView.addObject("question", new Question());
        modelAndView.addObject("questionTypeList",questionTypeService.findAll());
        return modelAndView;
    }
    @PostMapping("/saveQuestion")
    public String createQuestion(@Validated @ModelAttribute("question") Question question,BindingResult bindingResult,Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("questionList",questionService.findAll());
            return "question/list";
        }else {
            question.setDateCreate(LocalDate.now()+"");
            question.setStatus("Chờ Phản Hồi");
            question.setUserFeedback("N/A");
            questionService.save(question);
            return "redirect:/question";
        }
    }
    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id,Model model) {
        questionService.delete(id);
        return "redirect:/question";
    }

    @PostMapping("/searchAll")
    public String searchAll(@RequestParam("inputSearch") String name,@RequestParam("selectSearch") String select ,Model model, @PageableDefault(value = 5) Pageable pageable){
        if(select.equals("title")){
            model.addAttribute("questionList", questionService.findQuestionByTitleContains(name,pageable));
            model.addAttribute("value", name);

        }else if(select.equals("typeQuestion")){
            model.addAttribute("questionList", questionService.findQuestionByQuestionTypeContains(name,pageable));
            model.addAttribute("value", name);

        }else if(select.equals("all")){
            model.addAttribute("questionList", questionService.findQuestionByQuestionTypeContainsOrTitleContains(name,pageable));
            model.addAttribute("value", name);

        }else {
            model.addAttribute("questionList", questionService.getAll(pageable));
        }
        model.addAttribute("name", select);
        return "question/list";
    }
}
