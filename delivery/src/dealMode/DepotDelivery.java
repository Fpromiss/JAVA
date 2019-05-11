package dealMode;

import entity.Commodity;
import entity.Depot;
import entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 仓库分配类
 */
public class DepotDelivery extends Delivery {

    /**
     * 将order 分配到离每个商品最近的仓库中去
     *
     * @param : order : 订单
     * @return Map<Integer, List<Commodity>> : key 为 仓库id ,List<Commodity> 为分配到该仓库中的商品
     */
    public Map<Integer, List<Commodity>> deliveryToDepot(Order order, List<Depot> depotList){
        Map<Integer, List<Commodity>> listMap = new HashMap<Integer, List<Commodity>>();

        List<Commodity> depot1 = new ArrayList<Commodity>();
        List<Commodity> depot2 = new ArrayList<Commodity>();
        List<Commodity> depot3 = new ArrayList<Commodity>();
        int minDistanceDepotID = -1; // 记录当前商品应该由哪个仓库发货

        for(Commodity commodity : order.getCommodities()){
            double minDistance = Integer.MAX_VALUE; // 距离的平方最小值
            for(Depot depot : depotList){
                if(depot.containsCommodity(commodity)){
                    double dis = (depot.getxAddress() - order.getxAddress())*(depot.getxAddress() - order.getxAddress())
                            + (depot.getyAddress() - order.getyAddress())*(depot.getyAddress() - order.getyAddress());
                    if(dis < minDistance){
                        minDistance = dis;
                        minDistanceDepotID = depot.getId();
                    }
                }
            }
            if(minDistanceDepotID == 1){
                depot1.add(commodity);
            }else if(minDistanceDepotID == 2){
                depot2.add(commodity);
            }else{
                depot3.add(commodity);
            }
        }

        if(depot1.size()>0){
            listMap.put(1, depot1);
        }
        if(depot2.size()>0){
            listMap.put(2, depot2);
        }
        if(depot3.size()>0){
            listMap.put(3, depot3);
        }

        for(Map.Entry<Integer, List<Commodity>> tmp : listMap.entrySet()){
            System.out.println("key:" + tmp.getKey());
            for(Commodity commodity : tmp.getValue()){
                commodity.printCommodity();
            }
        }

        return listMap;
    }

}
