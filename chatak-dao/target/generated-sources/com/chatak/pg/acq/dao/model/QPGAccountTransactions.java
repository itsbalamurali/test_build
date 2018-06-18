package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGAccountTransactions is a Querydsl query type for PGAccountTransactions
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGAccountTransactions extends EntityPathBase<PGAccountTransactions> {

    private static final long serialVersionUID = -1318740557L;

    public static final QPGAccountTransactions pGAccountTransactions = new QPGAccountTransactions("pGAccountTransactions");

    public final StringPath accountNumber = createString("accountNumber");

    public final StringPath accountTransactionId = createString("accountTransactionId");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> credit = createNumber("credit", Long.class);

    public final NumberPath<Long> currentBalance = createNumber("currentBalance", Long.class);

    public final NumberPath<Long> debit = createNumber("debit", Long.class);

    public final StringPath description = createString("description");

    public final StringPath deviceLocalTxnTime = createString("deviceLocalTxnTime");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath merchantCode = createString("merchantCode");

    public final StringPath pgTransactionId = createString("pgTransactionId");

    public final StringPath pgTransferId = createString("pgTransferId");

    public final DateTimePath<java.sql.Timestamp> processedTime = createDateTime("processedTime", java.sql.Timestamp.class);

    public final NumberPath<Long> refundableAmount = createNumber("refundableAmount", Long.class);

    public final StringPath status = createString("status");

    public final StringPath timeZoneOffset = createString("timeZoneOffset");

    public final StringPath timeZoneRegion = createString("timeZoneRegion");

    public final StringPath toAccountNumber = createString("toAccountNumber");

    public final StringPath transactionCode = createString("transactionCode");

    public final DateTimePath<java.sql.Timestamp> transactionTime = createDateTime("transactionTime", java.sql.Timestamp.class);

    public final StringPath transactionType = createString("transactionType");

    public final DateTimePath<java.sql.Timestamp> updatedTime = createDateTime("updatedTime", java.sql.Timestamp.class);

    public QPGAccountTransactions(String variable) {
        super(PGAccountTransactions.class, forVariable(variable));
    }

    public QPGAccountTransactions(Path<? extends PGAccountTransactions> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGAccountTransactions(PathMetadata<?> metadata) {
        super(PGAccountTransactions.class, metadata);
    }

}

