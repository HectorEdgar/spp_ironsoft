package ironsoft

class Categoria {

    String nombre
    String descripcion
    String nivel


    static constraints = {
        nombre nullable: false
        descripcion nullable: true
        nivel nullable: false, inList: ["1","2","3","4","5","6","7","8","9","10","11","12"], widget:"select"
    }
}
