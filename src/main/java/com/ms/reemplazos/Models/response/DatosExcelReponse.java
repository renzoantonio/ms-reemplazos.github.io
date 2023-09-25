package com.ms.reemplazos.Models.response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DatosExcelReponse {
    private String apellidoNombreReemplazante;
    private String CUIL;
    private String categoriaReemplazante;
    private String intrumentoLegal;
    private String periodoReemplazo;
    private String diasAPagar;
    private String guardias;
    private String apellidoNombreTitular;
    private String categoria;
    private String periodoLicencia;
    private String cantidadDiasLicencia;
    private String tipoLicenciaTitular;

}
