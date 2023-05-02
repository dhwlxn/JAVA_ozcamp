package com.service;

import com.dto.CampDTO;

import java.util.ArrayList;
import java.util.List;

public interface CampService {

    List<CampDTO> findByName(String name);


    CampDTO printDetailByCID(int CID);
}
