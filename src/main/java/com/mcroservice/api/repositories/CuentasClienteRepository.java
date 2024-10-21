package com.mcroservice.api.repositories;

import com.mcroservice.api.responses.CuentasClienteResp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CuentasClienteRepository extends JpaRepository<CuentasClienteResp, Integer> {
	
    @Query(value = "SELECT * FROM public.getCuentas()", nativeQuery = true)
    List<CuentasClienteResp> findCuentasActivas();

}