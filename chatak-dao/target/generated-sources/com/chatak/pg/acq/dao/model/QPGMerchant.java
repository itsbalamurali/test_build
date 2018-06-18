package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPGMerchant is a Querydsl query type for PGMerchant
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchant extends EntityPathBase<PGMerchant> {

    private static final long serialVersionUID = -44496681L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPGMerchant pGMerchant = new QPGMerchant("pGMerchant");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath agentAccountNumber = createString("agentAccountNumber");

    public final StringPath agentANI = createString("agentANI");

    public final StringPath agentClientId = createString("agentClientId");

    public final StringPath agentId = createString("agentId");

    public final NumberPath<Integer> allowAdvancedFraudFilter = createNumber("allowAdvancedFraudFilter", Integer.class);

    public final StringPath appMode = createString("appMode");

    public final NumberPath<Long> bankId = createNumber("bankId", Long.class);

    public final StringPath businessName = createString("businessName");

    public final DateTimePath<java.sql.Timestamp> businessStartDate = createDateTime("businessStartDate", java.sql.Timestamp.class);

    public final StringPath businessType = createString("businessType");

    public final StringPath businessURL = createString("businessURL");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final BooleanPath dccEnable = createBoolean("dccEnable");

    public final StringPath declineReason = createString("declineReason");

    public final StringPath emailId = createString("emailId");

    public final NumberPath<Long> estimatedYearlySale = createNumber("estimatedYearlySale", Long.class);

    public final NumberPath<Long> fax = createNumber("fax", Long.class);

    public final StringPath federalTaxId = createString("federalTaxId");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath litleMID = createString("litleMID");

    public final StringPath localCurrency = createString("localCurrency");

    public final StringPath lookingFor = createString("lookingFor");

    public final StringPath mcc = createString("mcc");

    public final StringPath merchantCallBack = createString("merchantCallBack");

    public final StringPath merchantCategory = createString("merchantCategory");

    public final StringPath merchantCode = createString("merchantCode");

    public final QPGMerchantConfig merchantConfig;

    public final StringPath merchantType = createString("merchantType");

    public final StringPath noOfEmployee = createString("noOfEmployee");

    public final StringPath ownership = createString("ownership");

    public final NumberPath<Long> parentMerchantId = createNumber("parentMerchantId", Long.class);

    public final SetPath<PGMerchantCardProgramMap, QPGMerchantCardProgramMap> pgMerchantCardProgramMaps = this.<PGMerchantCardProgramMap, QPGMerchantCardProgramMap>createSet("pgMerchantCardProgramMaps", PGMerchantCardProgramMap.class, QPGMerchantCardProgramMap.class, PathInits.DIRECT2);

    public final SetPath<PGMerchantEntityMap, QPGMerchantEntityMap> pgMerchantEntityMaps = this.<PGMerchantEntityMap, QPGMerchantEntityMap>createSet("pgMerchantEntityMaps", PGMerchantEntityMap.class, QPGMerchantEntityMap.class, PathInits.DIRECT2);

    public final ListPath<PGMerchantUsers, QPGMerchantUsers> pgMerchantUsers = this.<PGMerchantUsers, QPGMerchantUsers>createList("pgMerchantUsers", PGMerchantUsers.class, QPGMerchantUsers.class, PathInits.DIRECT2);

    public final NumberPath<Long> phone = createNumber("phone", Long.class);

    public final StringPath pin = createString("pin");

    public final StringPath reason = createString("reason");

    public final NumberPath<Long> resellerId = createNumber("resellerId", Long.class);

    public final StringPath role = createString("role");

    public final StringPath salesTaxId = createString("salesTaxId");

    public final StringPath state = createString("state");

    public final StringPath stateTaxId = createString("stateTaxId");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath timeZone = createString("timeZone");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath userName = createString("userName");

    public QPGMerchant(String variable) {
        this(PGMerchant.class, forVariable(variable), INITS);
    }

    public QPGMerchant(Path<? extends PGMerchant> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPGMerchant(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPGMerchant(PathMetadata<?> metadata, PathInits inits) {
        this(PGMerchant.class, metadata, inits);
    }

    public QPGMerchant(Class<? extends PGMerchant> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.merchantConfig = inits.isInitialized("merchantConfig") ? new QPGMerchantConfig(forProperty("merchantConfig")) : null;
    }

}

