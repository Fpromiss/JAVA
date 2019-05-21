import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TXTWrite implements WriteFile {

    @Override
    public boolean writeFile(List<List<String>> result, String fileName) {
        try {
            File writeName = new File(fileName); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                for(int i=0;i<result.size();i++){
                    for(int j=0;j<result.get(0).size();j++){
                        out.write(result.get(i).get(j));
                    }
                }
                out.flush(); // 把缓存区内容压入文件
                System.out.println("TXT success!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
