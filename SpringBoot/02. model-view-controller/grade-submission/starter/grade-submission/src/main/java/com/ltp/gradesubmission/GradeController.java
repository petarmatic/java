package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {
    
    @GetMapping("/grades")
    private String getGrades(Model model){
        Grade grade= new Grade("Harry", "Potions", "4");
        Grade hermioneGrade = new Grade("Hermione", "Potions", "2");
        model.addAttribute("grade",grade);
        model.addAttribute("hermioneGrade", hermioneGrade);
        return "grades";

    }
    
}
