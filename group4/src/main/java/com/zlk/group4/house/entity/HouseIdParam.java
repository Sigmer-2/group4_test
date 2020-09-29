package com.zlk.group4.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zhc
 * @time: 2020/9/28 17:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseIdParam {
    private List<Integer> ids;
}
