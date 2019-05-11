package dealMode;

import entity.Commodity;
import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author : Fpromiss
 * <p>
 * 订单拆分处理类
 */
public class OrderDelivery extends Delivery {

    /**
     * 将每个仓库中的所属商品进行订单划分
     *
     * @param packageMap : key 为 仓库id ,List<Commodity> 为分配到该仓库中的商品
     * @param order      : 初始订单（用于原型copy）
     * @return
     */
    public List<Order> getPackage(Map<Integer, List<Commodity>> packageMap, Order order) {
        List<Order> orderList = new ArrayList<Order>();
        Order newOrder = order.copy();
        newOrder.setId(newOrder.getId() + 1);
        int flag = 0; // 标记是否开启一个新的order
        double nowWeight = 0; // 当前重量
        double nowLength = 0; // 当前长度
        double nowWidth = 0; // 当前宽度
        double nowHeight = 0; // 当前高度
        int count = 1;
        // 处理每一个仓库
        for (Map.Entry<Integer, List<Commodity>> entry : packageMap.entrySet()) {
            // 处理仓库内商品的order拆分
            List<Commodity> commodityList = new ArrayList<Commodity>();
            for (Commodity commodity : entry.getValue()) {
                nowWeight = nowWeight + commodity.getWeight();
                nowLength = nowLength + commodity.getLength();
                nowHeight = nowHeight + commodity.getHeight();
                nowWidth = nowWidth + commodity.getWidth();
                if(nowWeight > 20.0 || nowLength > 1.5 || nowWidth > 1.5 || nowHeight > 1.5 || (nowHeight+nowLength)>1.5
                        || (nowHeight + nowWidth) >1.5 || (nowLength + nowWidth) >1.5){
                    flag =1;
                }else {
                    commodityList.add(commodity);
                }
                if (flag == 1) {
                    count = count +1;
                    flag = 0;
                    nowWeight = commodity.getWeight();
                    nowLength = commodity.getLength();
                    nowWidth = commodity.getWidth();
                    nowHeight = commodity.getHeight();
                    newOrder.setCommodities(commodityList);
                    commodityList = new ArrayList<Commodity>();
                    commodityList.add(commodity);
                    orderList.add(newOrder);
                    newOrder = order.copy();
                    newOrder.setId(newOrder.getId() + count);
                }
            }
            if(commodityList.size()>0){
                newOrder = order.copy();
                newOrder.setId(newOrder.getId() + count);
                newOrder.setCommodities(commodityList);
                orderList.add(newOrder);
            }
        }
        return orderList;
    }

}
