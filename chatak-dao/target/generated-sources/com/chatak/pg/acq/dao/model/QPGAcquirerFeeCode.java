package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGAcquirerFeeCode is a Querydsl query type for PGAcquirerFeeCode
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGAcquirerFeeCode extends EntityPathBase<PGAcquirerFeeCode> {

    private static final long serialVersionUID = -694633816L;

    public static final QPGAcquirerFeeCode pGAcquirerFeeCode = new QPGAcquirerFeeCode("pGAcquirerFeeCode");

    public final NumberPath<Long> acquirerFeeCodeId = createNumber("acquirerFeeCodeId", Long.class);

    public final StringPath acquirerName = createString("acquirerName");

    public final NumberPath<Double> feePercentageOnly = createNumber("feePercentageOnly", Double.class);

    public final NumberPath<Double> flatFee = createNumber("flatFee", Double.class);

    public final StringPath merchantCode = createString("merchantCode");

    public final NumberPath<Long> partnerId = createNumber("partnerId", Long.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGAcquirerFeeCode(String variable) {
        super(PGAcquirerFeeCode.class, forVariable(variable));
    }

    public QPGAcquirerFeeCode(Path<? extends PGAcquirerFeeCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGAcquirerFeeCode(PathMetadata<?> metadata) {
        super(PGAcquirerFeeCode.class, metadata);
    }

}

