import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TXTWrite implements WriteFile {

    @Override
    public boolean writeFile(List<List<String>> result, String fileName) {
        try {
            File writeName = new File(fileName); // ���·�������û����Ҫ����һ���µ�output.txt�ļ�
            writeName.createNewFile(); // �������ļ�,��ͬ�����ļ��Ļ�ֱ�Ӹ���
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                for(int i=0;i<result.size();i++){
                    for(int j=0;j<result.get(0).size();j++){
                        out.write(result.get(i).get(j));
                    }
                }
                out.flush(); // �ѻ���������ѹ���ļ�
                System.out.println("TXT success!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
