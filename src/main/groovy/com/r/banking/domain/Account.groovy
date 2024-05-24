package com.r.banking.domain

import com.r.banking.util.IBankingUtil

class Account {

    Integer accNo
    String accType
    BigDecimal balance
    IBankingUtil bankingUtil

    BigDecimal plus(BigDecimal amt) {
        this.balance += amt
    }

    BigDecimal minus(BigDecimal amt) {
        if (bankingUtil.cannotWithdraw(this, amt)) {
            throw new IllegalStateException('cannot perform withdrawl based on current account state')
        }

        this.balance -= amt
    }
}
