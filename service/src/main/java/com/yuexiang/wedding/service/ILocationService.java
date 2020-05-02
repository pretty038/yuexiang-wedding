package com.yuexiang.wedding.service;

import com.yuexiang.wedding.domain.form.LocationForm;
import com.yuexiang.wedding.domain.model.Area;

import java.util.Optional;

/**
 * @author GXN
 * @version ${version}
 * @createdDate 2019/4/12
 */
public interface ILocationService {



    //List<LocationVO> getUserLocationList(int userId);

    boolean addNewLocation(LocationForm locationForm);

    boolean updateLocation(LocationForm locationForm);

    boolean deleteLocation(int id);

    Optional<Area> getAreaLinkByChildId(int areaId);

}
