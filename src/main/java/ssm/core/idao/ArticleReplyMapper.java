package ssm.core.idao;

import java.util.List;

import ssm.core.entity.ArticleReply;

public interface ArticleReplyMapper {

    ArticleReply selectByPrimaryKey(Integer id);
    
    
    public List<ArticleReply> selectArticleReplies();
    
    
}