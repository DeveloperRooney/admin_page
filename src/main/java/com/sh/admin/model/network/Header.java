package com.sh.admin.model.network;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;

@Data
@NoArgsConstructor
@DenyAll
@Builder
public class Header {

    // api 통신시간
    private String transactionTime;

    // api 응답 코드
    private String resultCode;

    // api 부가 설명
    private String description;
}
