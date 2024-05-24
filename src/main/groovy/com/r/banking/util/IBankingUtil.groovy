package com.r.banking.util

import com.r.banking.domain.Account

interface IBankingUtil {

    Boolean cannotWithdraw(Account account, BigDecimal amt)
}