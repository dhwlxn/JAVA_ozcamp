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

}
