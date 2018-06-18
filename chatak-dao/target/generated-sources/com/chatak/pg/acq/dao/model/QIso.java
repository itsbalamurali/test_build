package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QIso is a Querydsl query type for Iso
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QIso extends EntityPathBase<Iso> {

    private static final long serialVersionUID = -1891307667L;

    public static final QIso iso = new QIso("iso");

    public final StringPath address = createString("address");

    public final StringPath businessEntityName = createString("businessEntityName");

    public final StringPath city = createString("city");

    public final StringPath contactPerson = createString("contactPerson");

    public final StringPath country = createString("country");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currency = createString("currency");

    public final StringPath email = createString("email");

    public final StringPath extension = createString("extension");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ArrayPath<byte[], Byte> isoLogo = createArray("isoLogo", byte[].class);

    public final StringPath isoName = createString("isoName");

    public final SetPath<IsoCardProgramMap, QIsoCardProgramMap> pgIsoCardProgramMap = this.<IsoCardProgramMap, QIsoCardProgramMap>createSet("pgIsoCardProgramMap", IsoCardProgramMap.class, QIsoCardProgramMap.class, PathInits.DIRECT2);

    public final SetPath<IsoPmMap, QIsoPmMap> pgIsoPmMap = this.<IsoPmMap, QIsoPmMap>createSet("pgIsoPmMap", IsoPmMap.class, QIsoPmMap.class, PathInits.DIRECT2);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath reason = createString("reason");

    public final StringPath state = createString("state");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath zipCode = createString("zipCode");

    public QIso(String variable) {
        super(Iso.class, forVariable(variable));
    }

    public QIso(Path<? extends Iso> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIso(PathMetadata<?> metadata) {
        super(Iso.class, metadata);
    }

}

