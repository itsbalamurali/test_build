package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGFundingReport is a Querydsl query type for PGFundingReport
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGFundingReport extends EntityPathBase<PGFundingReport> {

    private static final long serialVersionUID = 1381033186L;

    public static final QPGFundingReport pGFundingReport = new QPGFundingReport("pGFundingReport");

    public final StringPath bankAccountNumber = createString("bankAccountNumber");

    public final StringPath bankRoutingNumber = createString("bankRoutingNumber");

    public final StringPath batchId = createString("batchId");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currency = createString("currency");

    public final NumberPath<Double> feeBilledAmount = createNumber("feeBilledAmount", Double.class);

    public final NumberPath<Double> fundingAmount = createNumber("fundingAmount", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath merchantCode = createString("merchantCode");

    public final StringPath merchantName = createString("merchantName");

    public final NumberPath<Double> netFundingAmount = createNumber("netFundingAmount", Double.class);

    public final StringPath subMerchantCode = createString("subMerchantCode");

    public final StringPath subMerchantName = createString("subMerchantName");

    public QPGFundingReport(String variable) {
        super(PGFundingReport.class, forVariable(variable));
    }

    public QPGFundingReport(Path<? extends PGFundingReport> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGFundingReport(PathMetadata<?> metadata) {
        super(PGFundingReport.class, metadata);
    }

}

