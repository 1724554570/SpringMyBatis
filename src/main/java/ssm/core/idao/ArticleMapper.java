package ssm.core.idao;

import java.util.List;

import ssm.core.entity.Article;

public interface ArticleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    /**
     * 
     * @param id
     * @return 
     */
    Article selectByPrimaryKey(Integer id);

    /**
     * 
     * @param record
     * @return 
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * 
     * @param record
     * @return 
     */
    int updateByPrimaryKeyWithBLOBs(Article record);

    /**
     * 
     * @param record
     * @return 
     */
    int updateByPrimaryKey(Article record);

    //Article selAllList(Article article);
    public List<Article> selAllList();
}
