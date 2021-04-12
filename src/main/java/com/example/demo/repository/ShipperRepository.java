package com.example.demo.repository;

import com.example.demo.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

        List<Shipper> findByCompanyname(String companyname);

        @Query(value="select * from shippers where companyname like %?1%",nativeQuery = true)
        List<Shipper> listarTransportitasPorNombre(String companyname);
}
