import com.csvreader.CsvWriter;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

public class ExcelWrite implements WriteFile {
    @Override
    public boolean writeFile(List<List<String>> result, String fileName) {
        try {
            // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);
            CsvWriter csvWriter = new CsvWriter("out.csv", ',', Charset.forName("GBK"));
            // 写内容
            String[] headers = {"part","content"};
            csvWriter.writeRecord(headers);
            String[] heads={"head",result.get(0).toString()};
            String[] bodys={"body",result.get(1).toString()};
            String[] ends={"end",result.get(2).toString()};
            csvWriter.writeRecord(heads);
            csvWriter.writeRecord(bodys);
            csvWriter.writeRecord(ends);
            csvWriter.close();
            System.out.println("Excel success!");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
