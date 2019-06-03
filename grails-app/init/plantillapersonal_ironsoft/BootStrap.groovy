package plantillapersonal_ironsoft

import ironsoft.Direccion
import ironsoft.Persona
import ironsoft.Rol
import ironsoft.Usuario
import ironsoft.UsuarioRol

class BootStrap {

    def init = { servletContext ->

        //Creación de roles
        def rolAdmin = new  Rol(authority:"ROLE_ADMIN").save()

        def usuarioAdmin = new  Usuario(
                username: "admin",
                password:"admin",
                persona:new Persona(
                        nombre: "Héctor Edgar",
                        apellidoPaterno: "Matías",
                        apellidoMaterno: "Rodríguez",
                        fechaNacimiento: new Date().parse('yyyy/MM/dd', '1996/09/11'),
                        numHijos: 0,
                        sexo: "Masculino",
                        curp: "MARH960911HOCTDC08",
                        direccion: new Direccion(
                                calle: "Yalalag",
                                colonia: "Guelaguetza",
                                estado: "Oaxaca",
                                numCasa: 4,
                                municipio: "Santa María Atzompa",
                                cp: "7440"
                        )
                )
        ).save(failOnError:true)

        new UsuarioRol(usuario: usuarioAdmin, rol: rolAdmin).save()

        println(rolAdmin.toString()+"\n"+usuarioAdmin.toString())

    }
    def destroy = {
    }
}
