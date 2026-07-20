package br.com.erudio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exchange implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String environment;


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Exchange exchange)) return false;
        return Objects.equals(id, exchange.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
