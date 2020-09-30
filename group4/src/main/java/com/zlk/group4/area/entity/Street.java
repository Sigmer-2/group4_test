package com.zlk.group4.area.entity;

public class Street {
    /**自增id*/
    private Integer id;
    /**区域编号*/
    private Integer areaId;
    /**街道名称*/
    private String streetName;

    public Street() {
    }

    public Street(Integer id, Integer areaId, String streetName) {
        this.id = id;
        this.areaId = areaId;
        this.streetName = streetName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", areaId=" + areaId +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}
