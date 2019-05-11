package dealMode;

import entity.Commodity;
import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author : Fpromiss
 * <p>
 * ������ִ�����
 */
public class OrderDelivery extends Delivery {

    /**
     * ��ÿ���ֿ��е�������Ʒ���ж�������
     *
     * @param packageMap : key Ϊ �ֿ�id ,List<Commodity> Ϊ���䵽�òֿ��е���Ʒ
     * @param order      : ��ʼ����������ԭ��copy��
     * @return
     */
    public List<Order> getPackage(Map<Integer, List<Commodity>> packageMap, Order order) {
        List<Order> orderList = new ArrayList<Order>();
        Order newOrder = order.copy();
        newOrder.setId(newOrder.getId() + 1);
        int flag = 0; // ����Ƿ���һ���µ�order
        double nowWeight = 0; // ��ǰ����
        double nowLength = 0; // ��ǰ����
        double nowWidth = 0; // ��ǰ���
        double nowHeight = 0; // ��ǰ�߶�
        int count = 1;
        // ����ÿһ���ֿ�
        for (Map.Entry<Integer, List<Commodity>> entry : packageMap.entrySet()) {
            // ����ֿ�����Ʒ��order���
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
