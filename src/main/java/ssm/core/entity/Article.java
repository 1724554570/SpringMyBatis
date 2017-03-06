package ssm.core.entity;

public class Article {

    private Integer id;

    private String productname;

    private String proctime;

    private String proutime;

    private String foruser;

    private Byte prostate;

    private Byte propower;

    private Integer exadmin;

    private String productdesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getProctime() {
        return proctime;
    }

    public void setProctime(String proctime) {
        this.proctime = proctime == null ? null : proctime.trim();
    }

    public String getProutime() {
        return proutime;
    }

    public void setProutime(String proutime) {
        this.proutime = proutime == null ? null : proutime.trim();
    }

    public String getForuser() {
        return foruser;
    }

    public void setForuser(String foruser) {
        this.foruser = foruser == null ? null : foruser.trim();
    }

    public Byte getProstate() {
        return prostate;
    }

    public void setProstate(Byte prostate) {
        this.prostate = prostate;
    }

    public Byte getPropower() {
        return propower;
    }

    public void setPropower(Byte propower) {
        this.propower = propower;
    }

    public Integer getExadmin() {
        return exadmin;
    }

    public void setExadmin(Integer exadmin) {
        this.exadmin = exadmin;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc == null ? null : productdesc.trim();
    }
}
