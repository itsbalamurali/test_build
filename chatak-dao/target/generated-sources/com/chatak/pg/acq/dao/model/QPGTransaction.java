package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGTransaction is a Querydsl query type for PGTransaction
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGTransaction extends EntityPathBase<PGTransaction> {

    private static final long serialVersionUID = -1183578769L;

    public static final QPGTransaction pGTransaction = new QPGTransaction("pGTransaction");

    public final StringPath acqChannel = createString("acqChannel");

    public final StringPath acqTxnMode = createString("acqTxnMode");

    public final NumberPath<Long> adjAmount = createNumber("adjAmount", Long.class);

    public final StringPath aiCountryCode = createString("aiCountryCode");

    public final StringPath authId = createString("authId");

    public final StringPath autoSettlementStatus = createString("autoSettlementStatus");

    public final DateTimePath<java.sql.Timestamp> batchDate = createDateTime("batchDate", java.sql.Timestamp.class);

    public final StringPath batchId = createString("batchId");

    public final StringPath cardHolderEmail = createString("cardHolderEmail");

    public final StringPath cardHolderName = createString("cardHolderName");

    public final NumberPath<Integer> chipFallbackTransaction = createNumber("chipFallbackTransaction", Integer.class);

    public final NumberPath<Integer> chipTransaction = createNumber("chipTransaction", Integer.class);

    public final NumberPath<Long> cpId = createNumber("cpId", Long.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath deviceLocalTxnTime = createString("deviceLocalTxnTime");

    public final StringPath eftId = createString("eftId");

    public final StringPath eftMode = createString("eftMode");

    public final StringPath eftStatus = createString("eftStatus");

    public final NumberPath<Long> expDate = createNumber("expDate", Long.class);

    public final NumberPath<Long> feeAmount = createNumber("feeAmount", Long.class);

    public final StringPath fwdCountryCode = createString("fwdCountryCode");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath invoiceNumber = createString("invoiceNumber");

    public final NumberPath<Long> isoId = createNumber("isoId", Long.class);

    public final StringPath issuancePartner = createString("issuancePartner");

    public final StringPath issuerTxnRefNum = createString("issuerTxnRefNum");

    public final StringPath mcc = createString("mcc");

    public final NumberPath<Long> merchantFeeAmount = createNumber("merchantFeeAmount", Long.class);

    public final StringPath merchantId = createString("merchantId");

    public final StringPath merchantSettlementId = createString("merchantSettlementId");

    public final StringPath merchantSettlementStatus = createString("merchantSettlementStatus");

    public final StringPath mti = createString("mti");

    public final StringPath pan = createString("pan");

    public final StringPath panCountryCode = createString("panCountryCode");

    public final StringPath panMasked = createString("panMasked");

    public final StringPath paymentMethod = createString("paymentMethod");

    public final NumberPath<Long> pmId = createNumber("pmId", Long.class);

    public final StringPath posEntryMode = createString("posEntryMode");

    public final StringPath posTxnDate = createString("posTxnDate");

    public final StringPath posTxnTime = createString("posTxnTime");

    public final StringPath procCode = createString("procCode");

    public final StringPath processor = createString("processor");

    public final StringPath reason = createString("reason");

    public final StringPath refTransactionId = createString("refTransactionId");

    public final NumberPath<Integer> refundStatus = createNumber("refundStatus", Integer.class);

    public final NumberPath<Long> settlementBatchId = createNumber("settlementBatchId", Long.class);

    public final NumberPath<Integer> settlementBatchStatus = createNumber("settlementBatchStatus", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath sysTraceNum = createString("sysTraceNum");

    public final StringPath terminalId = createString("terminalId");

    public final StringPath timeZoneOffset = createString("timeZoneOffset");

    public final StringPath timeZoneRegion = createString("timeZoneRegion");

    public final StringPath transactionId = createString("transactionId");

    public final StringPath transactionType = createString("transactionType");

    public final NumberPath<Long> txnAmount = createNumber("txnAmount", Long.class);

    public final StringPath txnCountryCode = createString("txnCountryCode");

    public final StringPath txnCurrencyCode = createString("txnCurrencyCode");

    public final StringPath txnDescription = createString("txnDescription");

    public final StringPath txnMode = createString("txnMode");

    public final NumberPath<Long> txnTotalAmount = createNumber("txnTotalAmount", Long.class);

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath userName = createString("userName");

    public QPGTransaction(String variable) {
        super(PGTransaction.class, forVariable(variable));
    }

    public QPGTransaction(Path<? extends PGTransaction> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGTransaction(PathMetadata<?> metadata) {
        super(PGTransaction.class, metadata);
    }

}

