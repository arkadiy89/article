package me.mars.articles.service.article;

import me.mars.articles.domain.Article;
import me.mars.articles.service.GenericService;

import java.util.List;

public interface ArticleService extends GenericService<Article, Long> {
    List<Article> getArticlesByTypeId(Long typeId);
}
