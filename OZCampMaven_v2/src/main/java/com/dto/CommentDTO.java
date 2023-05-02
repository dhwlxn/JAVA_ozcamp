package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    int CAMPER_CUID;
    int CAMP_CID;
    int RID;
    String reply;
    String name;

    public CommentDTO(int cAMPER_CUID, int cAMP_CID, int RID) {
        super();
        CAMPER_CUID = cAMPER_CUID;
        CAMP_CID = cAMP_CID;
        this.RID = RID;
        this.reply = null;
        this.name = null;
    }

    public CommentDTO(int cAMPER_CUID, int cAMP_CID, int rID, String reply) {
        super();
        CAMPER_CUID = cAMPER_CUID;
        CAMP_CID = cAMP_CID;
        RID = rID;
        this.reply = reply;
        this.name = null;

    }
}
