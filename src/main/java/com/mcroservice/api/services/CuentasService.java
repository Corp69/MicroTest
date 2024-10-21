package com.mcroservice.api.services;




import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcroservice.api.repositories.CuentasClienteRepository;
import com.mcroservice.api.repositories.CuentasRepository;
import com.mcroservice.api.responses.CuentasAPagarResp;
import com.mcroservice.api.responses.CuentasClienteResp;

@Service
public class CuentasService {
	
    @Autowired
    private CuentasRepository cuentasRepository;
    
    @Autowired
    private CuentasClienteRepository cuentasClienteRepository;

    public List<CuentasAPagarResp> getCuentasPorPagar(Double tasa_interes, Integer dias_anio_comercial) {
        return cuentasRepository.findCuentasPorPagar(tasa_interes, dias_anio_comercial);
    }
    
    public List<CuentasClienteResp> getCuentaActiva() {
    	return cuentasClienteRepository.findCuentasActivas();
    }
    
    
}
