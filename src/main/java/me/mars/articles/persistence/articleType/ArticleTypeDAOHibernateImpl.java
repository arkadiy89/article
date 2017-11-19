package me.mars.articles.persistence.articleType;

import me.mars.articles.domain.ArticleType;
import me.mars.articles.persistence.GenericDAOHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleTypeDAOHibernateImpl extends GenericDAOHibernateImpl<ArticleType, Long>
        implements ArticleTypeDAO {

}
