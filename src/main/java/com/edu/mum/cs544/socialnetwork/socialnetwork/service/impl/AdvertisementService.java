package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;

import com.edu.mum.cs544.socialnetwork.socialnetwork.dao.Impl.AdvertisementRepository;
import com.edu.mum.cs544.socialnetwork.socialnetwork.dao.UserDao;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Advertisement;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.IAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdvertisementService implements IAdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private UserDao userDao;

    @Override
    public List<Advertisement> getAllAdvertisementList() {

        return advertisementRepository.findAll();
    }

    @Override
    public Advertisement getAdvertisementById(Long id) {
        return advertisementRepository.getOne(id);
    }

    @Override
    public void deleteAdvertisementById(Long id) {
        advertisementRepository.delete(id);
    }

    @Override
    public Advertisement saveAdvertisement(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }
}
