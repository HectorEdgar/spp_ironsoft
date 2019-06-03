package ironsoft

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UsuarioRolServiceSpec extends Specification {

    UsuarioRolService usuarioRolService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UsuarioRol(...).save(flush: true, failOnError: true)
        //new UsuarioRol(...).save(flush: true, failOnError: true)
        //UsuarioRol usuarioRol = new UsuarioRol(...).save(flush: true, failOnError: true)
        //new UsuarioRol(...).save(flush: true, failOnError: true)
        //new UsuarioRol(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //usuarioRol.id
    }

    void "test get"() {
        setupData()

        expect:
        usuarioRolService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UsuarioRol> usuarioRolList = usuarioRolService.list(max: 2, offset: 2)

        then:
        usuarioRolList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        usuarioRolService.count() == 5
    }

    void "test delete"() {
        Long usuarioRolId = setupData()

        expect:
        usuarioRolService.count() == 5

        when:
        usuarioRolService.delete(usuarioRolId)
        sessionFactory.currentSession.flush()

        then:
        usuarioRolService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UsuarioRol usuarioRol = new UsuarioRol()
        usuarioRolService.save(usuarioRol)

        then:
        usuarioRol.id != null
    }
}
