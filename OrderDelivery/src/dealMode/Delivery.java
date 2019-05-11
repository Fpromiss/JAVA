package dealMode;

import entity.Commodity;
import entity.Depot;
import entity.Order;

import java.util.List;
import java.util.Map;


/**
 * @author : Fpromiss
 *
 * ���廮�ְ�����
 */
public class Delivery {


    /**
     * �������
     *
     * @param order �� �������
     * @return
     */
    public List<Order> deliveryOrder(Order order, List<Depot> depotList){
        DepotDelivery depotDelivery = new DepotDelivery();
        OrderDelivery orderDelivery = new OrderDelivery();
        return orderDelivery.getPackage(depotDelivery.deliveryToDepot(order, depotList), order);
    }

    /**
     * ��order ���䵽��ÿ����Ʒ����Ĳֿ���ȥ
     *
     * @param : order : ����
     * @return Map<Integer, List<Commodity>> : key Ϊ �ֿ�id ,List<Commodity> Ϊ���䵽�òֿ��е���Ʒ
     */
    public Map<Integer, List<Commodity>> deliveryToDepot(Order order, List<Depot> depotList){
        return null;
    }


    /**
     * ��ÿ���ֿ��е�������Ʒ���ж�������
     *
     * @param packageMap : key Ϊ �ֿ�id ,List<Commodity> Ϊ���䵽�òֿ��е���Ʒ
     * @param order : ��ʼ����������ԭ��copy��
     * @return
     */
    public List<Order> getPackage(Map<Integer, List<Commodity>> packageMap, Order order) {
        return null;
    }

}
