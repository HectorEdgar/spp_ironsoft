package ironsoft

import grails.gorm.services.Service

@Service(Empleado)
interface EmpleadoService {

    Empleado get(Serializable id)

    List<Empleado> list(Map args)

    Long count()

    void delete(Serializable id)

    Empleado save(Empleado empleado)

}