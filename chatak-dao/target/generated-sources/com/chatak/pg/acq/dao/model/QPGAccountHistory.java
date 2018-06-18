package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGAccountHistory is a Querydsl query type for PGAccountHistory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGAccountHistory extends EntityPathBase<PGAccountHistory> {

    private static final long serialVersionUID = -1974203018L;

    public static final QPGAccountHistory pGAccountHistory = new QPGAccountHistory("pGAccountHistory");

    public final StringPath accountDesc = createString("accountDesc");

    public final NumberPath<Long> accountNum = createNumber("accountNum", Long.class);

    public final NumberPath<java.math.BigDecimal> autoPaymentLimit = createNumber("autoPaymentLimit", java.math.BigDecimal.class);

    public final StringPath autoPaymentMethod = createString("autoPaymentMethod");

    public final StringPath autoTransferDay = createString("autoTransferDay");

    public final NumberPath<Long> availableBalance = createNumber("availableBalance", Long.class);

    public final StringPath category = createString("category");

    public final StringPath currency = createString("currency");

    public final NumberPath<Long> currentBalance = createNumber("currentBalance", Long.class);

    public final StringPath entityId = createString("entityId");

    public final StringPath entityType = createString("entityType");

    public final NumberPath<Long> feeBalance = createNumber("feeBalance", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath paymentMethod = createString("paymentMethod");

    public final StringPath status = createString("status");

    public final StringPath transactionId = createString("transactionId");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGAccountHistory(String variable) {
        super(PGAccountHistory.class, forVariable(variable));
    }

    public QPGAccountHistory(Path<? extends PGAccountHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGAccountHistory(PathMetadata<?> metadata) {
        super(PGAccountHistory.class, metadata);
    }

}

