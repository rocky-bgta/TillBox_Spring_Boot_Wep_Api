/**
 * Created By: Md. Rashed Khan Menon
 * Created Date: 04/05/2018
 * Time: 05:39
 * Modified By:
 * Modified date:
 * (C) CopyRight NybSys ltd.
 */

package com.nybsys.tillboxweb.models.user.registration;

import java.util.Date;

public class VMCurrencyExchangeRateRequestModel {
    private Date transactionDate;
    private Integer preferredCurrencyID;

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getPreferredCurrencyID() {
        return preferredCurrencyID;
    }

    public void setPreferredCurrencyID(Integer preferredCurrencyID) {
        this.preferredCurrencyID = preferredCurrencyID;
    }
}
