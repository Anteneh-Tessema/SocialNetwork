package com.edu.mum.cs544.socialnetwork.socialnetwork.service;

import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Advertisement;

import java.util.List;

public interface IAdvertisementService {

    //Page <Advertisement> getAllAdvertisementPaged(int pageNo);
    List<Advertisement> getAllAdvertisementList();
    Advertisement getAdvertisementById(Long id);
    void deleteAdvertisementById(Long id);
    Advertisement saveAdvertisement(Advertisement advertisement);

}
