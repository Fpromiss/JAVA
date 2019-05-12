/**
 * @author mnmlist@163.com
 * @date 2015/09/26
 * @time 22:24
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class VehicleRoutingProblem {
    static int max = 101;
    static int maxqvehicle = 1024;
    static int maxdvehicle = 1024;
    Random ra = new Random();
    int K;// ���ʹ�ó���Ŀ
    int KK;// ʵ��ʹ�ó���
    int clientNum;// �ͻ���Ŀ,Ⱦɫ�峤��
    double punishWeight;// W1, W2, W3;//�ͷ�Ȩ��
    double crossRate, mutationRate;// ������ʺͱ������
    int populationScale;// ��Ⱥ��ģ
    int T;// ��������
    int t;// ��ǰ����
    int[] bestGhArr;// ���д�������õ�Ⱦɫ��
    double[] timeGhArr;// ���д�������õ�Ⱦɫ��
    double bestFitness;// ���д�������õ�Ⱦɫ�����Ӧ��
    int bestGenerationNum;// ��õ�Ⱦɫ����ֵĴ���
    double decodedEvaluation;// ��������г�������·���ܺ͡�
    double[][] vehicleInfoMatrix;// K�±��1��ʼ��K��0�б�ʾ���������������1�б�ʾ����ʻ�������룬2�б�ʾ�ٶ�
    int[] decodedArr;// Ⱦɫ���������ÿ�����ķ���Ŀͻ���˳��
    double[][] distanceMatrix;// �ͻ�����
    double[] weightArr;// �ͻ�������
    int[][] oldMatrix;// ��ʼ��Ⱥ��������Ⱥ��������ʾ��Ⱥ��ģ��һ�д���һ�����壬��Ⱦɫ�壬�б�ʾȾɫ�����Ƭ��
    int[][] newMatrix;// �µ���Ⱥ���Ӵ���Ⱥ
    double[] fitnessArr;// ��Ⱥ��Ӧ�ȣ���ʾ��Ⱥ�и����������Ӧ��
    double[] probabilityArr;// ��Ⱥ�и���������ۼƸ���
    double[] x1;
    double[] y1;

    /**
     * ��ʼ������
     */
    void initData() {
        int i, j;
        decodedEvaluation = 0;// ��������г�������·���ܺ�
        punishWeight = 300;// ��������ͷ�Ȩ��
        clientNum = 20;// �ͻ���Ŀ,Ⱦɫ�峤��
        K = 5;// �����Ŀ
        populationScale = 100;// ��Ⱥ��ģ
        crossRate = 0.9;// �������
        mutationRate = 0.09;// ������ʣ�ʵ��Ϊ(1-Pc)*0.9=0.09
        T = 3000;// ��������
        bestFitness = 0;// ���д�������õ�Ⱦɫ�����Ӧ��
        vehicleInfoMatrix = new double[K
                + 2][3];// K�±��1��ʼ��K��0�б�ʾ���������������1�б�ʾ����ʻ�������룬2�б�ʾ�ٶ�
        bestGhArr = new int[clientNum];// ���д�������õ�Ⱦɫ��
        timeGhArr = new double[clientNum];// ���д�������õ�Ⱦɫ��
        decodedArr = new int[clientNum];// Ⱦɫ���������ÿ�����ķ���Ŀͻ���˳��
        distanceMatrix = new double[clientNum + 1][clientNum + 1];// �ͻ�����
        weightArr = new double[clientNum + 1];// �ͻ�������
        oldMatrix = new int[populationScale][clientNum];// ��ʼ��Ⱥ��������Ⱥ��������ʾ��Ⱥ��ģ��һ�д���һ�����壬��Ⱦɫ�壬�б�ʾȾɫ�����Ƭ��
        newMatrix = new int[populationScale][clientNum];// �µ���Ⱥ���Ӵ���Ⱥ
        fitnessArr = new double[populationScale];// ��Ⱥ��Ӧ�ȣ���ʾ��Ⱥ�и����������Ӧ��
        probabilityArr = new double[populationScale];// ��Ⱥ�и���������ۼƸ���
        x1 = new double[clientNum + 1];
        y1 = new double[clientNum + 1];

        // ��ȡ����������غ������ʻ
        String pathname = "car.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // ����һ�����������ļ�����ת�ɼ�����ܶ���������
        ) {
            String line;
            int count = 1;
            while (((line = br.readLine()) != null) && count<=5) {
                String[] datas = line.split(" ");
                vehicleInfoMatrix[count][0] = Double.valueOf(datas[0]);
                vehicleInfoMatrix[count][1] = Double.valueOf(datas[1]);
                count ++ ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        vehicleInfoMatrix[6][0] = maxqvehicle;// �������
        vehicleInfoMatrix[6][1] = maxdvehicle;

        // ��ȡ�ͻ�����
        pathname = "custom.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // ����һ�����������ļ�����ת�ɼ�����ܶ���������
        ) {
            String line;
            int count = 0;
            while (((line = br.readLine()) != null) && count<=20) {
                String[] datas = line.split(" ");
                x1[count] = Double.valueOf(datas[0]);
                y1[count] = Double.valueOf(datas[1]);
                weightArr[count] = Double.valueOf(datas[2]);
                count ++ ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double x = 0, y = 0;
        // �ͻ�֮�����
        int endIndex = clientNum + 1;
        for (i = 0; i < endIndex; i++) {
            for (j = 0; j < endIndex; j++) {
                x = x1[i] - x1[j];
                y = y1[i] - y1[j];
                distanceMatrix[i][j] = Math.sqrt(x * x + y * y);
            }
        }

    }


    /**
     * Ⱦɫ�����ۺ���������һ��Ⱦɫ�壬�õ���Ⱦɫ������ֵ
     *
     * @param Gh
     * @return
     */
    double caculateFitness(int[] Gh) {
        // Ⱦɫ����±�0��ʼ��L-1��
        int i, j;// i���ı�ţ�j�ͻ����
        int flag;// ����ʹ�õĳ���
        double cur_d, cur_q, evaluation;// ��ǰ������ʻ���룬������������ֵ����������ʻ�����

        cur_d = distanceMatrix[0][Gh[0]];// Gh[0]��ʾ��һ���ͻ���
        cur_q = weightArr[Gh[0]];

        i = 1;// ��1�ų���ʼ��Ĭ�ϵ�һ�����������һ���ͻ�������
        evaluation = 0;// ����ֵ��ʼΪ0
        flag = 0;// ��ʾ������δ����

        for (j = 1; j < clientNum; j++) {
            cur_q = cur_q + weightArr[Gh[j]];
            cur_d = cur_d + distanceMatrix[Gh[j]][Gh[j - 1]];

            // �����ǰ�ͻ�������ڳ���������أ����߾�����ڳ���ʻ�����룬������һ����
            if (cur_q > vehicleInfoMatrix[i][0]
                    || cur_d + distanceMatrix[Gh[j]][0]
                    > vehicleInfoMatrix[i][1])// ���ü��Ϸ����������ľ���
            {
                i = i + 1;// ʹ����һ����
                evaluation =
                        evaluation + cur_d - distanceMatrix[Gh[j]][Gh[j - 1]]
                                + distanceMatrix[Gh[j - 1]][0];
                cur_d = distanceMatrix[0][Gh[j]];// ���������ĵ���ǰ�ͻ�j����
                cur_q = weightArr[Gh[j]];
            }
        }
        evaluation = evaluation + cur_d + distanceMatrix[Gh[clientNum
                - 1]][0];// �������һ�����ߵľ���
        flag = i - K;// ������ʹ����Ŀ�Ƿ���ڹ涨���������ֻ��һ����
        if (flag < 0)
            flag = 0;// �������򲻳ͷ�

        evaluation = evaluation + flag * punishWeight;// ��������Գͷ�Ȩ��
        return 10 / evaluation;// ѹ������ֵ

    }


    /**
     * Ⱦɫ����뺯��������һ��Ⱦɫ�壬�õ���Ⱦɫ�����ÿ�����ķ���Ŀͻ���˳��
     *
     * @param Gh
     */
    void decoding(int[] Gh) {
        // Ⱦɫ����±�0��ʼ��L-1��
        int i, j;// i���ı�ţ�j�ͻ����
        double cur_d, cur_q, evaluation;// ��ǰ������ʻ���룬������������ֵ����������ʻ�����
        cur_d = distanceMatrix[0][Gh[0]];// Gh[0]��ʾ��һ���ͻ���
        cur_q = weightArr[Gh[0]];
        i = 1;// ��1�ų���ʼ��Ĭ�ϵ�һ�����������һ���ͻ�������
        decodedArr[i] = 1;
        evaluation = 0;
        for (j = 1; j < clientNum; j++) {
            cur_q = cur_q + weightArr[Gh[j]];
            cur_d = cur_d + distanceMatrix[Gh[j]][Gh[j - 1]];
            // �����ǰ�ͻ�������ڳ���������أ����߾�����ڳ���ʻ�����룬������һ����
            if (cur_q > vehicleInfoMatrix[i][0]
                    || cur_d + distanceMatrix[Gh[j]][0]
                    > vehicleInfoMatrix[i][1]) {
                i = i + 1;// ʹ����һ����
                decodedArr[i] = decodedArr[i - 1] + 1;//
                evaluation =
                        evaluation + cur_d - distanceMatrix[Gh[j]][Gh[j - 1]]
                                + distanceMatrix[Gh[j - 1]][0];
                cur_d = distanceMatrix[0][Gh[j]];// ���������ĵ���ǰ�ͻ�j����
                cur_q = weightArr[Gh[j]];
            } else {
                decodedArr[i] = decodedArr[i] + 1;//
            }
        }
        decodedEvaluation = evaluation + cur_d + distanceMatrix[Gh[clientNum
                - 1]][0];// �������һ�����ߵľ���
        KK = i;

    }

    // ��ʼ����Ⱥ
    void initGroup() {
        int i, k;
        int randomNum = 0;
        for (k = 0; k < populationScale; k++)// ��Ⱥ��
        {
            for (i = 0; i < clientNum; i++)
                oldMatrix[k][i] = i + 1;
            for (i = 0; i < clientNum; i++) {
                randomNum = ra.nextInt(clientNum);
                swap(oldMatrix[k], i, randomNum);
            }
        }
    }


    /**
     * ����
     *
     * @param arr
     * @param index1
     * @param index2
     */
    public void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    /**
     * ������Ⱥ�и���������ۻ����ʣ�ǰ�����Ѿ�����������������Ӧ��Fitness[max]����Ϊ����ѡ�����һ���֣�Pi[max]
     */
    void countRate() {
        int k;
        double sumFitness = 0;// ��Ӧ���ܺ�

        for (k = 0; k < populationScale; k++) {
            sumFitness += fitnessArr[k];
        }

        // ������������ۼƸ���
        probabilityArr[0] = fitnessArr[0] / sumFitness;
        for (k = 1; k < populationScale; k++) {
            probabilityArr[k] =
                    fitnessArr[k] / sumFitness + probabilityArr[k - 1];
        }
    }


    /**
     * ����Ⱦɫ�壬k��ʾ��Ⱦɫ������Ⱥ�е�λ�ã�kk��ʾ�ɵ�Ⱦɫ������Ⱥ�е�λ��
     *
     * @param k
     * @param kk
     */
    void copyChrosome(int k, int kk) {
        System.arraycopy(oldMatrix[kk], 0, newMatrix[k], 0, clientNum);
    }


    /**
     * ��ѡĳ����Ⱥ����Ӧ����ߵĸ��壬ֱ�Ӹ��Ƶ��Ӵ��У�ǰ�����Ѿ�����������������Ӧ��Fitness[max]
     */
    void selectBestChrosome() {
        int k, maxid;
        double maxevaluation;
        maxid = 0;
        maxevaluation = fitnessArr[0];
        for (k = 1; k < populationScale; k++) {
            if (maxevaluation < fitnessArr[k]) {
                maxevaluation = fitnessArr[k];
                maxid = k;
            }
        }

        if (bestFitness < maxevaluation) {
            bestFitness = maxevaluation;
            bestGenerationNum = t;// ��õ�Ⱦɫ����ֵĴ���;
            System.arraycopy(oldMatrix[maxid], 0, bestGhArr, 0, clientNum);
        }
        // ����Ⱦɫ�壬k��ʾ��Ⱦɫ������Ⱥ�е�λ�ã�kk��ʾ�ɵ�Ⱦɫ������Ⱥ�е�λ��
        copyChrosome(0, maxid);// ��������Ⱥ����Ӧ����ߵ�Ⱦɫ��k���Ƶ�����Ⱥ�У����ڵ�һλ0
    }


    /**
     * ���������
     *
     * @return
     */
    int select() {
        int k;
        double ran1;
        ran1 = Math.abs(ra.nextDouble());
        for (k = 0; k < populationScale; k++) {
            if (ran1 <= probabilityArr[k]) {
                break;
            }
        }
        return k;
    }


    /**
     * ��OX��������
     */
    void oxCrossover(int k1, int k2) {
        int i, j, k, flag;
        int ran1, ran2, temp;
        int[] Gh1 = new int[clientNum];
        int[] Gh2 = new int[clientNum];
        ran1 = ra.nextInt(clientNum);
        ran2 = ra.nextInt(clientNum);
        while (ran1 == ran2)
            ran2 = ra.nextInt(clientNum);
        if (ran1 > ran2)// ȷ��ran1<ran2
        {
            temp = ran1;
            ran1 = ran2;
            ran2 = temp;
        }
        flag = ran2 - ran1 + 1;// ɾ���ظ�����ǰȾɫ�峤��

        for (i = 0, j = ran1; i < flag; i++, j++) {
            Gh1[i] = newMatrix[k2][j];
            Gh2[i] = newMatrix[k1][j];
        }
        // �ѽ���ֵi=ran2-ran1������
        for (k = 0, j = flag; j < clientNum; j++)// Ⱦɫ�峤��
        {
            i = 0;
            while (i != flag) {
                Gh1[j] = newMatrix[k1][k++];
                i = 0;
                while (i < flag && Gh1[i] != Gh1[j])
                    i++;
            }
        }

        for (k = 0, j = flag; j < clientNum; j++)// Ⱦɫ�峤��
        {
            i = 0;
            while (i != flag) {
                Gh2[j] = newMatrix[k2][k++];
                i = 0;
                while (i < flag && Gh2[i] != Gh2[j])
                    i++;
            }
        }
        System.arraycopy(Gh1, 0, newMatrix[k1], 0, clientNum);
        System.arraycopy(Gh2, 0, newMatrix[k2], 0, clientNum);
    }

    // ����Ⱥ�еĵ�k��Ⱦɫ����б���
    void mutation(int k) {
        int ran1, ran2;
        ran1 = ra.nextInt(clientNum);
        ran2 = ra.nextInt(clientNum);
        while (ran1 == ran2)
            ran2 = ra.nextInt(clientNum);
        swap(newMatrix[k], ran1, ran2);

    }

    // ������������������
    void evolution() {
        int k, selectId;
        double r;// ����0С��1�������
        // ��ѡĳ����Ⱥ����Ӧ����ߵĸ���
        selectBestChrosome();
        // ����ѡ�������ѡscale-1����һ������
        for (k = 1; k < populationScale; k++) {
            selectId = select();
            copyChrosome(k, selectId);
        }
        for (k = 1; k + 1 < populationScale / 2; k = k + 2) {
            r = Math.abs(ra.nextDouble());
            // crossover
            if (r < crossRate) {
                oxCrossover(k, k + 1);// ���н���
            } else {
                r = Math.abs(ra.nextDouble());
                if (r < mutationRate) {
                    mutation(k);
                }
                r = Math.abs(ra.nextDouble());
                if (r < mutationRate) {
                    mutation(k + 1);
                }
            }
        }
        if (k == populationScale / 2 - 1)// ʣ���һ��Ⱦɫ��û�н���L-1
        {
            r = Math.abs(ra.nextDouble());
            if (r < mutationRate) {
                mutation(k);
            }
        }

    }

    /**
     * ��ȡ���Ž��
     *
     * @return �����Ž��
     */
    public BestResult solveVrp() {
        int i, j, k;
        BestResult bestResult = new BestResult();
        // ��ʼ�����ݣ���ͬ�����ʼ�����ݲ�һ��
        initData();

        // ��ʼ����Ⱥ
        initGroup();
        int[] tempGA = new int[clientNum];

        // �����ʼ����Ⱥ��Ӧ�ȣ�Fitness[max]
        for (k = 0; k < populationScale; k++) {
            for (i = 0; i < clientNum; i++) {
                tempGA[i] = oldMatrix[k][i];
            }

            fitnessArr[k] = caculateFitness(tempGA);
        }

        // �����ʼ����Ⱥ�и���������ۻ����ʣ�Pi[max]
        countRate();
        for (t = 0; t < T; t++) {
            evolution();// ������������������
            // ������ȺnewMatrix���Ƶ�����ȺoldMatrix�У�׼����һ������
            for (k = 0; k < populationScale; k++)
                System.arraycopy(newMatrix[k], 0, oldMatrix[k], 0, clientNum);
            // ������Ⱥ��Ӧ�ȣ�Fitness[max]
            for (k = 0; k < populationScale; k++) {
                System.arraycopy(oldMatrix[k], 0, tempGA, 0, clientNum);
                fitnessArr[k] = caculateFitness(tempGA);
            }
            // ������Ⱥ�и���������ۻ����ʣ�Pi[max]
            countRate();
            // ������
        }
        // �����Ⱥ
        //		System.out.println("//////////////////////////////////");
        //		for (k = 0; k < populationScale; k++)
        //			System.out.println(Arrays.toString(oldMatrix[k]));
        //		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\t");
        // ���ִ���
        System.out.println("��õĴ��������ڣ�" + bestGenerationNum + "��");
        // Ⱦɫ������ֵ
        System.out.println("��ʻ�����Ϊ��" + (10 / bestFitness));
        // ��õ�Ⱦɫ�����
        decoding(bestGhArr);
        // ʹ�ó���
        System.out.println("ʹ�ó�����" + KK);
        // ����
        String tefa = "";
        int tek;
        int[] templ = new int[max];

        for (i = 1; i <= KK; i++) {

            templ[1] = 0;
            tefa = "0-";
            tek = decodedArr[i - 1];
            for (j = tek, k = 2; j < decodedArr[i]; j++, k++) {
                tefa = tefa + bestGhArr[j] + "-";
                templ[k] = bestGhArr[j];
            }
            templ[k] = 0;
            templ[0] = k;
            tefa = tefa + "0";
            System.out.println("��" + i + "������ʻ·��Ϊ:" + tefa);
        }
        bestResult.setBestFitness(10 / bestFitness);
        bestResult.setBestGenerationNum(bestGenerationNum);
        return bestResult;
    }

    public static void main(String[] args) {
        VehicleRoutingProblem vehicleRoutingProblem = new VehicleRoutingProblem();
        int count = 50;
        double generationNum = 0;
        double totalFitness = 0;
        BestResult bestResult = null;
        for (int i = 0; i < count; i++) {
            System.out.println(
                    "/////////the " + (i + 1) + "iteration start...////////");
            bestResult = vehicleRoutingProblem.solveVrp();
            totalFitness += bestResult.getBestFitness();
            generationNum += bestResult.getBestGenerationNum();
            System.out.println(
                    "/////////the " + (i + 1) + "iteration end...////////");
            System.out.println();
        }
        System.out.println("ƽ���ڵ�" + (generationNum / count) + "���ҵ����н⡣");
        System.out.println("ƽ����·��Ϊ��" + (totalFitness / count));

    }

}

class BestResult {
    private double bestFitness;
    private int bestGenerationNum;

    public int getBestGenerationNum() {
        return bestGenerationNum;
    }

    public void setBestGenerationNum(int bestGenerationNum) {
        this.bestGenerationNum = bestGenerationNum;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }
}