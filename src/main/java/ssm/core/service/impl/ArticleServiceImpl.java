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

    /**
     * 获取文章集合
     * @return 
     */
    public List<Article> getArticleList() {
        List<Article> articles = this.articleMapper.selAllList();
        return articles;
    }

    /**
     * 查询单条信息
     * @param id
     * @return 
     */
    public Article getByPrimaryKey(Integer id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        return article;
    }

}
