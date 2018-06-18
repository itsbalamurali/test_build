package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGBlackListedCard is a Querydsl query type for PGBlackListedCard
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGBlackListedCard extends EntityPathBase<PGBlackListedCard> {

    private static final long serialVersionUID = -810020387L;

    public static final QPGBlackListedCard pGBlackListedCard = new QPGBlackListedCard("pGBlackListedCard");

    public final NumberPath<java.math.BigInteger> cardNumber = createNumber("cardNumber", java.math.BigInteger.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath reason = createString("reason");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QPGBlackListedCard(String variable) {
        super(PGBlackListedCard.class, forVariable(variable));
    }

    public QPGBlackListedCard(Path<? extends PGBlackListedCard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGBlackListedCard(PathMetadata<?> metadata) {
        super(PGBlackListedCard.class, metadata);
    }

}

