package com.edu.mum.cs544.socialnetwork.socialnetwork.dao.Impl;

import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {

}
