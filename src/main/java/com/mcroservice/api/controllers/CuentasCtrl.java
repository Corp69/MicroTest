package com.mcroservice.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcroservice.api.services.CuentasService;
import com.mcroservice.api.req.CuentasVO;
import com.mcroservice.api.responses.CuentasAPagarResp;

import java.util.List;

@RequestMapping("/Cuentas")
@RestController
public class CuentasCtrl {
	
	
	private final CuentasService cuentasService;

    @Autowired
    public CuentasCtrl(CuentasService cuentasService) {
        this.cuentasService = cuentasService;
    }

	  @PostMapping("/getCuentas")
	    public ResponseEntity<List<CuentasAPagarResp>> getCuentasAPagar(@RequestBody CuentasVO cuenta) {
	        List<CuentasAPagarResp> cuentas = cuentasService.getCuentasPorPagar(cuenta.getTasaInteres(), cuenta.getDiasComercial());
	        return ResponseEntity.ok(cuentas);
	    }
	  
}
