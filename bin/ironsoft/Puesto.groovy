package ironsoft

class Puesto {

    String nombre
    String descripcion
    int numeroPuesto
    Categoria categoria

    static constraints = {
        nombre nullable: false
        descripcion nullable: true
        numeroPuesto min: 1
        categoria nullable: false
    }
}
