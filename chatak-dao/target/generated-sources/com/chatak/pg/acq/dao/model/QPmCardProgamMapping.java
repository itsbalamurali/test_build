package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPmCardProgamMapping is a Querydsl query type for PmCardProgamMapping
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPmCardProgamMapping extends EntityPathBase<PmCardProgamMapping> {

    private static final long serialVersionUID = 540630563L;

    public static final QPmCardProgamMapping pmCardProgamMapping = new QPmCardProgamMapping("pmCardProgamMapping");

    public final NumberPath<Long> cardProgramId = createNumber("cardProgramId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> programManagerId = createNumber("programManagerId", Long.class);

    public QPmCardProgamMapping(String variable) {
        super(PmCardProgamMapping.class, forVariable(variable));
    }

    public QPmCardProgamMapping(Path<? extends PmCardProgamMapping> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPmCardProgamMapping(PathMetadata<?> metadata) {
        super(PmCardProgamMapping.class, metadata);
    }

}

