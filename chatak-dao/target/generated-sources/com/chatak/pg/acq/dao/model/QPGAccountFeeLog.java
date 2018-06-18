package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGAccountFeeLog is a Querydsl query type for PGAccountFeeLog
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGAccountFeeLog extends EntityPathBase<PGAccountFeeLog> {

    private static final long serialVersionUID = -956375876L;

    public static final QPGAccountFeeLog pGAccountFeeLog = new QPGAccountFeeLog("pGAccountFeeLog");

    public final StringPath accountDesc = createString("accountDesc");

    public final NumberPath<Long> accountNum = createNumber("accountNum", Long.class);

    public final StringPath agentAccNum = createString("agentAccNum");

    public final StringPath category = createString("category");

    public final NumberPath<Long> chatakFee = createNumber("chatakFee", Long.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currency = createString("currency");

    public final StringPath entityId = createString("entityId");

    public final StringPath entityType = createString("entityType");

    public final NumberPath<Integer> feePostStatus = createNumber("feePostStatus", Integer.class);

    public final DateTimePath<java.sql.Timestamp> feeTxnDate = createDateTime("feeTxnDate", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath issuanceFeeTxnId = createString("issuanceFeeTxnId");

    public final StringPath issuanceMessage = createString("issuanceMessage");

    public final NumberPath<Long> merchantFee = createNumber("merchantFee", Long.class);

    public final StringPath parentEntityId = createString("parentEntityId");

    public final StringPath partnerAccNum = createString("partnerAccNum");

    public final StringPath paymentMethod = createString("paymentMethod");

    public final StringPath specificAccNumber = createString("specificAccNumber");

    public final StringPath status = createString("status");

    public final StringPath transactionId = createString("transactionId");

    public final NumberPath<Long> txnAmount = createNumber("txnAmount", Long.class);

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGAccountFeeLog(String variable) {
        super(PGAccountFeeLog.class, forVariable(variable));
    }

    public QPGAccountFeeLog(Path<? extends PGAccountFeeLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGAccountFeeLog(PathMetadata<?> metadata) {
        super(PGAccountFeeLog.class, metadata);
    }

}

