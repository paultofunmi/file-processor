package com.example.fileprocessor.reader.ceva;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NIPTransactionInformationDto {

    @CsvBindByPosition(position = 0)
    private String nipSessionId;

    @CsvBindByPosition(position = 1)
    private String amount;

    @CsvBindByPosition(position = 2)
    private String txn_status;

    @CsvBindByPosition(position = 3)
    private String txn_type;

    @CsvBindByPosition(position = 4)
    private String incomingRequest;

    public String getNipSessionId() {
        return nipSessionId;
    }

    public void setNipSessionId(String nipSessionId) {
        this.nipSessionId = nipSessionId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTxn_status() {
        return txn_status;
    }

    public void setTxn_status(String txn_status) {
        this.txn_status = txn_status;
    }

    public String getTxn_type() {
        return txn_type;
    }

    public void setTxn_type(String txn_type) {
        this.txn_type = txn_type;
    }

    public String getIncomingRequest() {
        return incomingRequest;
    }

    public void setIncomingRequest(String incomingRequest) {
        this.incomingRequest = incomingRequest;
    }

    @Override
    public String toString() {
        return "NIPTransactionInformationDto{" +
                "nipSessionId='" + nipSessionId + '\'' +
                ", amount='" + amount + '\'' +
                ", txn_status='" + txn_status + '\'' +
                ", txn_type='" + txn_type + '\'' +
                ", incomingRequest='" + incomingRequest + '\'' +
                '}';
    }
}