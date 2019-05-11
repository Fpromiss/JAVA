import dealMode.Delivery;
import entity.Commodity;
import entity.Depot;
import entity.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class main {


    public static void main(String[] args) {

        System.out.println("仓库:");
        // 生成仓库存储信息
        List<Depot> depotList = new ArrayList<Depot>();
        depotList = initDepot();
        for (Depot depot : depotList) {
            depot.printDepot();
        }

        System.out.println("订单:");
        // 生成订单
        Order order = generatorOrder();
        order.printOrder();

        System.out.println("拆分:");
        // 订单拆分
        Delivery delivery = new Delivery();
        // 获取拆分的订单
        List<Order> orders = delivery.deliveryOrder(order, depotList);

        System.out.println("订单");
        // 输出拆分后的订单
        for(Order order1 : orders){
            order1.printOrder();
        }
    }


    /**
     * 初始化仓库信息（包含五个仓库，每个仓库三件商品）
     *
     * @return
     */
    public static List<Depot> initDepot() {
        // 创建3个仓库
        List<Depot> depotList = new ArrayList<Depot>();
        Random random = new Random();

        for (int i = 1; i <= 3; i++) {
            Depot depot = new Depot();
            List<Commodity> commodityList = new ArrayList<Commodity>();
            // 仓库
            depot.setId(i);
            depot.setxAddress((double) (random.nextInt(10) + i));
            depot.setyAddress((double) (random.nextInt(10) + i));
            // 商品
            commodityList = generatorCommodity(i);
            depot.setCommodityList(commodityList);
            depotList.add(depot);
        }
        return depotList;
    }


    /**
     * 生成商品
     *
     * @param i ：第i个仓库
     * @return
     */
    public static List<Commodity> generatorCommodity(int i) {
        List<Commodity> commodityList = new ArrayList<Commodity>();
        Random random = new Random();
        // 商品
        for (int j = 1; j <= 3; j++) {
            Commodity commodity = new Commodity();
            commodity.setId(j);
            commodity.setCommodityNumber("仓库" + i + "商品" + j);
            commodity.setDepotId(i);
            commodity.setHeight(random.nextDouble());
            commodity.setLength(random.nextDouble());
            commodity.setWidth(random.nextDouble());
            commodity.setWeight(random.nextDouble()*10);
            commodity.setStock(random.nextInt(100));
            commodity.setName("商品" + j);
            commodityList.add(commodity);
        }
        return commodityList;
    }


    /**
     * 生成订单
     *
     * @return
     */
    public static Order generatorOrder() {
        Order order = new Order();
        Random random = new Random();
        order.setId(1);
        order.setDeliveryType("顺丰");
        order.setOrderDate(new Date());
        order.setOrderNumber(new Date().toString() + "Order" + random.nextInt(100));
        order.setPayDate(new Date());
        order.setReceiverName("Fpromiss");
        order.setTelPhone("12345678910");
        order.setxAddress((double) (random.nextInt(10)));
        order.setyAddress((double) (random.nextInt(10)));
        order.setPayType("支付宝");
        order.setCommodities(generatorCommodity(4));
        return order;
    }

}
