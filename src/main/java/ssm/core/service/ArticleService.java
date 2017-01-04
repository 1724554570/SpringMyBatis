package ssm.core.service;

import java.util.List;

import ssm.core.entity.Article;

public interface ArticleService {
	
	//int deleteByPrimaryKey(Integer id);

	//int insert(Article record);

	//int insertSelective(Article record);

	//Article selectByPrimaryKey(Integer id);

	//int updateByPrimaryKeySelective(Article record);

	//int updateByPrimaryKeyWithBLOBs(Article record);

	//public int updateByPrimaryKey(Article record);
	
	public List<Article> getArticleList();

}
