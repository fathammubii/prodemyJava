package com.jpa.jpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties()
public class ProvinceResponse {

    @JsonProperty("rajaongkir")
    private RajaOngkirData rajaOngkirData;

    public ProvinceResponse() throws IOException {
    }

    public RajaOngkirData getRajaOngkirData(){
        return rajaOngkirData;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RajaOngkirData{
        private List<Province> results;

        public List<Province> getResults(){
            return results;
        }

        public void setResults(List<Province> results){
            this.results = results;
        }
    }
}
