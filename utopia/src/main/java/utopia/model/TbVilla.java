package utopia.model;
import java.util.Date;

public class TbVilla {
    private Integer id;

    private Date operationTime;

    private Integer addUserid;

    private String villaName;

    private String villaPrice;

    private Integer storeid;

    private String imgpath;

    private String villaDescription;

    public TbVilla(Integer id, Date operationTime, Integer addUserid, String villaName, String villaPrice, Integer storeid, String imgpath) {
        this.id = id;
        this.operationTime = operationTime;
        this.addUserid = addUserid;
        this.villaName = villaName;
        this.villaPrice = villaPrice;
        this.storeid = storeid;
        this.imgpath = imgpath;
    }

    public TbVilla(Integer id, Date operationTime, Integer addUserid, String villaName, String villaPrice, Integer storeid, String imgpath, String villaDescription) {
        this.id = id;
        this.operationTime = operationTime;
        this.addUserid = addUserid;
        this.villaName = villaName;
        this.villaPrice = villaPrice;
        this.storeid = storeid;
        this.imgpath = imgpath;
        this.villaDescription = villaDescription;
    }

    public TbVilla() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Integer getAddUserid() {
        return addUserid;
    }

    public void setAddUserid(Integer addUserid) {
        this.addUserid = addUserid;
    }

    public String getVillaName() {
        return villaName;
    }

    public void setVillaName(String villaName) {
        this.villaName = villaName == null ? null : villaName.trim();
    }

    public String getVillaPrice() {
        return villaPrice;
    }

    public void setVillaPrice(String villaPrice) {
        this.villaPrice = villaPrice == null ? null : villaPrice.trim();
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public String getVillaDescription() {
        return villaDescription;
    }

    public void setVillaDescription(String villaDescription) {
        this.villaDescription = villaDescription == null ? null : villaDescription.trim();
    }
}