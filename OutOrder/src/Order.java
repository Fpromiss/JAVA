import java.util.Date;
import java.util.List;

public class Order {

    private Integer id;
    private String number;
    private Date orderDate;
    private String payType;
    private String deliverType;
    private String name;
    private String tel;
    private String address;
    private double xAddress;
    private double yAddress;
    List<Commodity> commodityList;

    public String orderString(){
        return id + " " + number + " " + orderDate + " " + payType + " " + deliverType + " " + name + " "
                + tel + " " + address + " " + xAddress + " " + yAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(String deliverType) {
        this.deliverType = deliverType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getxAddress() {
        return xAddress;
    }

    public void setxAddress(double xAddress) {
        this.xAddress = xAddress;
    }

    public double getyAddress() {
        return yAddress;
    }

    public void setyAddress(double yAddress) {
        this.yAddress = yAddress;
    }

    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }
}
