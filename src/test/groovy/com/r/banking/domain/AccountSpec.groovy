package com.r.banking.domain

import com.r.banking.util.BankingUtil
import com.r.banking.util.IBankingUtil
import spock.lang.Specification

class AccountSpec extends Specification {

    def "test the deposit method"() {
        given:
        def acc = new Account(accType: 'Savings', accNo: 1234, balance: 10000)

        when:
        def bal = acc + 5000

        then:
        bal == 15000
        acc.balance == 15000
        acc.accType == 'Savings'
    }

    def "test the withdrawl method"() {
        given:
        def mock = Mock(IBankingUtil)
        def acc = new Account(accType: 'Savings', accNo: 1234, balance: 10000, bankingUtil: mock)

        when:
        def bal = acc - 5000

        then:
        bal == 5000
        acc.balance == 5000
        acc.accType == 'Savings'
    }

    def "test the low balance withdrawl method"() {
        given:
        def stub = Stub(IBankingUtil)
        stub.cannotWithdraw(_, _) >> {Account account, BigDecimal amt -> amt == 9000 ? false : true}
        def acc = new Account(accType: 'Savings', accNo: 1234, balance: 10000, bankingUtil: stub)

        when:
        acc - 9000

        then:
        notThrown(IllegalStateException)

        when:
        acc - 500

        then:
        IllegalStateException e = thrown()
        e.message == 'cannot perform withdrawl based on current account state'
    }

}
