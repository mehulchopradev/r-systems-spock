import spock.lang.Shared
import spock.lang.Specification

class FiboSeriesSpec extends Specification {

    @Shared
    GroovyObject obj

    def setupSpec() {
        Class cls = new GroovyClassLoader(getClass().getClassLoader())
                .parseClass(new File("src/main/groovy/fiboseries.groovy"))
        this.obj = (GroovyObject)cls.getDeclaredConstructor().newInstance()
    }

    def "test the fibo series function"() {
        when:
        def r = this.obj.fibo n

        then:
        r == e

        where:
        n | a | b || e
        8 | _ | _ || [0, 1, 1, 2, 3, 5, 8, 13]
        9 | _ | _ || [0, 1, 1, 2, 3, 5, 8, 13, 21]
    }

    def "test the fibo series for n <= 2" () {
        when:
        this.obj.fibo n

        then:
        IllegalArgumentException e = thrown()
        e.message == 'n must be more than 2'

        where:
        n << [0, 1, 2]
    }

    def "test the fibo series for n > 2" () {
        when:
        this.obj.fibo n

        then:
        notThrown(IllegalArgumentException)

        where:
        n << [3, 10, 100]
    }
}
