<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><spring:message code="common.lable.title"/></title>
<!-- Bootstrap -->
<link rel="icon" href="../images/favicon.png" type="image/png">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link href="../css/jquery.datetimepicker.css" rel="stylesheet"
	type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
</head>
<body>
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<div class="container-fluid">
			<!--Header Block Start -->
			<jsp:include page="header.jsp"></jsp:include>
			<!--Navigation Block Start -->
			<nav class="col-sm-12 nav-bar" id="main-navigation">
			<jsp:include page="navigation-panel.jsp"></jsp:include> 
			</nav>
			<!--Navigation Block End -->
			<!--Article Block Start-->
			<article>
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text"><spring:message code="search-sub-merchant.label.submerchant"/></span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text"><spring:message code="sub-merchant-view.label.view"/></span>
					</div>
					<!-- Tab Buttons Start -->
					<div class="tab-header-container-first">
						<a href="search-sub-merchant"><spring:message code="search-sub-merchant.lable.search"/></a>
					</div>
					<div class="tab-header-container active-background">
						<a href="#"><spring:message code="sub-merchant-view.label.view"/></a>
					</div>
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<div class="main-content-holder padding0">
						<!-- Page Menu Start -->
						<div class="col-sm-12 padding0">
							<div class="sub-nav">
								<ul>
									<li class="account-details-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="merchant-circle-tab active-circle"></span>
										</div> <label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.basicinfo"/></label>
										<div class="arrow-down merchant-arrow"></div>
									</li>
									<li class="bank-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="bank-info-circle-tab"></span>
										</div> <label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.bankinfo"/> </label>
										<div class="arrow-down bank-info-arrow"></div>
									</li>
									<li class="legal-entiy-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="legal-circle-tab"></span>
										</div> <label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.legalentityrepresentative"/></label>
										<div class="arrow-down legal-arrow"></div>
									</li>
									<li class="legal-entiy-rep-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="legal-circle-rep-tab"></span>
										</div> <label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.legalentity"/></label>
										<div class="arrow-down legal-rep-arrow"></div>
									</li>
									<li class="free-transactions-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="contact-circle-tab"></span>
										</div> <label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.additionalinfo"/></label>
										<div class="arrow-down contact-arrow"></div>
									</li>
									<li class="atm-transactions-list">
										<div class="circle-div">
											<div class="hr"></div>
											<span class="bank-circle-tab"></span>
										</div> <label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.configurations"/></label>
										<div class="arrow-down configuration-arrow"></div>
									</li>
								</ul>
							</div>
						</div>
						<!-- Page Menu End -->
						<div class="row margin0">
							<div class="col-sm-12">
								<!--Success and Failure Message Start-->
								<div class="col-xs-12">
									<div class="discriptionErrorMsg col-xs-12">
										<span class="red-error">&nbsp;${error }</span> <span
											class="green-error">&nbsp;${success }</span>
									</div>
								</div>
								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form action="sub-merchant-update" commandName="merchant"
									name="merchant">
									<input type="hidden" name="CSRFToken" value="${tokenval}">
									<div class="col-sm-12 paddingT20">
										<div class="row">
											<!-- Account Details Content Start -->
											<section class="field-element-row account-details-content" style="display:none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.companyname"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="businessName"
															id="businessName" maxlength="50"
															onblur="validateBusinessName()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="businessNameEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-update.label.merchantcode"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="merchantCode"
															id="merchantCode" maxlength="50"
															onblur="validateMerchantCode()" readonly="true" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="merchantCodeEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.firstname"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="firstName"
															id="firstName" maxlength="50"
															onblur="validateFirstName()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="firstNameEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.lastname"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="lastName"
															id="lastName" maxlength="50" onblur="validateLastName()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="lastNameEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.phone"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="phone"
															id="phone" maxlength="10" onblur="validatePhone()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="phoneEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.fax"/></label>
														<form:input cssClass="form-control" path="fax" id="fax" onkeypress="return amountValidate(this,event)"
															maxlength="13" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="faxEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.e-mailid"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="emailId"
															id="emailId" onblur="validateEmailIdEdit()"  />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="emailIdEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.address1"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="address1"
															id="address1" maxlength="50" onblur="validateAddress1()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="address1Er" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.address2"/></label>
														<form:input cssClass="form-control" path="address2"
															id="address2" maxlength="50" onblur="validateAddress2()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="address2Er" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.city"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="city" id="city"
															maxlength="50" onblur="validateCity()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="cityEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.country"/><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="country"
															id="country" onblur="validateCountry()"
															onchange="fetchMerchantState(this.value, 'state')">
															<form:option value="">..:<spring:message code="sub-merchant-create.label.select"/>:..</form:option>
															<c:forEach items="${countryList}" var="country">
																<form:option value="${country.label}">${country.label}</form:option>
															</c:forEach>
														</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="countryEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.state"/><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="state"
															id="state" onblur="validateState()">
															<form:option value="">..:<spring:message code="sub-merchant-create.label.select"/>:..</form:option>
															<c:forEach items="${stateList}" var="item">
																<form:option value="${item.label}">${item.label}</form:option>
															</c:forEach>
														</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="stateEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>

													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.zipcode"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="pin" id="pin"
															maxlength="10" onblur="validatePin()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="pinEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<%-- <fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.status"/><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="status"
															id="status" onblur="validateStatus()">
															<form:option value="">..:<spring:message code="sub-merchant-create.label.select"/>:..</form:option>
															<form:option value="1"><spring:message code="search-sub-merchant.lable.pending"/></form:option>
															<form:option value="0"><spring:message code="search-sub-merchant.lable.active"/></form:option>
															<form:option value="2"><spring:message code="search-sub-merchant.lable.inactive"/></form:option>
														</form:select>
														<form:hidden path="merchantType" id="merchantType" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="statusEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset> --%>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.applicationmode"/><span
															class="required-field">*</span></label>
														<form:select cssClass="form-control" path="appMode"
															id="appMode" onblur="validateAppMode()">
															<form:option value="">..:<spring:message code="sub-merchant-create.label.select"/>:..</form:option>
															<form:option value="DEMO"><spring:message code="sub-merchant-create.label.demo"/></form:option>
															<form:option value="PRELIVE"><spring:message code="sub-merchant-create.label.pre-live"/></form:option>
															<form:option value="LIVE"><spring:message code="sub-merchant-create.label.live"/></form:option>
														</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="appModeEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.businessURL"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="businessURL"
															maxlength="50" id="businessURL" onclick="validateURL()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="businessURLEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
														<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.lookingfor"></spring:message>?</label>
														<form:textarea cssClass="form-control" path="lookingFor" readonly="true"
															id="lookingFor" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="lookingForEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
														<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.businesstype"/></label>
														<form:select cssClass="form-control" path="businessType" disabled="disabled"
															id="businessType" >
															<form:option value="">.:<spring:message code="sub-merchant-create.label.chooseatype"/>:.</form:option>
															<form:option value="Airline"><spring:message code="sub-merchant-create.label.airline"/></form:option>
															<form:option value="Auto Rental"><spring:message code="sub-merchant-create.label.autorental"/></form:option>
															<form:option value="Clothing Stores"><spring:message code="sub-merchant-create.label.clothingstores"/></form:option>
															<form:option value="Department Stores"><spring:message code="sub-merchant-create.label.departmentstores"/></form:option>
															<form:option value="Deposit Transactions"><spring:message code="sub-merchant-create.label.deposittransactions"/></form:option>
															<form:option value="Discount Stores"><spring:message code="sub-merchant-create.label.discountstores"/></form:option>
															<form:option value="Drug Stores"><spring:message code="sub-merchant-create.label.drugstores"/></form:option>
															<form:option value="Education"><spring:message code="sub-merchant-create.label.education"/></form:option>
															<form:option value="Electric-Appliance"><spring:message code="sub-merchant-create.label.electric-appliance"/></form:option>
															<form:option value="Food Stores-Warehouse"><spring:message code="sub-merchant-create.label.foodstores-warehouse"/></form:option>
															<form:option value="Gas Stations"><spring:message code="sub-merchant-create.label.gasstations"/></form:option>
															<form:option value="Hardware"><spring:message code="sub-merchant-create.label.hardware"/></form:option>
															<form:option value="Health Care"><spring:message code="sub-merchant-create.label.healthcare"/></form:option>
															<form:option value="Hotel-Motel"><spring:message code="sub-merchant-create.label.hotel-motel"/></form:option>
															<form:option value="Interior Furnishings"><spring:message code="sub-merchant-create.label.interiorfurnishings"/></form:option>
															<form:option value="Other Retail"><spring:message code="sub-merchant-create.label.otherretail"/></form:option>
															<form:option value="Other Services"><spring:message code="sub-merchant-create.label.otherservices"/></form:option>
															<form:option value="Other Transport"><spring:message code="sub-merchant-create.label.othertransport"/></form:option>
															<form:option value="Professional Services"><spring:message code="sub-merchant-create.label.professionalservices"/></form:option>
															<form:option value="Recreation"><spring:message code="sub-merchant-create.label.recreation"/></form:option>
															<form:option value="Repair Shops"><spring:message code="sub-merchant-create.label.repairshops"/></form:option>
															<form:option value="Restaurants-Bars"><spring:message code="sub-merchant-create.label.restaurants-bars"/></form:option>
															<form:option value="Sporting-Toy Stores"><spring:message code="sub-merchant-create.label.sporting-toystores"/></form:option>
															<form:option value="Vehicles"><spring:message code="sub-merchant-create.label.vehicles"/></form:option>
															</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="businessTypeEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message
																code="merchant.merchantName.message" /><span
															class="required-field">*</span></label>
														<form:input path="parentMerchantName" id="parentMerchantName" readonly="true" cssClass="form-control" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="parentMerchantNameEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right acc-next"
															value="<spring:message code="sub-merchant-create.label.continue"></spring:message>"> <input type="button"
															class="form-control button pull-right marginL10"
															value="<spring:message code="sub-merchant-create.label.cancel"></spring:message>" onclick="cancelCreateMerchant()">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!-- Account Details Content End -->
											<section class="field-element-row bank-info-details-content" style="display:none;">
												<fieldset class="col-sm-12">													
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.name"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="bankAccountName"
															id="bankAccountName" maxlength="50" 
															onblur="return clientValidation('bankAccountName', 'first_name_SplChar','bankAccountNameErrorDiv');"/>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankAccountNameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.bankroutingnumber"></spring:message><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="bankRoutingNumber"
															id="bankRoutingNumber" maxlength="9" onkeypress="return amountValidate(this,event)"
															onblur="return clientValidation('bankRoutingNumber', 'routing_number','bankRoutingNumberEr');"/>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankRoutingNumberEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.bankaccountnumber"></spring:message><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="bankAccountNumber" id="bankAccountNumber" 
														 onblur="return clientValidation('bankAccountNumber', 'account_numberBank','bankAccountNumberErrorDiv');" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankAccountNumberErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="dash-board.label.type"></spring:message><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="bankAccountType"
															id="bankAccountType" onblur="return clientValidation('bankAccountType', 'account_type','bankAccountTypeErrorDiv');">
															<form:option value="">..:<spring:message code="sub-merchant-create.label.select"></spring:message>:..</form:option>
															<form:option value="S"><spring:message code="sub-merchant-create.label.savings"></spring:message></form:option>
															<form:option value="C"><spring:message code="sub-merchant-create.label.checking"></spring:message></form:option>
														</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankAccountTypeErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.address1"/></label>
														<form:input cssClass="form-control" path="bankAddress1"
															id="bankAddress1" maxlength="50" onblur="return clientValidation('bankAddress1', 'bank_address2','bankAddress1ErrorDiv');" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankAddress1ErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.address2"/></label>
														<form:input cssClass="form-control" path="bankAddress2"
															id="bankAddress2" maxlength="50" onblur="return clientValidation('bankAddress2', 'bank_address2','bankAddress2ErrorDiv');" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankAddress2ErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.city"></spring:message><!-- <span class="required-field">*</span> --></label>
														<form:input cssClass="form-control" path="bankCity" id="bankCity" maxlength="50" 
														onblur="return clientValidation('bankCity', 'bank_address2','bankCityErrorDiv');"  />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankCityErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.country"></spring:message><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="bankCountry"
															id="bankCountry" onblur="return clientValidation('bankCountry', 'country','bankCountryErrorDiv');"
															onchange="fetchMerchantState(this.value, 'bankState')">
															<form:option value="">..:<spring:message code="sub-merchant-create.label.select"></spring:message>:..</form:option>
															<c:forEach items="${countryList}" var="country">
																<form:option value="${country.label}">${country.label}</form:option>
															</c:forEach>
														</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankCountryErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.state"></spring:message><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="bankState"
															id="bankState" onblur="return clientValidation('bankState', 'state','bankStateErrorDiv');">
															<form:option value="">..:<spring:message code="sub-merchant-create.label.select"></spring:message>:..</form:option>
															<c:forEach items="${bankStateList}" var="item">
																<form:option value="${item.label}">${item.label}</form:option>
															</c:forEach>

														</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankStateErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>

													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.zipcode"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="bankPin" id="bankPin"
															maxlength="10" onblur="return clientValidation('bankPin', 'zip_code','bankPinErrorDiv');"/>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankPinErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.nameonaccount"/><span
															class="required-field">*</span></label>
														
														<form:input cssClass="form-control" path="bankNameOnAccount"
															id="bankNameOnAccount" onblur="return clientValidation('bankNameOnAccount', 'first_name_SplChar','bankNameOnAccountErrorDiv');"/>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="bankNameOnAccountErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label><spring:message code="sub-merchant-create.label.merchantcurrency"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="currencyId"
															id="currencyId" onchange="fetchCurrency(this.value,'currencyId')" readonly="true" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="currencyIDErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right bank-next"
															value="<spring:message code="sub-merchant-create.label.continue"></spring:message>"> <input type="button"
															class="form-control button pull-right marginL10 bank-prev"
															value="<spring:message code="sub-merchant-create.label.previous"></spring:message>">  <input
															type="button"
															class="form-control button pull-right marginL10"
															value="<spring:message code="sub-merchant-create.label.cancel"></spring:message>" onclick="cancelCreateMerchant()">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<section class="field-element-row legal-details-content" style="display:none;">
												<fieldset class="col-sm-12">													
													
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.ssn"/></label>
														<form:input cssClass="form-control" path="legalSSN" onkeypress="return amountValidate(this,event)"
															id="legalSSN" maxlength="20" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="legalSSNErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.firstname"/></label>
														<form:input cssClass="form-control" path="legalFirstName"
															id="legalFirstName" maxlength="50" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="legalFirstNameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.lastname"/></label>
														<form:input cssClass="form-control" path="legalLastName"
															id="legalLastName" maxlength="50" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="legalLastNameErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="search-sub-merchant.label.phone"/></label>
														<form:input cssClass="form-control" path="legalMobilePhone" maxlength="10"
															id="legalMobilePhone" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="legalMobilePhoneErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>		
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""> <spring:message code="sub-merchant-create.label.dateofbirth"/></label>
														<div class="input-group focus-field">
															<form:input cssClass="form-control effectiveDate"
																path="legalDOB" id="legalDOB"
																/>
															<span class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span></span>
														</div>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="legalDOBErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.passportnumber"/></label>
														<form:input cssClass="form-control" path="legalPassport"
															id="legalPassport" maxlength="20" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="legalPassportErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.countryofresidence"/><!-- <span class="required-field">*</span> --></label>
														<form:input cssClass="form-control" path="legalCountryResidence"
															id="legalCountryResidence" maxlength="50"/>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="legalCountryResidenceErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.countryofcitizenship"/></label>
														<form:input cssClass="form-control" path="legalCitizen"
															id="legalCitizen" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="legalCitizenErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="sub-merchant-create.label.homephone"/></label>
														<form:input cssClass="form-control" path="legalHomePhone" onkeypress="return amountValidate(this,event)"
															id="legalHomePhone" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="legalHomePhoneErrorDiv" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															class="form-control button pull-right legal-next"
															value="<spring:message code="sub-merchant-create.label.continue"></spring:message>"> <input type="button"
															class="form-control button pull-right marginL10 legal-prev"
															value="<spring:message code="sub-merchant-create.label.previous"></spring:message>">  <input
															type="button"
															class="form-control button pull-right marginL10"
															value="<spring:message code="sub-merchant-create.label.cancel"></spring:message>" onclick="cancelCreateMerchant()">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>
											<!--Legal Entity Content Ends  -->
											<!-- Legal Details Content Start -->
											<jsp:include page="legal-entity-view.jsp"></jsp:include>
											<!-- Free Transactions Content Start -->
											<jsp:include page="additional-information-view.jsp"></jsp:include>
											<!-- Free Transactions Content End -->
											<!-- ATM Transactions Content Start -->
											<jsp:include page="configurations-view.jsp"></jsp:include>
											<!-- ATM Transactions Content End -->
										</div>
									</div>
								</form:form>
								<input type="hidden" id="linkedPartnerId" value=${merchant.issuancePartnerId} />
								<input type="hidden" id="linkedAgentId" value=${merchant.agentId} />
								<!-- Page Form End -->
							</div>
						</div>
					</div>
					<!-- Content Block End -->
				</div>
			</article>
			<!--Article Block End-->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
		<!--Container block End -->
	</div>
	<!--Body Wrapper block End -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script> <script src="../js/utils.js"></script>
	<script src="../js/jquery.datetimepicker.js"></script>
	<script src="../js/common-lib.js"></script>
	<script src="../js/validation.js"></script>
	<script type="text/javascript" src="../js/merchant.js"></script>
	<script type="text/javascript" src="../js/chatak-ajax.js"></script>
	<script type="text/javascript" src="../js/backbutton.js"></script>
	<script type="text/javascript" src="../js/browser-close.js"></script>
	<script>
		/* Common Navigation Include Start */
		/* window.onload = function() {
			populatedropdown("autoTransferDay");
		} */
		$(function() {
			//$("#main-navigation").load("main-navigation.html");
		});
		function highlightMainContent() {
			$("#navListId3").addClass("active-background");
		}
		/* Common Navigation Include End */
		/* DatePicker Javascript Strat*/
		$(document).ready(function() {
			/* populatePartnerAndAgentDetails($('#appMode').val(),'sub-merchant','view'); */
			$(".form-control, input[type=radio], input[type=checkbox], input[type=file]").attr("disabled", "disabled");
			$(".button").removeAttr("disabled");

			if("${merchant.processor}" =="LITLE"){
				$('#vantivMerchantId').show();
			}
			
			if("${merchant.autoTransferDay}" =="M"){
				 $('#monthlySettlement').show();
			 }
			 if("${merchant.autoTransferDay}" =="W"){
				 $('#weeklySettlement').show();
			 }

			loadRadio('${merchant.autoSettlement}');
		        if ($('#status').val()==1){
		            $('#status').attr('disabled','disabled');
		        }
		        else{
		            $('#status').removeAttr('disabled');
		            $('#status').children('option[value="1"]').css('display','none');
		        }
		   	 if ($('#status').val()!=3){
				 $('#status').children('option[value="3"]').css('display','none');
		     } 
		  
			$(".focus-field").click(function() {
				$(this).children('.effectiveDate').focus();
			});
			$('.effectiveDate').datetimepicker({
				timepicker : false,
				format : 'd/m/Y',
				formatDate : 'Y/m/d',
			});
			showAddSubMerchant();
		});
		/* DatePicker Javascript End*/
		$(".bank-info-details-content, .legal-details-content, .legal-details-rep-content, .free-transactions-content, .atm-transaction-content, .pos-transaction-content").hide();
		$(".account-details-content").show();
		$(".merchant-arrow").show();
		$(".contact-arrow, .bank-info-arrow, .legal-arrow, .legal-rep-arrow, .bank-legal-arrow, .bank-arrow, .configuration-arrow, .final-arrow").hide();
		$(".account-details-list, .bank-prev").click(function(){
            $(".merchant-circle-tab").addClass("active-circle");
			$(".bank-info-circle-tab, .legal-circle-tab, .legal-circle-rep-tab, .contact-circle-tab, .bank-circle-tab, .final-circle-tab").removeClass("active-circle");
			$(".merchant-arrow").show();
			$(".bank-info-arrow, .legal-arrow, .legal-rep-arrow, .contact-arrow, .bank-arrow, .final-arrow").hide();
			$(".account-details-content").show();
			$(".atm-transaction-content,.bank-info-details-content, .legal-details-content, .legal-details-rep-content, .pos-transaction-content, .free-transactions-content").hide();
		});
		 $(".bank-list, .acc-next, .legal-prev").click(function(){
		 	$(".bank-info-circle-tab").addClass("active-circle");
			$(".merchant-circle-tab, .legal-circle-tab, .legal-circle-rep-tab, .contact-circle-tab, .bank-circle-tab, .final-circle-tab").removeClass("active-circle");
			$(".bank-info-arrow").show();
			$(".merchant-arrow, .legal-arrow, .legal-rep-arrow, .contact-arrow, .configuration-arrow, .bank-arrow, .configuration-arrow, .final-arrow").hide();
			$(".bank-info-details-content").show();
			$(".account-details-content, .legal-details-content, .legal-details-rep-content, .atm-transaction-content, .pos-transaction-content, .free-transactions-content").hide();
		}); 
		
		 $(".legal-entiy-list, .bank-next, .legal-rep-prev").click(function(){
		 	$(".legal-circle-tab").addClass("active-circle");
			$(".merchant-circle-tab, .bank-info-circle-tab, .legal-circle-rep-tab, .contact-circle-tab, .bank-circle-tab, .final-circle-tab").removeClass("active-circle");
			$(".legal-arrow").show();
			$(".merchant-arrow, .legal-rep-arrow, .bank-info-arrow, .contact-arrow, .configuration-arrow, .bank-arrow, .configuration-arrow, .final-arrow").hide();
			$(".legal-details-content").show();
			$(".account-details-content, .legal-details-rep-content, .bank-info-details-content, .atm-transaction-content, .pos-transaction-content, .free-transactions-content").hide();
		});

		 $(".legal-entiy-rep-list, .legal-next, .free-prev").click(function(){
		 	$(".legal-circle-rep-tab").addClass("active-circle");
			$(".merchant-circle-tab, .bank-info-circle-tab, .legal-circle-tab, .contact-circle-tab, .bank-circle-tab, .final-circle-tab").removeClass("active-circle");
			$(".legal-rep-arrow").show();
			$(".merchant-arrow, .bank-info-arrow, .legal-arrow, .contact-arrow, .configuration-arrow, .bank-arrow, .configuration-arrow, .final-arrow").hide();
			$(".legal-details-rep-content").show();
			$(".account-details-content, .bank-info-details-content, .legal-details-content, .atm-transaction-content, .pos-transaction-content, .free-transactions-content").hide();
		});
		
		 $(".free-transactions-list, .legal-rep-next, .atm-prev").click(function() {
			$(".contact-circle-tab").addClass("active-circle");
			$(".merchant-circle-tab,.bank-info-circle-tab, .bank-circle-tab, .legal-circle-tab, .legal-circle-rep-tab, .final-circle-tab").removeClass("active-circle");
			$(".contact-arrow").show();
			$(".merchant-arrow, .legal-arrow, .legal-rep-arrow, .bank-info-arrow, .configuration-arrow, .bank-arrow, .final-arrow").hide()
			$(".free-transactions-content").show();
			$(".atm-transaction-content, .legal-details-content, .legal-details-rep-content, .bank-info-details-content, .pos-transaction-content, .account-details-content").hide();
		});
		$(".atm-transactions-list, .free-next, .pos-prev").click(function() {
		    $(".bank-circle-tab").addClass("active-circle");
			$(".merchant-circle-tab,.bank-info-circle-tab, .contact-circle-tab, .legal-circle-tab, .legal-circle-rep-tab, .final-circle-tab").removeClass("active-circle");
			$(".configuration-arrow").show();
			$(".contact-arrow, .merchant-arrow, .legal-arrow, .legal-rep-arrow, .bank-info-arrow, .final-arrow").hide()
			$(".atm-transaction-content").show();
			$(".free-transactions-content, .bank-info-details-content, .legal-details-content, .legal-details-rep-content, .pos-transaction-content, .account-details-content").hide();
			validateOnlineOptions();
			//populatePartnerAndAgentDetails($('#appMode').val(),'sub-merchant','view');
		});
		$(".pos-transactions-list, .atm-next").click(function() {
			$(".final-circle-tab").addClass("active-circle");
			$(".merchant-circle-tab, .bank-info-circle-tab, .contact-circle-tab, .legal-circle-tab, .legal-circle-rep-tab, .bank-circle-tab").removeClass("active-circle");
			$(".final-arrow").show();
			$(".contact-arrow, .bank-arrow,.configuration-arrow, .bank-info-arrow, .legal-arrow, .legal-rep-arrow, .merchant-arrow").hide()
			$(".pos-transaction-content").show();
			$(".free-transactions-content, .bank-info-details-content, .legal-details-content, .legal-details-rep-content, .atm-transaction-content, .account-details-content").hide();
		});

		function loadRadio(data) {
			if (data == '0') {
				$("#noAutoSettlement").prop("checked", true);
				$("#allowAutoSettlement").prop("checked", false);
			} else if (data == '1') {
				$("#noAutoSettlement").prop("checked", false);
				$("#allowAutoSettlement").prop("checked", true);
			}
		}
		function showAddSubMerchant() {
			if (checkStatusAndMerchantType()) {
				$('#subMerchant').show();
			} else {
				$('#subMerchant').hide();
			}
		}
		$(document).ready(function() {
			validateVirtualTerminal();
		});
	</script>
</body>
</html>
