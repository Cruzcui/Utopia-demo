package utopia.model;
import java.util.Date;

public class TbStore {
    private Integer id;

    private String storeName;

    private String storeAddr;

    private String storeTel;

    private Integer cityid;

    private Integer operator;

    private Date operationTime;

    public TbStore(Integer id, String storeName, String storeAddr, String storeTel, Integer cityid, Integer operator, Date operationTime) {
        this.id = id;
        this.storeName = storeName;
        this.storeAddr = storeAddr;
        this.storeTel = storeTel;
        this.cityid = cityid;
        this.operator = operator;
        this.operationTime = operationTime;
    }

    public TbStore() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr == null ? null : storeAddr.trim();
    }

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel == null ? null : storeTel.trim();
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}