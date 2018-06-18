package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGOtherCommission is a Querydsl query type for PGOtherCommission
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGOtherCommission extends EntityPathBase<PGOtherCommission> {

    private static final long serialVersionUID = 523486764L;

    public static final QPGOtherCommission pGOtherCommission = new QPGOtherCommission("pGOtherCommission");

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final NumberPath<Long> commissionProgramId = createNumber("commissionProgramId", Long.class);

    public final StringPath commissionType = createString("commissionType");

    public final NumberPath<Double> flatFee = createNumber("flatFee", Double.class);

    public final NumberPath<Double> fromValue = createNumber("fromValue", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> toValue = createNumber("toValue", Double.class);

    public QPGOtherCommission(String variable) {
        super(PGOtherCommission.class, forVariable(variable));
    }

    public QPGOtherCommission(Path<? extends PGOtherCommission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGOtherCommission(PathMetadata<?> metadata) {
        super(PGOtherCommission.class, metadata);
    }

}

