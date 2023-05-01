package com.service;

import com.dto.CampDTO;
import com.dto.LocationDTO;
import com.dto.OptionDTO;

import java.util.List;

public interface LocationService {
    LocationDTO findByDistrict(LocationDTO dto);
    List<CampDTO> findByOption(OptionDTO dto);
}
