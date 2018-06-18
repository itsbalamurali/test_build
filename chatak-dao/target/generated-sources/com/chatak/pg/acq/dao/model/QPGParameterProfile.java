package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPGParameterProfile is a Querydsl query type for PGParameterProfile
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGParameterProfile extends EntityPathBase<PGParameterProfile> {

    private static final long serialVersionUID = -1269142065L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPGParameterProfile pGParameterProfile = new QPGParameterProfile("pGParameterProfile");

    public final StringPath attended = createString("attended");

    public final BooleanPath attendFinancialInstitute = createBoolean("attendFinancialInstitute");

    public final BooleanPath attendMerchant = createBoolean("attendMerchant");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currencyCode = createString("currencyCode");

    public final StringPath defaultCdol = createString("defaultCdol");

    public final StringPath defaultDdol = createString("defaultDdol");

    public final StringPath defaultTdol = createString("defaultTdol");

    public final StringPath isoCountryCode = createString("isoCountryCode");

    public final StringPath localCurrencyCode = createString("localCurrencyCode");

    public final StringPath maxTargetPercentage = createString("maxTargetPercentage");

    public final StringPath parameterType = createString("parameterType");

    public final NumberPath<Long> profileId = createNumber("profileId", Long.class);

    public final StringPath profileName = createString("profileName");

    public final StringPath reason = createString("reason");

    public final StringPath status = createString("status");

    public final StringPath targetPercentage = createString("targetPercentage");

    public final QPGTerminalCapabilities terminalCapabilities;

    public final StringPath terminalFloorLimit = createString("terminalFloorLimit");

    public final StringPath terminalType = createString("terminalType");

    public final BooleanPath unAttendCardHolder = createBoolean("unAttendCardHolder");

    public final StringPath unAttended = createString("unAttended");

    public final BooleanPath unAttendfinancialInstitute = createBoolean("unAttendfinancialInstitute");

    public final BooleanPath unAttendMerchant = createBoolean("unAttendMerchant");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGParameterProfile(String variable) {
        this(PGParameterProfile.class, forVariable(variable), INITS);
    }

    public QPGParameterProfile(Path<? extends PGParameterProfile> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPGParameterProfile(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPGParameterProfile(PathMetadata<?> metadata, PathInits inits) {
        this(PGParameterProfile.class, metadata, inits);
    }

    public QPGParameterProfile(Class<? extends PGParameterProfile> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.terminalCapabilities = inits.isInitialized("terminalCapabilities") ? new QPGTerminalCapabilities(forProperty("terminalCapabilities")) : null;
    }

}

