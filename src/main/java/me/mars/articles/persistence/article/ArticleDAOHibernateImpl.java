package me.mars.articles.persistence.article;

import me.mars.articles.domain.Article;
import me.mars.articles.persistence.GenericDAOHibernateImpl;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ArticleDAOHibernateImpl extends GenericDAOHibernateImpl<Article, Long>
        implements ArticleDAO {
    @Override
    public List<Article> getArticlesByTypeId(Long typeId) {
        String hql = "FROM Article A WHERE A.articleType.id = " + typeId.intValue();
        Query query = currentSession().createQuery(hql);
        List<Article> list = (List<Article>) query.list();
        return list;
    }
}
