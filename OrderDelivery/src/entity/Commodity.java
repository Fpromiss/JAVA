package entity;

/**
 * @author : Fpromiss
 *
 * 商品类
 */
public class Commodity {

    private int id; // 商品id
    private String commodityNumber; // 商品编号
    private String name; // 商品名称
    private double weight; // 商品重量
    private double length; // 商品长度
    private double width; // 商品宽度
    private double height; // 商品高度
    private int depotId; // 仓库id
    private int stock; // 商品在仓库的库存


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(String commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getDepotId() {
        return depotId;
    }

    public void setDepotId(int depotId) {
        this.depotId = depotId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void printCommodity(){
        System.out.println("id:" + id + " commodityNumber:" + commodityNumber + " name:" + name + " length:" + length
                + " width:" + width + " height:" + height + " weight:" + weight + " depotId:" + depotId + " stock:" + stock);
    }
}
