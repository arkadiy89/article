package me.mars.articles.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeid")
    private ArticleType articleType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "article_link", joinColumns = { @JoinColumn(name = "article1_id") }, inverseJoinColumns = { @JoinColumn(name = "article2_id") })
    private List<Article> refArticles;

    public Article() {
    }

    public Article(String name, ArticleType articleType, List<Article> refArticles) {
        this.name = name;
        this.articleType = articleType;
        this.refArticles = refArticles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public List<Article> getRefArticles() {
        return refArticles;
    }

    public void setRefArticles(List<Article> refArticles) {
        this.refArticles = refArticles;
    }

    public int getCountRefArticlesByTypeId(Long typeId) {
        int count = 0;
        for (Article a: refArticles) {
            if (a.getArticleType().getId().equals(typeId)) {
                count++;
            }
        }
        return count;
    }
}
