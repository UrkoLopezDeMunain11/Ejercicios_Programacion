package Modelo;


@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private integer id;

    @Column(name = "numeroCuenta", nullable = false, length = 50)
    private String numeroCuenta;

    @Column(name = "saldo", nullable = false)
    private double saldo;


    public Cuenta() {
    }

    public Cuenta(int id, String numeroCuenta, double saldo, int titularId) {
            this.id = id;
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
            this.titularId = titularId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNumeroCuenta() {
            return numeroCuenta;
        }

        public void setNumeroCuenta(String numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        public int getTitularId() {
            return titularId;
        }

        public void setTitularId(int titularId) {
            this.titularId = titularId;
        }

        @Override
        public String toString() {
            return "Cuenta{" +
                    "id=" + id +
                    ", numeroCuenta='" + numeroCuenta + '\'' +
                    ", saldo=" + saldo +
                    ", titularId=" + titularId +
                    '}';
        }
}
