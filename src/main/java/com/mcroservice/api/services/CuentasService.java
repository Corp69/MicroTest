package com.mcroservice.api.services;




import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mcroservice.api.repositories.CuentasRepository;
import com.mcroservice.api.responses.CuentasAPagarResp;

@Service
public class CuentasService {
	
    @Autowired
    private CuentasRepository cuentasRepository;

    public List<CuentasAPagarResp> getCuentasPorPagar(Double tasa_interes, Integer dias_anio_comercial) {
        return cuentasRepository.findCuentasPorPagar(tasa_interes, dias_anio_comercial);
    }
    
    
}
