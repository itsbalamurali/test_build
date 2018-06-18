package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPGTerminalDeviceMangement is a Querydsl query type for PGTerminalDeviceMangement
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGTerminalDeviceMangement extends EntityPathBase<PGTerminalDeviceMangement> {

    private static final long serialVersionUID = -1420280235L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPGTerminalDeviceMangement pGTerminalDeviceMangement = new QPGTerminalDeviceMangement("pGTerminalDeviceMangement");

    public final StringPath actionCodeParameter = createString("actionCodeParameter");

    public final BooleanPath adjustAllowed = createBoolean("adjustAllowed");

    public final StringPath applicationId = createString("applicationId");

    public final StringPath batchNumber = createString("batchNumber");

    public final StringPath caPublicKeys = createString("caPublicKeys");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> deviceId = createNumber("deviceId", Long.class);

    public final NumberPath<Long> deviceManagementId = createNumber("deviceManagementId", Long.class);

    public final StringPath imeiNo = createString("imeiNo");

    public final StringPath invoiceNumber = createString("invoiceNumber");

    public final StringPath magneticStripeCardParameters = createString("magneticStripeCardParameters");

    public final QPGParameterProfile parameterProfile;

    public final QPGMerchantTerminal pgMerchantTerminal;

    public final BooleanPath preauthAllowed = createBoolean("preauthAllowed");

    public final BooleanPath refundAllowed = createBoolean("refundAllowed");

    public final StringPath remarks = createString("remarks");

    public final StringPath stanNumber = createString("stanNumber");

    public final StringPath status = createString("status");

    public final StringPath terminalConfigurationProfile = createString("terminalConfigurationProfile");

    public final BooleanPath tipAllowed = createBoolean("tipAllowed");

    public final StringPath tipPercentage = createString("tipPercentage");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGTerminalDeviceMangement(String variable) {
        this(PGTerminalDeviceMangement.class, forVariable(variable), INITS);
    }

    public QPGTerminalDeviceMangement(Path<? extends PGTerminalDeviceMangement> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPGTerminalDeviceMangement(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPGTerminalDeviceMangement(PathMetadata<?> metadata, PathInits inits) {
        this(PGTerminalDeviceMangement.class, metadata, inits);
    }

    public QPGTerminalDeviceMangement(Class<? extends PGTerminalDeviceMangement> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parameterProfile = inits.isInitialized("parameterProfile") ? new QPGParameterProfile(forProperty("parameterProfile"), inits.get("parameterProfile")) : null;
        this.pgMerchantTerminal = inits.isInitialized("pgMerchantTerminal") ? new QPGMerchantTerminal(forProperty("pgMerchantTerminal")) : null;
    }

}

