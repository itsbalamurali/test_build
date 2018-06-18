package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGFeeDetail is a Querydsl query type for PGFeeDetail
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGFeeDetail extends EntityPathBase<PGFeeDetail> {

    private static final long serialVersionUID = -1154484664L;

    public static final QPGFeeDetail pGFeeDetail = new QPGFeeDetail("pGFeeDetail");

    public final DateTimePath<java.sql.Timestamp> ceratedDate = createDateTime("ceratedDate", java.sql.Timestamp.class);

    public final NumberPath<Long> feeAmount = createNumber("feeAmount", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath txnType = createString("txnType");

    public QPGFeeDetail(String variable) {
        super(PGFeeDetail.class, forVariable(variable));
    }

    public QPGFeeDetail(Path<? extends PGFeeDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGFeeDetail(PathMetadata<?> metadata) {
        super(PGFeeDetail.class, metadata);
    }

}

