package com.example.postDe.postDemo2.Dto.Response;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor

public class nuserResponse {

    private String nname;
    private String nemail;
    private String naddress;
}
