package com.sh.admin.repository;

import com.sh.admin.AdminApplicationTests;
import com.sh.admin.model.entity.Partner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class PartnerRepositoryTest extends AdminApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    @Transactional
    public void create() {

        Partner partner = new Partner();

        partner.setName("파트너01");
        partner.setStatus("REGISTERED");
        partner.setAddress("서울시 강남구");
        partner.setCallCenter("070-0000-0000");
        partner.setPartnerNumber("010-1111-2222");
        partner.setBusinessNumber("123456789");
        partner.setCeoName("010-1111-2222");
        partner.setRegisteredAt(LocalDateTime.now());
        partner.setCreatedAt(LocalDateTime.now());
        partner.setCreatedBy("AdminServer");
        partner.setCategoryId(1L);

        partnerRepository.save(partner);


    }

    @Test
    public void read() {

        Optional<Partner> partner = partnerRepository.findById(1L);

        partner.ifPresent(c -> {
            System.out.println(c);
        });
    }
}
