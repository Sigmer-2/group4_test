package com.zlk.group4.area.entity;

public class Area {
    /**区域编号*/
    private Integer id;
    /**区域名称*/
    private String areaName;

    public Area() {
    }

    public Area(Integer id, String areaName) {
        this.id = id;
        this.areaName = areaName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
