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

        System.out.println("�ֿ�:");
        // ���ɲֿ�洢��Ϣ
        List<Depot> depotList = new ArrayList<Depot>();
        depotList = initDepot();
        for (Depot depot : depotList) {
            depot.printDepot();
        }

        System.out.println("����:");
        // ���ɶ���
        Order order = generatorOrder();
        order.printOrder();

        System.out.println("���:");
        // �������
        Delivery delivery = new Delivery();
        // ��ȡ��ֵĶ���
        List<Order> orders = delivery.deliveryOrder(order, depotList);

        System.out.println("����");
        // �����ֺ�Ķ���
        for(Order order1 : orders){
            order1.printOrder();
        }
    }


    /**
     * ��ʼ���ֿ���Ϣ����������ֿ⣬ÿ���ֿ�������Ʒ��
     *
     * @return
     */
    public static List<Depot> initDepot() {
        // ����3���ֿ�
        List<Depot> depotList = new ArrayList<Depot>();
        Random random = new Random();

        for (int i = 1; i <= 3; i++) {
            Depot depot = new Depot();
            List<Commodity> commodityList = new ArrayList<Commodity>();
            // �ֿ�
            depot.setId(i);
            depot.setxAddress((double) (random.nextInt(10) + i));
            depot.setyAddress((double) (random.nextInt(10) + i));
            // ��Ʒ
            commodityList = generatorCommodity(i);
            depot.setCommodityList(commodityList);
            depotList.add(depot);
        }
        return depotList;
    }


    /**
     * ������Ʒ
     *
     * @param i ����i���ֿ�
     * @return
     */
    public static List<Commodity> generatorCommodity(int i) {
        List<Commodity> commodityList = new ArrayList<Commodity>();
        Random random = new Random();
        // ��Ʒ
        for (int j = 1; j <= 3; j++) {
            Commodity commodity = new Commodity();
            commodity.setId(j);
            commodity.setCommodityNumber("�ֿ�" + i + "��Ʒ" + j);
            commodity.setDepotId(i);
            commodity.setHeight(random.nextDouble());
            commodity.setLength(random.nextDouble());
            commodity.setWidth(random.nextDouble());
            commodity.setWeight(random.nextDouble()*10);
            commodity.setStock(random.nextInt(100));
            commodity.setName("��Ʒ" + j);
            commodityList.add(commodity);
        }
        return commodityList;
    }


    /**
     * ���ɶ���
     *
     * @return
     */
    public static Order generatorOrder() {
        Order order = new Order();
        Random random = new Random();
        order.setId(1);
        order.setDeliveryType("˳��");
        order.setOrderDate(new Date());
        order.setOrderNumber(new Date().toString() + "Order" + random.nextInt(100));
        order.setPayDate(new Date());
        order.setReceiverName("Fpromiss");
        order.setTelPhone("12345678910");
        order.setxAddress((double) (random.nextInt(10)));
        order.setyAddress((double) (random.nextInt(10)));
        order.setPayType("֧����");
        order.setCommodities(generatorCommodity(4));
        return order;
    }

}
