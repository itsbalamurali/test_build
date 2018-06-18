package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGSplitTransaction is a Querydsl query type for PGSplitTransaction
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGSplitTransaction extends EntityPathBase<PGSplitTransaction> {

    private static final long serialVersionUID = 1562905459L;

    public static final QPGSplitTransaction pGSplitTransaction = new QPGSplitTransaction("pGSplitTransaction");

    public final StringPath cardHolderName = createString("cardHolderName");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath expDate = createString("expDate");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath merchantId = createString("merchantId");

    public final NumberPath<Long> mobileNumber = createNumber("mobileNumber", Long.class);

    public final StringPath pan = createString("pan");

    public final StringPath panMasked = createString("panMasked");

    public final StringPath pgRefTransactionId = createString("pgRefTransactionId");

    public final StringPath pgTransactionId = createString("pgTransactionId");

    public final StringPath reason = createString("reason");

    public final NumberPath<Long> splitAmount = createNumber("splitAmount", Long.class);

    public final StringPath splitMode = createString("splitMode");

    public final StringPath splitTransactionId = createString("splitTransactionId");

    public final NumberPath<Long> status = createNumber("status", Long.class);

    public final NumberPath<Long> txnAmount = createNumber("txnAmount", Long.class);

    public final StringPath txnDescription = createString("txnDescription");

    public final DateTimePath<java.sql.Timestamp> updateddDate = createDateTime("updateddDate", java.sql.Timestamp.class);

    public QPGSplitTransaction(String variable) {
        super(PGSplitTransaction.class, forVariable(variable));
    }

    public QPGSplitTransaction(Path<? extends PGSplitTransaction> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGSplitTransaction(PathMetadata<?> metadata) {
        super(PGSplitTransaction.class, metadata);
    }

}

