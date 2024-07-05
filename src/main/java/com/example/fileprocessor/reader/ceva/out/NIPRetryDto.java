package com.example.fileprocessor.reader.ceva.out;


import lombok.Data;

@Data
public class NIPRetryDto {

    private Meta meta;

    private TransactionInfo txn;

    private PayerInformation payer;

    private PayeeInformation payee;

    public NIPRetryDto(Meta meta, TransactionInfo txn, PayerInformation payer, PayeeInformation payee) {
        this.meta = meta;
        this.txn = txn;
        this.payer = payer;
        this.payee = payee;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public TransactionInfo getTxn() {
        return txn;
    }

    public void setTxn(TransactionInfo txn) {
        this.txn = txn;
    }

    public PayerInformation getPayer() {
        return payer;
    }

    public void setPayer(PayerInformation payer) {
        this.payer = payer;
    }

    public PayeeInformation getPayee() {
        return payee;
    }

    public void setPayee(PayeeInformation payee) {
        this.payee = payee;
    }
}


