package com.service;

import com.dto.CampDTO;

import java.util.ArrayList;
import java.util.List;

public interface CampService {

    List<CampDTO> findByName(String name);

    List<CampDTO> findByRecommendation(CampDTO dto);

    List<CampDTO> printNameList(ArrayList<Integer> CIDs);

    List<CampDTO> printDetailByCID(int CID);
}
