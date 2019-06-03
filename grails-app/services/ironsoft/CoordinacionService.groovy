package ironsoft

import grails.gorm.services.Service

@Service(Coordinacion)
interface CoordinacionService {

    Coordinacion get(Serializable id)

    List<Coordinacion> list(Map args)

    Long count()

    void delete(Serializable id)

    Coordinacion save(Coordinacion coordinacion)

}