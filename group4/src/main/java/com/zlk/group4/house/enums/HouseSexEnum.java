package com.zlk.group4.house.enums;



/**
 * Created with IntelliJ IDEA.
 * Description:住房租客性别，0：男女不限；1：男；2：女
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 9:34
 */
public enum HouseSexEnum {
    UNKNOW(0,"男女均可"),MALE(1,"仅限男"),FEMALE(2, "仅限女");
    private int code;
    private  String desc;

    HouseSexEnum(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public static HouseSexEnum getHouseSex(Integer code){
        if (code == null){
            return UNKNOW;
        }
        for (HouseSexEnum houseSexEnum : HouseSexEnum.values()){
            if (houseSexEnum.getCode() == code){
                return houseSexEnum;
            }
        }
        return UNKNOW;
    }

    public static HouseSexEnum getHouseSex(String code){
        if (code == null){
            return UNKNOW;
        }
        if ("限男生".equals(code)){
            return MALE;
        }
        if ("限女生".equals(code)){
            return FEMALE;
        }
        return UNKNOW;
    }


    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
