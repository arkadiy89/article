package me.mars.articles.service.articleType;

import me.mars.articles.domain.ArticleType;
import me.mars.articles.persistence.GenericDAO;
import me.mars.articles.persistence.articleType.ArticleTypeDAO;
import me.mars.articles.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ArticleTypeServiceImpl extends GenericServiceImpl<ArticleType, Long>
        implements ArticleTypeService {

    private ArticleTypeDAO articleTypeDAO;

    public ArticleTypeServiceImpl() {

    }

    @Autowired
    public ArticleTypeServiceImpl(@Qualifier("articleTypeDAOHibernateImpl") GenericDAO<ArticleType, Long> genericDAO){
        super(genericDAO);
        this.articleTypeDAO = (ArticleTypeDAO) genericDAO;
    }
}
