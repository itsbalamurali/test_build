package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGPosDevice is a Querydsl query type for PGPosDevice
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGPosDevice extends EntityPathBase<PGPosDevice> {

    private static final long serialVersionUID = 2034258075L;

    public static final QPGPosDevice pGPosDevice = new QPGPosDevice("pGPosDevice");

    public final com.chatak.pg.bean.QSearchRequest _super = new com.chatak.pg.bean.QSearchRequest(this);

    //inherited
    public final NumberPath<Long> agentAccountNumber = _super.agentAccountNumber;

    //inherited
    public final StringPath agentAni = _super.agentAni;

    //inherited
    public final StringPath agentClientId = _super.agentClientId;

    //inherited
    public final ListPath<com.chatak.pg.model.AgentDTO, SimplePath<com.chatak.pg.model.AgentDTO>> agentDTOlist = _super.agentDTOlist;

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

    public final StringPath deviceMake = createString("deviceMake");

    public final StringPath deviceModel = createString("deviceModel");

    public final StringPath deviceSerialNo = createString("deviceSerialNo");

    //inherited
    public final StringPath deviceTimeZoneOffset = _super.deviceTimeZoneOffset;

    //inherited
    public final StringPath deviceTimeZoneRegion = _super.deviceTimeZoneRegion;

    public final StringPath deviceType = createString("deviceType");

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

    public final StringPath status = createString("status");

    //inherited
    public final StringPath timeZoneOffset = _super.timeZoneOffset;

    //inherited
    public final StringPath timeZoneRegion = _super.timeZoneRegion;

    //inherited
    public final NumberPath<Integer> totalNoOfRows = _super.totalNoOfRows;

    //inherited
    public final NumberPath<Long> txnResponseTime = _super.txnResponseTime;

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

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

    public QPGPosDevice(String variable) {
        super(PGPosDevice.class, forVariable(variable));
    }

    public QPGPosDevice(Path<? extends PGPosDevice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGPosDevice(PathMetadata<?> metadata) {
        super(PGPosDevice.class, metadata);
    }

}

