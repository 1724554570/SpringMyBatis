package ssm.core.search;

import java.util.List;

import ssm.core.entity.OUsers;

public class UserSearchParms {

    private int startIndex;
    private int pageSize;
    private int searchIndex;
    private int totalSize;
    //private String searchname = null;
    private String searchname = "";
    private List<OUsers> oUsers;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {System.out.println(this.startIndex);
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSearchIndex() {
        this.searchIndex = (this.searchIndex - 1) * this.pageSize;
        return searchIndex;
    }

    public void setSearchIndex(int searchIndex) {
        this.searchIndex = searchIndex;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {System.out.println(this.totalSize);
        this.totalSize = totalSize;
    }

    public String getSearchname() {
        return searchname;
    }

    public void setSearchname(String searchname) {System.out.println(this.searchname);
        this.searchname = searchname;
    }

    public List<OUsers> getoUsers() {
        return oUsers;
    }

    public void setoUsers(List<OUsers> oUsers) {
        this.oUsers = oUsers;
    }

}
