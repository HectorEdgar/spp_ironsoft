package ironsoft

class Empleado {

    String rfc
    String homoclave
    String numeroEmpleado
    String ubicacion
    String proyecto
    Puesto puesto
    Departamento departamento
    Area area


    static constraints = {
        rfc nullable: false
        homoclave nullable: false
        numeroEmpleado nullable: false
        puesto nullable: false
        departamento nullable: true
        area nullable: true
        ubicacion nullable: true, inList: ["Ciudad Administrativa", "Palacio"], widget: "select"
        proyecto nullable: true, inList: ["110","210","310","410"], widget: "select"
    }
}
