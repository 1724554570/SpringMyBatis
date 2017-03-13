package ssm.core.idao;

import java.util.List;

import ssm.core.entity.ArticleReply;

public interface ArticleReplyMapper {

	/**
	 * 
	 * @param id
	 * @return
	 */
    ArticleReply selectByPrimaryKey(Integer id);
    
    /**
     * 
     * @return
     */
    public List<ArticleReply> selectArticleReplies(Integer articleId);
    
    /**
     * 
     * @param articleReply
     * @return
     */
	int insertReply(ArticleReply articleReply);
    
}