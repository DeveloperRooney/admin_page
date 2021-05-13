package com.sh.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String email;

    private String phone;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    
    // 1 : N 
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // mappedBy 에서 어느 변수와 연결시킬 것인지 지정
    private List<OrderDetail> orderDetailList;

}
