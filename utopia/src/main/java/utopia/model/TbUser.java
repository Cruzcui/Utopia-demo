package utopia.model;
import java.util.Date;

public class TbUser {
    private Integer id;

    private String userName;

    private String userCname;

    private String password;

    private Date operationTime;

    public TbUser(Integer id, String userName, String userCname, String password, Date operationTime) {
        this.id = id;
        this.userName = userName;
        this.userCname = userCname;
        this.password = password;
        this.operationTime = operationTime;
    }

    public TbUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserCname() {
        return userCname;
    }

    public void setUserCname(String userCname) {
        this.userCname = userCname == null ? null : userCname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}