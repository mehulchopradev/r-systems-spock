import spock.lang.Specification

class TestStringsSpec extends Specification{

    // test cases
    // spec methods
    def "test the subscript operator that can be used with strings in groovy"() {
        // test data
        given:
        def str = 'good morning to all'

        // expectations
        // groovy expressions
        expect:
        str[0] == 'g'
        str[-1] == 'l'
        str[0..3] == 'good'
    }

    def "test the subscript operator on list objects"() {
        given:
        def l = [5, 6, 4, 3, 2, 1]

        expect:
        l[0] == 5
        l[-1] == 1
        l[0..3] == [5, 6, 4, 3]
    }
}
