import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TXTBuilder extends OutOrderBuilder {

    @Override
    public List<String> headerBuilder(Order order) {
        List<String> header = new ArrayList<String>();
        header.add(order.orderString());
        return header;
    }

    @Override
    public List<String> bodyBuilder(Order order) {
        List<String> body = new ArrayList<String>();

        List<Commodity> commodities = order.getCommodityList();
        for(int i=0;i<commodities.size();i++){
            body.add(commodities.get(i).toString());
        }

        return body;
    }

    @Override
    public List<String> lastBuilder(String name, Date date) {
        String temp = name + date.toString();
        List<String> last = new ArrayList<String>();
        last.add(temp);
        return last;
    }

    @Override
    public List<List<String> > getBuilder(Order order, String name, Date date) {

        List<String> header = headerBuilder(order);
        List<String> body = bodyBuilder(order);
        List<String> last = lastBuilder(name, date);
        List<String> all = new ArrayList<String>();

        all.addAll(header);
        all.addAll(body);
        all.addAll(last);

        List<List<String> > result = new ArrayList<List<String>>();
        result.add(all);
        return result;
    }
}
