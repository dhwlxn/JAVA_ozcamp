package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistDTO {
    int CAMPER_CUID;
    int CAMP_CID;
    String name;
    String address;

    public WishlistDTO(int cAMPER_CUID, int cAMP_CID) {
        super();
        CAMPER_CUID = cAMPER_CUID;
        CAMP_CID = cAMP_CID;
        this.name=null;
        this.address=null;
    }


}
