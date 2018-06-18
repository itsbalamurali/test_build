package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMCCode is a Querydsl query type for PGMCCode
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMCCode extends EntityPathBase<PGMCCode> {

    private static final long serialVersionUID = 1960459090L;

    public static final QPGMCCode pGMCCode = new QPGMCCode("pGMCCode");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath merchantCategoryCode = createString("merchantCategoryCode");

    public QPGMCCode(String variable) {
        super(PGMCCode.class, forVariable(variable));
    }

    public QPGMCCode(Path<? extends PGMCCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMCCode(PathMetadata<?> metadata) {
        super(PGMCCode.class, metadata);
    }

}

