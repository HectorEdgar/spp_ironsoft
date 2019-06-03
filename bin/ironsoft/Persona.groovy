package ironsoft

class Persona {

    String nombre
    String apellidoPaterno
    String apellidoMaterno
    Date fechaNacimiento
    String curp
    String sexo
    String numeroTelefono
    int numHijos
    Direccion direccion


    static constraints = {
        nombre nullable: false
        apellidoPaterno nullable: false
        apellidoMaterno nullable: false
        fechaNacimiento nullable: false, max: new Date()
        curp nullable: false
<<<<<<< HEAD
        sexo nullable: false
        direccion nullable: false
        numeroTelefono nullable: true
=======
        sexo nullable: false, inList: ["Masculino", "Femenino"], widget:"select"
        direccion nullable: true
    }
>>>>>>> init

    public String getNombreCompleto(){
        return this.nombre+" "+this.apellidoPaterno+" "+this.apellidoMaterno
    }


    @Override
    public String toString() {
        return "Persona{" +
                "direccion=" + direccion +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", curp='" + curp + '\'' +
                ", sexo='" + sexo + '\'' +
                ", numHijos=" + numHijos +
                '}';
    }
}
