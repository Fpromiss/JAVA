package dealMode;

import entity.Commodity;
import entity.Depot;
import entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * �ֿ������
 */
public class DepotDelivery extends Delivery {

    /**
     * ��order ���䵽��ÿ����Ʒ����Ĳֿ���ȥ
     *
     * @param : order : ����
     * @return Map<Integer, List<Commodity>> : key Ϊ �ֿ�id ,List<Commodity> Ϊ���䵽�òֿ��е���Ʒ
     */
    public Map<Integer, List<Commodity>> deliveryToDepot(Order order, List<Depot> depotList){
        Map<Integer, List<Commodity>> listMap = new HashMap<Integer, List<Commodity>>();

        List<Commodity> depot1 = new ArrayList<Commodity>();
        List<Commodity> depot2 = new ArrayList<Commodity>();
        List<Commodity> depot3 = new ArrayList<Commodity>();
        int minDistanceDepotID = -1; // ��¼��ǰ��ƷӦ�����ĸ��ֿⷢ��

        for(Commodity commodity : order.getCommodities()){
            double minDistance = Integer.MAX_VALUE; // �����ƽ����Сֵ
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
