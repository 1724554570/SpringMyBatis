package ssm.core.service;

import java.util.List;

import ssm.core.entity.ArticleReply;

public interface ReplyService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	ArticleReply getByPrimaryKey(Integer id);
	
	/**
	 * 查询回复集合
	 * @return
	 */
	public List<ArticleReply> listReply(Integer articleId);

}
