import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void initOrder(Order nowOrder){
        nowOrder.setId(1);
        nowOrder.setAddress("厦门大学");
        nowOrder.setDeliverType("顺丰");
        nowOrder.setName("订单一号");
        nowOrder.setNumber("20190521123456789");
        nowOrder.setPayType("支付宝");
        nowOrder.setTel("12345678910");
        nowOrder.setxAddress(123.456);
        nowOrder.setyAddress(456.789);
        nowOrder.setOrderDate(new Date());
        List<Commodity> commodities = new ArrayList<Commodity>();
        for(int i=0;i<3;i++){
            Commodity commodity = new Commodity();
            commodity.setId(i+1);
            commodity.setName("商品" + i+1 + "号");
            commodity.setPrice(100 + i + 1);
            commodities.add(commodity);
        }
        nowOrder.setCommodityList(commodities);
    }

    public static void main(String [] args){

        Order order = new Order();
        initOrder(order);

        System.out.println("写入txt：");

        OutOrderBuilder outOrderBuilder = new TXTBuilder();
        WriteFile write = new TXTWrite();
        write.writeFile(outOrderBuilder.getBuilder(order, order.getName(), order.getOrderDate()), "out.txt");

        System.out.println("写入Excel：");
        OutOrderBuilder outOrderBuilder1 = new ExcelBuilder();
        WriteFile write2 = new ExcelWrite();
        write2.writeFile(outOrderBuilder1.getBuilder(order, order.getName(), order.getOrderDate()), "out.xlsx");
    }

}
