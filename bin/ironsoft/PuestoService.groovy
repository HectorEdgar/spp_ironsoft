package ironsoft

import grails.gorm.services.Service

@Service(Puesto)
interface PuestoService {

    Puesto get(Serializable id)

    List<Puesto> list(Map args)

    Long count()

    void delete(Serializable id)

    Puesto save(Puesto puesto)

}