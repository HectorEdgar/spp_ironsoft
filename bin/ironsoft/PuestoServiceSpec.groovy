package ironsoft

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PuestoServiceSpec extends Specification {

    PuestoService puestoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Puesto(...).save(flush: true, failOnError: true)
        //new Puesto(...).save(flush: true, failOnError: true)
        //Puesto puesto = new Puesto(...).save(flush: true, failOnError: true)
        //new Puesto(...).save(flush: true, failOnError: true)
        //new Puesto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //puesto.id
    }

    void "test get"() {
        setupData()

        expect:
        puestoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Puesto> puestoList = puestoService.list(max: 2, offset: 2)

        then:
        puestoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        puestoService.count() == 5
    }

    void "test delete"() {
        Long puestoId = setupData()

        expect:
        puestoService.count() == 5

        when:
        puestoService.delete(puestoId)
        sessionFactory.currentSession.flush()

        then:
        puestoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Puesto puesto = new Puesto()
        puestoService.save(puesto)

        then:
        puesto.id != null
    }
}
