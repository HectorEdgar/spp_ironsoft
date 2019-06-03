package ironsoft

class Direccion {
    String calle
    String colonia
    String estado
    String municipio
    String cp
    int numCasa
    static hasOne = [persona:Persona]

    static constraints = {
        calle nullable: false
        colonia nullable: false
        estado nullable: false
        municipio nullable: false
        cp nullable: false
        numCasa min: 1, nullable:false
        persona nullable: true
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", colonia='" + colonia + '\'' +
                ", estado='" + estado + '\'' +
                ", municipio='" + municipio + '\'' +
                ", cp='" + cp + '\'' +
                ", numCasa=" + numCasa +
                '}';
    }
}
