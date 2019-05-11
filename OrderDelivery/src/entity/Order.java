package entity;

import java.util.Date;
import java.util.List;

/**
 * @author : Fpromiss
 *
 * 订单类
 */
public class Order {

    private int id; // 订单id
    private String orderNumber; // 订单编号
    private Date orderDate; // 下单时间
    private String payType; // 支付方式
    private Date payDate; // 支付时间
    private String deliveryType; // 配送方式
    private String receiverName; // 收件人姓名
    private String telPhone; // 联系电话
    private double xAddress; // 地址x
    private double yAddress; // 地址y
    private List<Commodity> commodities; // 商品明细


    /**
     * 输出订单信息
     */
    public void printOrder(){
        System.out.println("id:" + id + " orderNumber:" + " payType:" + payType + " deliveryType:" + deliveryType
                    + " receiverName:" + receiverName + " xAddress:" + xAddress + " yAddress:" + yAddress
                    + " telPhone:" + telPhone);
        for(Commodity commodity : commodities){
            commodity.printCommodity();
        }
    }


    /**
     * 复制订单
     *
     * @return
     */
    public Order copy(){
        Order order = new Order();
        order.setId(id);
        order.setPayType(payType);
        order.setTelPhone(telPhone);
        order.setReceiverName(receiverName);
        order.setOrderNumber(orderNumber);
        order.setxAddress(xAddress);
        order.setyAddress(yAddress);
        order.setPayDate(payDate);
        order.setOrderDate(orderDate);
        order.setDeliveryType(deliveryType);
        return order;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
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

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }
}
