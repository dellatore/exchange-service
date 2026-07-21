package br.com.erudio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
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
@Entity(name = "exchange")
public class Exchange implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "from_currency")
    private String from;

    @Column(name = "to_currency")
    private String to;

    @Column(name = "conversion_factor")
    private BigDecimal conversionFactor;

    @Transient //diz que a variavel deve ser ignorada no contexto do banco de dados
    private BigDecimal convertedValue;

    @Transient
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
