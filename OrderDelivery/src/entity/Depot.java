package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Fpromiss
 *
 * 仓库类
 */
public class Depot {

    private int id; // 仓库id
    private List<Commodity> commodityList; // 仓库中商品
    private double xAddress; // 仓库地址x
    private double yAddress; // 仓库地址y

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }

    public double getxAddress() {
        return xAddress;
    }

    public void setxAddress(double xAddress) {
        this.xAddress = xAddress;
    }

    public double getyAddress() {
        return yAddress;
    }

    public void setyAddress(double yAddress) {
        this.yAddress = yAddress;
    }


    /**
     * 打印depot信息
     */
    public void printDepot(){
        System.out.println(" id:" + id + " xAddress:" + xAddress + " yAddress:" + yAddress + " ");
        for(Commodity commodity : commodityList){
            commodity.printCommodity();
        }
    }

    /**
     * 判断仓库是否有这个商品
     *
     * @param commodity
     * @return
     */
    public boolean containsCommodity(Commodity commodity){
        for(Commodity tmp :commodityList){
            if(tmp.getName().equals(commodity.getName()) && tmp.getStock()>0){
                return true;
            }
        }
        return false;
    }
}
