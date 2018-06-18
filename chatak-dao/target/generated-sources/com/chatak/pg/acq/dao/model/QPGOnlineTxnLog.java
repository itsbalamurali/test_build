package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGOnlineTxnLog is a Querydsl query type for PGOnlineTxnLog
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGOnlineTxnLog extends EntityPathBase<PGOnlineTxnLog> {

    private static final long serialVersionUID = 1202180156L;

    public static final QPGOnlineTxnLog pGOnlineTxnLog = new QPGOnlineTxnLog("pGOnlineTxnLog");

    public final StringPath appMode = createString("appMode");

    public final StringPath billerAddress = createString("billerAddress");

    public final StringPath billerAddress2 = createString("billerAddress2");

    public final StringPath billerCity = createString("billerCity");

    public final StringPath billerCountry = createString("billerCountry");

    public final StringPath billerEmail = createString("billerEmail");

    public final StringPath billerName = createString("billerName");

    public final StringPath billerState = createString("billerState");

    public final StringPath billerZip = createString("billerZip");

    public final StringPath cardAssciation = createString("cardAssciation");

    public final StringPath cardHolderName = createString("cardHolderName");

    public final NumberPath<Long> feeAmount = createNumber("feeAmount", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath invoceNumber = createString("invoceNumber");

    public final NumberPath<Long> merchantAmount = createNumber("merchantAmount", Long.class);

    public final StringPath merchantId = createString("merchantId");

    public final StringPath merchantName = createString("merchantName");

    public final StringPath merchantReturnUrl = createString("merchantReturnUrl");

    public final StringPath orderId = createString("orderId");

    public final StringPath panData = createString("panData");

    public final StringPath panMasked = createString("panMasked");

    public final NumberPath<Integer> paymentProcessType = createNumber("paymentProcessType", Integer.class);

    public final StringPath pgTxnId = createString("pgTxnId");

    public final StringPath posEntryMode = createString("posEntryMode");

    public final NumberPath<Long> posTxnDate = createNumber("posTxnDate", Long.class);

    public final StringPath processorResponse = createString("processorResponse");

    public final StringPath processorTxnId = createString("processorTxnId");

    public final StringPath registerNumber = createString("registerNumber");

    public final DateTimePath<java.sql.Timestamp> requestDateTime = createDateTime("requestDateTime", java.sql.Timestamp.class);

    public final StringPath requestIPPort = createString("requestIPPort");

    public final DateTimePath<java.sql.Timestamp> responseDateTime = createDateTime("responseDateTime", java.sql.Timestamp.class);

    public final StringPath txnDescription = createString("txnDescription");

    public final StringPath txnReason = createString("txnReason");

    public final StringPath txnState = createString("txnState");

    public final NumberPath<Long> txnTotalAmount = createNumber("txnTotalAmount", Long.class);

    public final StringPath txnType = createString("txnType");

    public QPGOnlineTxnLog(String variable) {
        super(PGOnlineTxnLog.class, forVariable(variable));
    }

    public QPGOnlineTxnLog(Path<? extends PGOnlineTxnLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGOnlineTxnLog(PathMetadata<?> metadata) {
        super(PGOnlineTxnLog.class, metadata);
    }

}

