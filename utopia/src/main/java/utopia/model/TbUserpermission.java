package utopia.model;
public class TbUserpermission {
    private Integer id;

    private Integer pid;

    private Integer userid;

    public TbUserpermission(Integer id, Integer pid, Integer userid) {
        this.id = id;
        this.pid = pid;
        this.userid = userid;
    }

    public TbUserpermission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}