package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGFeeProgramValue is a Querydsl query type for PGFeeProgramValue
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGFeeProgramValue extends EntityPathBase<PGFeeProgramValue> {

    private static final long serialVersionUID = 967589380L;

    public static final QPGFeeProgramValue pGFeeProgramValue = new QPGFeeProgramValue("pGFeeProgramValue");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> feeCode = createNumber("feeCode", Long.class);

    public final NumberPath<Long> feeMaxValue = createNumber("feeMaxValue", Long.class);

    public final NumberPath<Long> feeMinValue = createNumber("feeMinValue", Long.class);

    public final NumberPath<Long> feePercentageOnly = createNumber("feePercentageOnly", Long.class);

    public final NumberPath<Long> feePgmValueId = createNumber("feePgmValueId", Long.class);

    public final NumberPath<Long> feeProgramId = createNumber("feeProgramId", Long.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGFeeProgramValue(String variable) {
        super(PGFeeProgramValue.class, forVariable(variable));
    }

    public QPGFeeProgramValue(Path<? extends PGFeeProgramValue> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGFeeProgramValue(PathMetadata<?> metadata) {
        super(PGFeeProgramValue.class, metadata);
    }

}

