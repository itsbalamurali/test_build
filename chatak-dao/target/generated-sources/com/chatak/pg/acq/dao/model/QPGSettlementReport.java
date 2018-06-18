package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGSettlementReport is a Querydsl query type for PGSettlementReport
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGSettlementReport extends EntityPathBase<PGSettlementReport> {

    private static final long serialVersionUID = 469190604L;

    public static final QPGSettlementReport pGSettlementReport = new QPGSettlementReport("pGSettlementReport");

    public final StringPath batchId = createString("batchId");

    public final DateTimePath<java.sql.Timestamp> batchTime = createDateTime("batchTime", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath merchantId = createString("merchantId");

    public final NumberPath<Long> programManagerId = createNumber("programManagerId", Long.class);

    public final NumberPath<java.math.BigInteger> settlementAmount = createNumber("settlementAmount", java.math.BigInteger.class);

    public QPGSettlementReport(String variable) {
        super(PGSettlementReport.class, forVariable(variable));
    }

    public QPGSettlementReport(Path<? extends PGSettlementReport> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGSettlementReport(PathMetadata<?> metadata) {
        super(PGSettlementReport.class, metadata);
    }

}

