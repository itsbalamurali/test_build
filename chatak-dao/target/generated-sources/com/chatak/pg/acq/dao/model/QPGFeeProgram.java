package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPGFeeProgram is a Querydsl query type for PGFeeProgram
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGFeeProgram extends EntityPathBase<PGFeeProgram> {

    private static final long serialVersionUID = 998571885L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPGFeeProgram pGFeeProgram = new QPGFeeProgram("pGFeeProgram");

    public final ListPath<PGAcquirerFeeValue, QPGAcquirerFeeValue> acquirerFeeValueList = this.<PGAcquirerFeeValue, QPGAcquirerFeeValue>createList("acquirerFeeValueList", PGAcquirerFeeValue.class, QPGAcquirerFeeValue.class, PathInits.DIRECT2);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath feeProgramDescription = createString("feeProgramDescription");

    public final NumberPath<Long> feeProgramId = createNumber("feeProgramId", Long.class);

    public final StringPath feeProgramName = createString("feeProgramName");

    public final QPGOtherFeeValue pgOtherFeeValue;

    public final StringPath processor = createString("processor");

    public final StringPath reason = createString("reason");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGFeeProgram(String variable) {
        this(PGFeeProgram.class, forVariable(variable), INITS);
    }

    public QPGFeeProgram(Path<? extends PGFeeProgram> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPGFeeProgram(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPGFeeProgram(PathMetadata<?> metadata, PathInits inits) {
        this(PGFeeProgram.class, metadata, inits);
    }

    public QPGFeeProgram(Class<? extends PGFeeProgram> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pgOtherFeeValue = inits.isInitialized("pgOtherFeeValue") ? new QPGOtherFeeValue(forProperty("pgOtherFeeValue")) : null;
    }

}

