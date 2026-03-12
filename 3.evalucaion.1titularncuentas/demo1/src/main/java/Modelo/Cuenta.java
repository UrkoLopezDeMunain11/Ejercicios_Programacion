package Modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(name = "iban", nullable = false, length = 20)
    private String iban;

    @Column(name = "numeroCuenta", nullable = false, length = 50)
    private String numeroCuenta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_titular", nullable = false)
    private Titular idTitular;

    public Cuenta(int i, String numeroCuenta, String  iban, int i1) {
        this.numeroCuenta = numeroCuenta;
        this.iban = iban;
    }

    public Cuenta() {

    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Titular getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Titular idTitular) {
        this.idTitular = idTitular;
    }

}