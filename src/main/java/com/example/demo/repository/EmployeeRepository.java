package com.example.demo.repository;

import com.example.demo.dto.EmpleadosRegionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value="",nativeQuery = true)
    List<EmpleadosRegionDto> obtenerEmpleadosPorRegion();

}
