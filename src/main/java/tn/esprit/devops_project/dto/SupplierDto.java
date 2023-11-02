package tn.esprit.devops_project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierDto {
    Long idSupplier;
    String code;
    String label;
    @Enumerated(EnumType.STRING)
    SupplierCategory supplierCategory;
    @JsonIgnore
    private  Set<Invoice> invoices;



    public static Supplier toEntity(SupplierDto supplierDto) {
        if (supplierDto == null) {
            return null;
        }

        return Supplier.builder()
                .idSupplier(supplierDto.getIdSupplier())
                .code(supplierDto.getCode())
                .label(supplierDto.getLabel())
                .build();
    }
    public static SupplierDto toDto(Supplier supplier){
        if(supplier==null){
            return null;
        }



        return  SupplierDto.builder()
                .idSupplier(supplier.getIdSupplier())
                .code(supplier.getCode())
                .label(supplier.getLabel())
                .build();
    }

}
