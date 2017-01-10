package ssm.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.core.entity.Article;
import ssm.core.idao.ArticleMapper;
import ssm.core.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    public ArticleMapper getArticleMapper() {
        return articleMapper;
    }

    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    /**
     * 获取文章集合
     */
    public List<Article> getArticleList() {
        List<Article> articles = this.articleMapper.selAllList();
        return articles;
    }

}
