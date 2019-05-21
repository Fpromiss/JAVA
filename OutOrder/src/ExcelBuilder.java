import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelBuilder extends OutOrderBuilder{

    @Override
    public List<String> headerBuilder(Order order){
        List<String> header = new ArrayList<String>();

        header.add(order.getId().toString());
        header.add(order.getName());
        header.add(order.getDeliverType());
        header.add(order.getPayType());
        header.add(order.getAddress());
        header.add(order.getNumber());
        header.add(order.getTel());
        header.add(order.getOrderDate().toString());
        header.add(String.valueOf(order.getxAddress()));
        header.add(String.valueOf(order.getyAddress()));

        return header;
    }

    @Override
    public  List<String> bodyBuilder(Order order){
        List<String> body = new ArrayList<String>();
        List<Commodity> commodities = order.getCommodityList();
        for(int i=0;i<commodities.size();i++){
            body.add(commodities.get(i).toString());
        }
        return body;
    }

    @Override
    public  List<String> lastBuilder(String name, Date date){
        String temp = name + date.toString();
        List<String> last = new ArrayList<String>();
        last.add(temp);
        return last;
    }

    @Override
    public  List<List<String> > getBuilder(Order order, String name, Date date) {
        List<String> all = new ArrayList<String>();
        List<String> header = headerBuilder(order);
        List<String> body = bodyBuilder(order);
        List<String> last = lastBuilder(name, date);

        List<List<String>> result = new ArrayList<List<String>>();
        result.add(header);
        result.add(body);
        result.add(last);

        return result;
    }

}
