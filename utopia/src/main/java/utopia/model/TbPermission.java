package utopia.model;

import java.util.Date;

public class TbPermission {
    private Integer id;

    private String permissionName;

    private String permissionContext;

    private Integer parentid;

    private Date operationTime;

    private String operator;

    public TbPermission(Integer id, String permissionName, String permissionContext, Integer parentid, Date operationTime, String operator) {
        this.id = id;
        this.permissionName = permissionName;
        this.permissionContext = permissionContext;
        this.parentid = parentid;
        this.operationTime = operationTime;
        this.operator = operator;
    }

    public TbPermission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionContext() {
        return permissionContext;
    }

    public void setPermissionContext(String permissionContext) {
        this.permissionContext = permissionContext == null ? null : permissionContext.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}