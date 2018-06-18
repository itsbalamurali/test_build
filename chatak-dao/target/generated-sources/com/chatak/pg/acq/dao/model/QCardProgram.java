package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCardProgram is a Querydsl query type for CardProgram
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCardProgram extends EntityPathBase<CardProgram> {

    private static final long serialVersionUID = 118331452L;

    public static final QCardProgram cardProgram = new QCardProgram("cardProgram");

    public final NumberPath<Long> cardProgramId = createNumber("cardProgramId", Long.class);

    public final StringPath cardProgramName = createString("cardProgramName");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currency = createString("currency");

    public final NumberPath<Long> iin = createNumber("iin", Long.class);

    public final StringPath iinExt = createString("iinExt");

    public final NumberPath<Long> issuanceCradProgramId = createNumber("issuanceCradProgramId", Long.class);

    public final NumberPath<Long> partnerId = createNumber("partnerId", Long.class);

    public final StringPath partnerIINCode = createString("partnerIINCode");

    public final StringPath partnerName = createString("partnerName");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QCardProgram(String variable) {
        super(CardProgram.class, forVariable(variable));
    }

    public QCardProgram(Path<? extends CardProgram> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCardProgram(PathMetadata<?> metadata) {
        super(CardProgram.class, metadata);
    }

}

