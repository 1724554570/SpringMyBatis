package ssm.core.idao;

import java.util.List;

import ssm.core.entity.Article;


public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    //Article selAllList(Article article);
    
    public List<Article> selAllList();
}