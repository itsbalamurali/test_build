package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGSwitchTransaction is a Querydsl query type for PGSwitchTransaction
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGSwitchTransaction extends EntityPathBase<PGSwitchTransaction> {

    private static final long serialVersionUID = -938918693L;

    public static final QPGSwitchTransaction pGSwitchTransaction = new QPGSwitchTransaction("pGSwitchTransaction");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mcc = createString("mcc");

    public final StringPath pan = createString("pan");

    public final StringPath panMasked = createString("panMasked");

    public final StringPath pgTransactionId = createString("pgTransactionId");

    public final StringPath posEntryMode = createString("posEntryMode");

    public final NumberPath<Long> processorApprovedAmt = createNumber("processorApprovedAmt", Long.class);

    public final StringPath processorAuthCode = createString("processorAuthCode");

    public final StringPath processorMessage = createString("processorMessage");

    public final StringPath processorResponse = createString("processorResponse");

    public final StringPath processorResponseMsg = createString("processorResponseMsg");

    public final DateTimePath<java.sql.Timestamp> processorResponsePostDate = createDateTime("processorResponsePostDate", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> processorResponseTime = createDateTime("processorResponseTime", java.sql.Timestamp.class);

    public final StringPath processorTxnDuplicate = createString("processorTxnDuplicate");

    public final NumberPath<Long> settlementBatchId = createNumber("settlementBatchId", Long.class);

    public final NumberPath<Integer> settlementBatchStatus = createNumber("settlementBatchStatus", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Long> switchId = createNumber("switchId", Long.class);

    public final StringPath transaction_code = createString("transaction_code");

    public final StringPath transactionId = createString("transactionId");

    public final NumberPath<Long> txnAmount = createNumber("txnAmount", Long.class);

    public final StringPath txnMode = createString("txnMode");

    public QPGSwitchTransaction(String variable) {
        super(PGSwitchTransaction.class, forVariable(variable));
    }

    public QPGSwitchTransaction(Path<? extends PGSwitchTransaction> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGSwitchTransaction(PathMetadata<?> metadata) {
        super(PGSwitchTransaction.class, metadata);
    }

}

