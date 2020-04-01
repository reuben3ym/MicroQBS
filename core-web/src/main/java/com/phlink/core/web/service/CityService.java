package com.phlink.core.web.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phlink.core.web.entity.City;

public interface CityService extends IService<City> {
    List<City> listByProvinceId(String provinceId);
}
