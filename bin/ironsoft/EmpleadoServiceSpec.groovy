package ironsoft

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmpleadoServiceSpec extends Specification {

    EmpleadoService empleadoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Empleado(...).save(flush: true, failOnError: true)
        //new Empleado(...).save(flush: true, failOnError: true)
        //Empleado empleado = new Empleado(...).save(flush: true, failOnError: true)
        //new Empleado(...).save(flush: true, failOnError: true)
        //new Empleado(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //empleado.id
    }

    void "test get"() {
        setupData()

        expect:
        empleadoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Empleado> empleadoList = empleadoService.list(max: 2, offset: 2)

        then:
        empleadoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        empleadoService.count() == 5
    }

    void "test delete"() {
        Long empleadoId = setupData()

        expect:
        empleadoService.count() == 5

        when:
        empleadoService.delete(empleadoId)
        sessionFactory.currentSession.flush()

        then:
        empleadoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Empleado empleado = new Empleado()
        empleadoService.save(empleado)

        then:
        empleado.id != null
    }
}
