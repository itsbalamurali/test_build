package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGAcquirerFeeValue is a Querydsl query type for PGAcquirerFeeValue
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGAcquirerFeeValue extends EntityPathBase<PGAcquirerFeeValue> {

    private static final long serialVersionUID = -41673706L;

    public static final QPGAcquirerFeeValue pGAcquirerFeeValue = new QPGAcquirerFeeValue("pGAcquirerFeeValue");

    public final StringPath accountNumber = createString("accountNumber");

    public final StringPath accountType = createString("accountType");

    public final StringPath cardType = createString("cardType");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Double> feePercentageOnly = createNumber("feePercentageOnly", Double.class);

    public final NumberPath<Long> feeProgramId = createNumber("feeProgramId", Long.class);

    public final NumberPath<Long> flatFee = createNumber("flatFee", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGAcquirerFeeValue(String variable) {
        super(PGAcquirerFeeValue.class, forVariable(variable));
    }

    public QPGAcquirerFeeValue(Path<? extends PGAcquirerFeeValue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGAcquirerFeeValue(PathMetadata<?> metadata) {
        super(PGAcquirerFeeValue.class, metadata);
    }

}

