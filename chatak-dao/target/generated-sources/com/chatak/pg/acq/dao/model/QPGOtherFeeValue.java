package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGOtherFeeValue is a Querydsl query type for PGOtherFeeValue
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGOtherFeeValue extends EntityPathBase<PGOtherFeeValue> {

    private static final long serialVersionUID = -718930164L;

    public static final QPGOtherFeeValue pGOtherFeeValue = new QPGOtherFeeValue("pGOtherFeeValue");

    public final NumberPath<Long> chargeBackFee = createNumber("chargeBackFee", Long.class);

    public final StringPath chargeFrequency = createString("chargeFrequency");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> settlementFee = createNumber("settlementFee", Long.class);

    public final NumberPath<Long> setupFee = createNumber("setupFee", Long.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGOtherFeeValue(String variable) {
        super(PGOtherFeeValue.class, forVariable(variable));
    }

    public QPGOtherFeeValue(Path<? extends PGOtherFeeValue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGOtherFeeValue(PathMetadata<?> metadata) {
        super(PGOtherFeeValue.class, metadata);
    }

}

