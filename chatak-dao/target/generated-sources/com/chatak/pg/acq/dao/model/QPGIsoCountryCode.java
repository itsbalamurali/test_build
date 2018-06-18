package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGIsoCountryCode is a Querydsl query type for PGIsoCountryCode
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGIsoCountryCode extends EntityPathBase<PGIsoCountryCode> {

    private static final long serialVersionUID = 1384329389L;

    public static final QPGIsoCountryCode pGIsoCountryCode = new QPGIsoCountryCode("pGIsoCountryCode");

    public final com.chatak.pg.bean.QSearchRequest _super = new com.chatak.pg.bean.QSearchRequest(this);

    //inherited
    public final NumberPath<Long> agentAccountNumber = _super.agentAccountNumber;

    //inherited
    public final StringPath agentAni = _super.agentAni;

    //inherited
    public final StringPath agentClientId = _super.agentClientId;

    //inherited
    public final ListPath<com.chatak.pg.model.AgentDTO, SimplePath<com.chatak.pg.model.AgentDTO>> agentDTOlist = _super.agentDTOlist;

    public final StringPath code = createString("code");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    //inherited
    public final StringPath currencyCodeAlpha = _super.currencyCodeAlpha;

    //inherited
    public final StringPath currencyCodeNumeric = _super.currencyCodeNumeric;

    //inherited
    public final NumberPath<Long> currencyId = _super.currencyId;

    //inherited
    public final StringPath dataChange = _super.dataChange;

    //inherited
    public final StringPath deviceTimeZoneOffset = _super.deviceTimeZoneOffset;

    //inherited
    public final StringPath deviceTimeZoneRegion = _super.deviceTimeZoneRegion;

    //inherited
    public final StringPath emv = _super.emv;

    //inherited
    public final StringPath entityType = _super.entityType;

    //inherited
    public final StringPath errorCode = _super.errorCode;

    //inherited
    public final StringPath errorMessage = _super.errorMessage;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final BooleanPath isAuditable = _super.isAuditable;

    //inherited
    public final StringPath issuancePartner = _super.issuancePartner;

    //inherited
    public final StringPath issuanceTxnTime = _super.issuanceTxnTime;

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Integer> noOfRecords = _super.noOfRecords;

    //inherited
    public final NumberPath<Integer> pageIndex = _super.pageIndex;

    //inherited
    public final NumberPath<Integer> pageSize = _super.pageSize;

    //inherited
    public final NumberPath<Long> parentMerchantId = _super.parentMerchantId;

    //inherited
    public final NumberPath<Long> partnerId = _super.partnerId;

    //inherited
    public final StringPath partnerName = _super.partnerName;

    //inherited
    public final StringPath programManagerName = _super.programManagerName;

    //inherited
    public final StringPath reason = _super.reason;

    //inherited
    public final StringPath timeZoneOffset = _super.timeZoneOffset;

    //inherited
    public final StringPath timeZoneRegion = _super.timeZoneRegion;

    //inherited
    public final NumberPath<Integer> totalNoOfRows = _super.totalNoOfRows;

    //inherited
    public final NumberPath<Long> txnResponseTime = _super.txnResponseTime;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedDate = _super.updatedDate;

    //inherited
    public final StringPath upStreamAuthCode = _super.upStreamAuthCode;

    //inherited
    public final StringPath upStreamMessage = _super.upStreamMessage;

    //inherited
    public final StringPath upStreamResponse = _super.upStreamResponse;

    //inherited
    public final NumberPath<Integer> upStreamStatus = _super.upStreamStatus;

    //inherited
    public final StringPath upStreamTxnRefNum = _super.upStreamTxnRefNum;

    //inherited
    public final StringPath userName = _super.userName;

    public QPGIsoCountryCode(String variable) {
        super(PGIsoCountryCode.class, forVariable(variable));
    }

    public QPGIsoCountryCode(Path<? extends PGIsoCountryCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGIsoCountryCode(PathMetadata<?> metadata) {
        super(PGIsoCountryCode.class, metadata);
    }

}

