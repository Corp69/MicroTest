package com.mcroservice.api.repositories;



import com.mcroservice.api.responses.CuentasAPagarResp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CuentasRepository extends JpaRepository<CuentasAPagarResp, Integer> {
	

    @Query(value = "SELECT * FROM public.getCuentasPorPAGAR(0.05, 360)", nativeQuery = true)
    List<CuentasAPagarResp> findCuentasPorPagar(Double tasa_interes, Integer dias_anio_comercial);

    
    
}