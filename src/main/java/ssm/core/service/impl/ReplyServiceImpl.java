package ssm.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.core.entity.ArticleReply;
import ssm.core.idao.ArticleReplyMapper;
import ssm.core.service.ReplyService;

@Service("articleReplyService")
public class ReplyServiceImpl implements ReplyService {

	@Resource
	private ArticleReplyMapper replyMapper;

	/**
	 * 查询key
	 */
	public ArticleReply getByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		ArticleReply reply = replyMapper.selectByPrimaryKey(id);
		return reply;
	}

	/**
	 * 查询 集合
	 */
	public List<ArticleReply> listReply(Integer articleId) {
		// TODO Auto-generated method stub
		List<ArticleReply> articleReplies = replyMapper.selectArticleReplies();
		return articleReplies;
	}

}
