package com.mcroservice.api.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcroservice.api.services.CuentasService;
import com.mcroservice.api.req.CuentasVO;
import com.mcroservice.api.responses.ApiResponse;
import com.mcroservice.api.responses.CuentasAPagarResp;
import com.mcroservice.api.responses.CuentasClienteResp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/Cuentas")
@RestController
@Tag( name = "Micro-SERVICE -  Gestion cuentas" )
public class CuentasCtrl {
	
	
	private final CuentasService cuentasService;

    @Autowired
    public CuentasCtrl(CuentasService cuentasService) {
        this.cuentasService = cuentasService;
    }

    @Operation(summary = "Get cuentas activas")
    @PostMapping("/getCuentas")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getCuentasAPagar(@RequestBody CuentasVO cuenta) {
        List<CuentasAPagarResp> pagos  = cuentasService.getCuentasPorPagar(cuenta.getTasaInteres(), cuenta.getDiasComercial());
        List<CuentasClienteResp> cuentas = cuentasService.getCuentaActiva();
        // Crear un mapa para almacenar las listas
        Map<String, Object> combinedData = new HashMap<>();
        combinedData.put("pagos", pagos);
        combinedData.put("Cuentas",cuentas );
        // Crear la respuesta
        ApiResponse<Map<String, Object>> response = new ApiResponse<>(true, "Obtención de datos correctamente", combinedData);
        return ResponseEntity.ok(response);
    }
	
	
	
	
	
	@Operation( summary = "se aplica el Pago es necesario cambiar el Estado del Prestamo de Pendiente a Pagado y en la Cuenta de Débito se debe reducir el Monto descontando el Pago")
	@PostMapping("/GetPago")
		public ResponseEntity<ApiResponse<List<CuentasAPagarResp>>> getPago(@RequestBody CuentasVO cuenta) {
		  List<CuentasAPagarResp> cuentas = cuentasService.getCuentasPorPagar(cuenta.getTasaInteres(), cuenta.getDiasComercial());
		    ApiResponse<List<CuentasAPagarResp>> response = new ApiResponse<>(true, "Obtencion de datos correctamente", cuentas);
		    return ResponseEntity.ok(response);
	    }
	
	
	  
}
