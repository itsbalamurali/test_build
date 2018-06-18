package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGFeeCode is a Querydsl query type for PGFeeCode
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGFeeCode extends EntityPathBase<PGFeeCode> {

    private static final long serialVersionUID = -269378140L;

    public static final QPGFeeCode pGFeeCode = new QPGFeeCode("pGFeeCode");

    public final NumberPath<Long> feeCode = createNumber("feeCode", Long.class);

    public final StringPath feeDescription = createString("feeDescription");

    public final StringPath feeShortCode = createString("feeShortCode");

    public final StringPath txnResponseCode = createString("txnResponseCode");

    public final StringPath txnShortCode = createString("txnShortCode");

    public QPGFeeCode(String variable) {
        super(PGFeeCode.class, forVariable(variable));
    }

    public QPGFeeCode(Path<? extends PGFeeCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGFeeCode(PathMetadata<?> metadata) {
        super(PGFeeCode.class, metadata);
    }

}

