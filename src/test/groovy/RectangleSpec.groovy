import spock.lang.Shared
import spock.lang.Specification

class RectangleSpec extends Specification {

    @Shared
    GroovyObject obj

    // this lifecycle method runs only once before all the other test case methods start executing
    def setupSpec() {
        Class cls = new GroovyClassLoader(getClass().getClassLoader())
                .parseClass(new File("src/main/groovy/rectangle.groovy"))
        this.obj = (GroovyObject)cls.getDeclaredConstructor().newInstance()
    }

    // this lifecycle method runs before every test case method in the class
    def setup() {
        /* Class cls = new GroovyClassLoader(getClass().getClassLoader())
                .parseClass(new File("src/main/groovy/rectangle.groovy"))
        this.obj = (GroovyObject)cls.getDeclaredConstructor().newInstance() */
    }

    // this lifecycle method runs after every test case method in the class
    def cleanup() {
        println "cleanup called"
    }

    // this lifecycle method runs only once at the end once all the test case methods in the class have finished running
    def cleanupSpec() {
        println "cleanupspec called"
    }

    def "test the perimeter function for the rectangle script"() {
        given:
        def length = 5
        def breadth = 3

        when:
        def result = this.obj.perimeter(length, breadth)

        then:
        result == 16

        when:
        result = this.obj.perimeter(length)

        then:
        result == 14
    }

    def "test the area function for the rectangle script"() {
        given:
        def length = 5
        def breadth = 3

        expect:
        this.obj.area(length, breadth) == 15
    }
}
