package me.mars.articles.controller;

import me.mars.articles.domain.ArticleType;
import me.mars.articles.service.article.ArticleService;
import me.mars.articles.service.articleType.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleTypeService articleTypeService;

    @RequestMapping("/articles")
    public String hello(Model model, @ModelAttribute("articleType") ArticleType type,
                        @RequestParam(value = "typeId", required = false) Long typeId) {
        if (typeId != null) {
           model.addAttribute("articles", articleService.getArticlesByTypeId(typeId));
           model.addAttribute("articleType", articleTypeService.get(typeId));
        } else {
            model.addAttribute("articles", articleService.getAll());
        }
        model.addAttribute("types", articleTypeService.getAll());
        return "articles";
    }

    @RequestMapping(path = "/articles", method = RequestMethod.POST)
    public String filterArticles(@ModelAttribute("articleType") ArticleType type) {
        if (type.getId() != null) {
            return "redirect:/articles?typeId=" + type.getId().intValue();
        } else {
            return "redirect:/articles";
        }
    }
}
