package ironsoft

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CoordinacionServiceSpec extends Specification {

    CoordinacionService coordinacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Coordinacion(...).save(flush: true, failOnError: true)
        //new Coordinacion(...).save(flush: true, failOnError: true)
        //Coordinacion coordinacion = new Coordinacion(...).save(flush: true, failOnError: true)
        //new Coordinacion(...).save(flush: true, failOnError: true)
        //new Coordinacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //coordinacion.id
    }

    void "test get"() {
        setupData()

        expect:
        coordinacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Coordinacion> coordinacionList = coordinacionService.list(max: 2, offset: 2)

        then:
        coordinacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        coordinacionService.count() == 5
    }

    void "test delete"() {
        Long coordinacionId = setupData()

        expect:
        coordinacionService.count() == 5

        when:
        coordinacionService.delete(coordinacionId)
        sessionFactory.currentSession.flush()

        then:
        coordinacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Coordinacion coordinacion = new Coordinacion()
        coordinacionService.save(coordinacion)

        then:
        coordinacion.id != null
    }
}
