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

import java.util.List;

@RequestMapping("/Cuentas")
@RestController
@Tag( name = "Micro-SERVICE -  Gestion cuentas" )
public class CuentasCtrl {
	
	
	private final CuentasService cuentasService;

    @Autowired
    public CuentasCtrl(CuentasService cuentasService) {
        this.cuentasService = cuentasService;
    }

	@Operation( summary = "Get cuentas activas")
	@PostMapping("/getCuentas")
		public ResponseEntity<ApiResponse<List<CuentasAPagarResp>>> getCuentasAPagar(@RequestBody CuentasVO cuenta) {
		  List<CuentasAPagarResp> cuentas = cuentasService.getCuentasPorPagar(cuenta.getTasaInteres(), cuenta.getDiasComercial());
		    ApiResponse<List<CuentasAPagarResp>> response = new ApiResponse<>(true, "Obtencion de datos correctamente", cuentas);
		    return ResponseEntity.ok(response);
	    }
	  
}
