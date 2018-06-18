package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGParameterMagstripe is a Querydsl query type for PGParameterMagstripe
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGParameterMagstripe extends EntityPathBase<PGParameterMagstripe> {

    private static final long serialVersionUID = -732959226L;

    public static final QPGParameterMagstripe pGParameterMagstripe = new QPGParameterMagstripe("pGParameterMagstripe");

    public final StringPath cardLabel = createString("cardLabel");

    public final NumberPath<Long> cardRangeHigh = createNumber("cardRangeHigh", Long.class);

    public final NumberPath<Long> cardRangeLow = createNumber("cardRangeLow", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> magstripeId = createNumber("magstripeId", Long.class);

    public final StringPath magstripeName = createString("magstripeName");

    public final StringPath panLength = createString("panLength");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGParameterMagstripe(String variable) {
        super(PGParameterMagstripe.class, forVariable(variable));
    }

    public QPGParameterMagstripe(Path<? extends PGParameterMagstripe> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGParameterMagstripe(PathMetadata<?> metadata) {
        super(PGParameterMagstripe.class, metadata);
    }

}

