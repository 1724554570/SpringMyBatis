package ssm.core.entity;

public class ArticleReply {
    private Integer id;

    private String addTime;

    private Boolean state;

    private Integer articleId;

    private String replyUser;

    private String replyToId;

    private String replyToUser;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(String replyUser) {
        this.replyUser = replyUser == null ? null : replyUser.trim();
    }

    public String getReplyToId() {
        return replyToId;
    }

    public void setReplyToId(String replyToId) {
        this.replyToId = replyToId == null ? null : replyToId.trim();
    }

    public String getReplyToUser() {
        return replyToUser;
    }

    public void setReplyToUser(String replyToUser) {
        this.replyToUser = replyToUser == null ? null : replyToUser.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}