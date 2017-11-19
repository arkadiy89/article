package me.mars.articles.service.article;

import me.mars.articles.domain.Article;
import me.mars.articles.persistence.GenericDAO;
import me.mars.articles.persistence.article.ArticleDAO;
import me.mars.articles.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl extends GenericServiceImpl<Article, Long> implements ArticleService {
    private ArticleDAO articleDAO;

    public ArticleServiceImpl() {}

    @Autowired
    public ArticleServiceImpl(@Qualifier("articleDAOHibernateImpl") GenericDAO<Article, Long> genericDAO){
        super(genericDAO);
        this.articleDAO = (ArticleDAO) genericDAO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Article> getArticlesByTypeId(Long typeId) {
        return articleDAO.getArticlesByTypeId(typeId);
    }
}
