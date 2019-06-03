package ironsoft

class Coordinacion {
    String nombre
    Direccion direccion
    static hasMany = [empleados: Empleado]

    static constraints = {
        nombre nullable: false
        direccion nullable: true
        empleados nullable: true
    }
}
