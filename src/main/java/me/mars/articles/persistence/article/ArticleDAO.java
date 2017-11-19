package me.mars.articles.persistence.article;

import me.mars.articles.domain.Article;
import me.mars.articles.persistence.GenericDAO;

import java.util.List;

public interface ArticleDAO extends GenericDAO<Article, Long> {
    List<Article> getArticlesByTypeId(Long typeId);
}
