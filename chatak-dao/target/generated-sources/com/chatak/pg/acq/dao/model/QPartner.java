package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPartner is a Querydsl query type for Partner
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPartner extends EntityPathBase<Partner> {

    private static final long serialVersionUID = -819298384L;

    public static final QPartner partner = new QPartner("partner");

    public final StringPath accountCurrency = createString("accountCurrency");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final SetPath<BankPartnerMap, QBankPartnerMap> bankPartnerMaps = this.<BankPartnerMap, QBankPartnerMap>createSet("bankPartnerMaps", BankPartnerMap.class, QBankPartnerMap.class, PathInits.DIRECT2);

    public final StringPath businessEntityName = createString("businessEntityName");

    public final StringPath city = createString("city");

    public final StringPath companyName = createString("companyName");

    public final StringPath contactPerson = createString("contactPerson");

    public final StringPath contactPhone = createString("contactPhone");

    public final StringPath country = createString("country");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath extension = createString("extension");

    public final SetPath<PartnerAccount, QPartnerAccount> partnerAccounts = this.<PartnerAccount, QPartnerAccount>createSet("partnerAccounts", PartnerAccount.class, QPartnerAccount.class, PathInits.DIRECT2);

    public final StringPath partnerClientId = createString("partnerClientId");

    public final NumberPath<Long> partnerId = createNumber("partnerId", Long.class);

    public final ArrayPath<byte[], Byte> partnerLogo = createArray("partnerLogo", byte[].class);

    public final StringPath partnerName = createString("partnerName");

    public final StringPath partnerType = createString("partnerType");

    public final NumberPath<Long> programManagerId = createNumber("programManagerId", Long.class);

    public final StringPath reason = createString("reason");

    public final StringPath state = createString("state");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath whiteListIPAddress = createString("whiteListIPAddress");

    public final StringPath zip = createString("zip");

    public QPartner(String variable) {
        super(Partner.class, forVariable(variable));
    }

    public QPartner(Path<? extends Partner> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPartner(PathMetadata<?> metadata) {
        super(Partner.class, metadata);
    }

}

