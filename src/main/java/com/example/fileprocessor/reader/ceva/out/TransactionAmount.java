package com.example.fileprocessor.reader.ceva.out;


import lombok.Data;

@Data
public class TransactionAmount {

    private String currency;
    private Integer total;

    public TransactionAmount(String currency, Integer total) {
        this.currency = currency;
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
