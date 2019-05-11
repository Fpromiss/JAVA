package dealMode;

import entity.Commodity;
import entity.Depot;
import entity.Order;

import java.util.List;
import java.util.Map;


/**
 * @author : Fpromiss
 *
 * 具体划分包裹类
 */
public class Delivery {


    /**
     * 订单拆分
     *
     * @param order ： 订单拆分
     * @return
     */
    public List<Order> deliveryOrder(Order order, List<Depot> depotList){
        DepotDelivery depotDelivery = new DepotDelivery();
        OrderDelivery orderDelivery = new OrderDelivery();
        return orderDelivery.getPackage(depotDelivery.deliveryToDepot(order, depotList), order);
    }

    /**
     * 将order 分配到离每个商品最近的仓库中去
     *
     * @param : order : 订单
     * @return Map<Integer, List<Commodity>> : key 为 仓库id ,List<Commodity> 为分配到该仓库中的商品
     */
    public Map<Integer, List<Commodity>> deliveryToDepot(Order order, List<Depot> depotList){
        return null;
    }


    /**
     * 将每个仓库中的所属商品进行订单划分
     *
     * @param packageMap : key 为 仓库id ,List<Commodity> 为分配到该仓库中的商品
     * @param order : 初始订单（用于原型copy）
     * @return
     */
    public List<Order> getPackage(Map<Integer, List<Commodity>> packageMap, Order order) {
        return null;
    }

}
