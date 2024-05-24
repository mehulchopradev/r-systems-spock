import spock.lang.Shared
import spock.lang.Specification

class EvenOddSpec extends Specification {
    @Shared
    GroovyObject obj

    def setupSpec() {
        Class cls = new GroovyClassLoader(getClass().getClassLoader())
                .parseClass(new File("src/main/groovy/evenodd.groovy"))
        this.obj = (GroovyObject)cls.getDeclaredConstructor().newInstance()
    }

    def 'testing the evenodd function'() {
        when:
        def r = this.obj.evenOdd n

        then:
        r == e

        // Data tables
        /* where:
        n | e
        5 | 'Odd'
        4 | 'Even'
        0 | 'Even'
        1 | 'Odd' */

        // Data pipes
        where:
        n << [5, 4, 0, 1]
        e << ['Odd', 'Even', 'Even', 'Odd']
    }
}
