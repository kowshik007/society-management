package com.application.start.restcontroller;

import com.application.start.entity.SocietyArticle;
import com.application.start.service.SocietyArticleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocietyArticleController {
    @Autowired
    private SocietyArticleInterface societyArticleInterface;

    @GetMapping("/society_article/{societyId}/{articleId}")
    public SocietyArticle mapSocietyArticle(@PathVariable("societyId") int societyId,@PathVariable("articleId") int articleId){
        return societyArticleInterface.mapSocietyArticle(societyId,articleId);
    }
}
