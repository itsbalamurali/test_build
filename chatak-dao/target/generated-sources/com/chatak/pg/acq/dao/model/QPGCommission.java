package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPGCommission is a Querydsl query type for PGCommission
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGCommission extends EntityPathBase<PGCommission> {

    private static final long serialVersionUID = 1465201722L;

    public static final QPGCommission pGCommission = new QPGCommission("pGCommission");

    public final StringPath commissionName = createString("commissionName");

    public final NumberPath<Long> commissionProgramId = createNumber("commissionProgramId", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Double> merchantOnBoardingFee = createNumber("merchantOnBoardingFee", Double.class);

    public final ListPath<PGOtherCommission, QPGOtherCommission> OtherCommission = this.<PGOtherCommission, QPGOtherCommission>createList("OtherCommission", PGOtherCommission.class, QPGOtherCommission.class, PathInits.DIRECT2);

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGCommission(String variable) {
        super(PGCommission.class, forVariable(variable));
    }

    public QPGCommission(Path<? extends PGCommission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGCommission(PathMetadata<?> metadata) {
        super(PGCommission.class, metadata);
    }

}

