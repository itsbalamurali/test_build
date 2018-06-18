package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgramManager is a Querydsl query type for ProgramManager
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramManager extends EntityPathBase<ProgramManager> {

    private static final long serialVersionUID = 190362785L;

    public static final QProgramManager programManager = new QProgramManager("programManager");

    public final StringPath accountCurrency = createString("accountCurrency");

    public final SetPath<BankProgramManagerMap, QBankProgramManagerMap> bankProgramManagerMaps = this.<BankProgramManagerMap, QBankProgramManagerMap>createSet("bankProgramManagerMaps", BankProgramManagerMap.class, QBankProgramManagerMap.class, PathInits.DIRECT2);

    public final StringPath batchPrefix = createString("batchPrefix");

    public final StringPath businessName = createString("businessName");

    public final SetPath<PmCardProgamMapping, QPmCardProgamMapping> cardProgamMapping = this.<PmCardProgamMapping, QPmCardProgamMapping>createSet("cardProgamMapping", PmCardProgamMapping.class, QPmCardProgamMapping.class, PathInits.DIRECT2);

    public final StringPath companyName = createString("companyName");

    public final StringPath contactEmail = createString("contactEmail");

    public final StringPath contactName = createString("contactName");

    public final StringPath contactPhone = createString("contactPhone");

    public final StringPath country = createString("country");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final BooleanPath defaultProgramManager = createBoolean("defaultProgramManager");

    public final StringPath extension = createString("extension");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> issuancepmid = createNumber("issuancepmid", Long.class);

    public final StringPath pmSystemConvertedTime = createString("pmSystemConvertedTime");

    public final StringPath pmTimeZone = createString("pmTimeZone");

    public final ArrayPath<byte[], Byte> programManagerLogo = createArray("programManagerLogo", byte[].class);

    public final StringPath programManagerName = createString("programManagerName");

    public final StringPath reason = createString("reason");

    public final StringPath schedulerRunTime = createString("schedulerRunTime");

    public final StringPath state = createString("state");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QProgramManager(String variable) {
        super(ProgramManager.class, forVariable(variable));
    }

    public QProgramManager(Path<? extends ProgramManager> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProgramManager(PathMetadata<?> metadata) {
        super(ProgramManager.class, metadata);
    }

}

