import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void initOrder(Order nowOrder){
        nowOrder.setId(1);
        nowOrder.setAddress("���Ŵ�ѧ");
        nowOrder.setDeliverType("˳��");
        nowOrder.setName("����һ��");
        nowOrder.setNumber("20190521123456789");
        nowOrder.setPayType("֧����");
        nowOrder.setTel("12345678910");
        nowOrder.setxAddress(123.456);
        nowOrder.setyAddress(456.789);
        nowOrder.setOrderDate(new Date());
        List<Commodity> commodities = new ArrayList<Commodity>();
        for(int i=0;i<3;i++){
            Commodity commodity = new Commodity();
            commodity.setId(i+1);
            commodity.setName("��Ʒ" + i+1 + "��");
            commodity.setPrice(100 + i + 1);
            commodities.add(commodity);
        }
        nowOrder.setCommodityList(commodities);
    }

    public static void main(String [] args){

        Order order = new Order();
        initOrder(order);

        System.out.println("д��txt��");

        OutOrderBuilder outOrderBuilder = new TXTBuilder();
        WriteFile write = new TXTWrite();
        write.writeFile(outOrderBuilder.getBuilder(order, order.getName(), order.getOrderDate()), "out.txt");

        System.out.println("д��Excel��");
        OutOrderBuilder outOrderBuilder1 = new ExcelBuilder();
        WriteFile write2 = new ExcelWrite();
        write2.writeFile(outOrderBuilder1.getBuilder(order, order.getName(), order.getOrderDate()), "out.xlsx");
    }

}
