package ironsoft

class Categoria {

    String nombre
    String descripcion
    String nivel


    static constraints = {
        nombre nullable: false
        descripcion nullable: true
        nivel nullable: false
    }
}
