package org.seckill.util.excel;

/**
 * Created by John Lee on 2017/7/19.
 */
//将Excel每一行数值转换为对象
public class InfoVo {

    private String code;
    private String name;
    private String date;
    private String money;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getMoney() {
        return money;
    }
    public void setMoney(String money) {
        this.money = money;
    }
}