<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.chatak.pg.util.Constants"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
			<section class="field-element-row account-details-content"
												style="display: none;">
												<fieldset class="col-sm-12">
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.companyname"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="businessName"
															id="businessName" maxlength="50"
															onblur="validateBusinessName()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="businessNameEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.merchantcode"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="merchantCode"
															id="merchantCode" maxlength="50"
															onblur="validateMerchantCode()" readonly="true" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="merchantCodeEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.firstname"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="firstName"
															id="firstName" maxlength="50"
															onblur="validateFirstName()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="firstNameEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.lastname"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="lastName"
															id="lastName" maxlength="50" onblur="validateLastName()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="lastNameEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.mobilephone"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="phone"
															id="phone" maxlength="10" onblur="validatePhone()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="phoneEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.fax"/><!-- <span class="required-field">*</span> --></label>
														<form:input cssClass="form-control" path="fax" id="fax"
															onkeypress="return amountValidate(this,event)"
															maxlength="13" />
														<%--  onblur="validateFax()" --%>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="faxEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.emailID"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="emailId"
															id="emailId" readonly="true" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="emailIdEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="common.label.address1"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="address1"
															id="address1" maxlength="50" onblur="validateAddress1()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="address1Er" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="common.label.address2"/></label>
														<form:input cssClass="form-control" path="address2"
															id="address2" maxlength="50" onblur="validateAddress2()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="address2Er" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="common.label.city"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="city" id="city"
															maxlength="50" onblur="validateCity()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="cityEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="common.label.country"/><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="country"
															id="country" onblur="validateCountry()"
															onchange="fetchMerchantState(this.value, 'state')">
															<form:option value=""><spring:message code="reports.option.select"/></form:option>
															<c:forEach items="${countryList}" var="country">
																<form:option value="${country.label}">${country.label}</form:option>
															</c:forEach>
														</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="countryEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="common.label.state"/><span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="state"
															id="state" onblur="validateState()">
															<form:option value=""><spring:message code="reports.option.select"/></form:option>
															<c:forEach items="${stateList}" var="item">
																<form:option value="${item.label}">${item.label}</form:option>
															</c:forEach>
														</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="stateEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="common.label.zipcode"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="pin" id="pin"
															maxlength="10" onblur="validatePin()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="pinEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<%-- <fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title="">Status<span class="required-field">*</span></label>
														<form:select cssClass="form-control" path="status"
															id="status" onblur="validateStatus()">
															<form:option value=""><spring:message code="reports.option.select"/></form:option>
															<form:option value="0"><spring:message code="common.label.active"/></form:option>
															<form:option value="1"><spring:message code="common.label.pending"/></form:option>
															<form:option value="2"><spring:message code="common.label.inactive"/></form:option>
															<form:option value="5"><spring:message code="common.label.selfregistrationpending"/></form:option>
														</form:select>
														<form:hidden path="merchantType" id="merchantType" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="statusEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset> --%>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.applicationmode"/><span
															class="required-field">*</span></label>
														<form:select cssClass="form-control" path="appMode"
															id="appMode" onblur="validateAppMode()">
															<form:option value=""><spring:message code="reports.option.select"/></form:option>
															<form:option value="DEMO"><spring:message code="merchant.label.demo"/></form:option>
															<form:option value="PRELIVE"><spring:message code="merchant.label.prelive"/></form:option>
															<form:option value="LIVE"><spring:message code="merchant.label.live"/></form:option>
														</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="appModeEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.businessURL"/><span class="required-field">*</span></label>
														<form:input cssClass="form-control" path="businessURL"
															maxlength="50" id="businessURL" onclick="validateURL()" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="businessURLEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.lookingfor"/></label>
														<form:textarea cssClass="form-control" path="lookingFor"
															readonly="true" id="lookingFor" />
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="lookingForEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
													<fieldset class="col-sm-3">
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="merchant.label.businesstype"/></label>
														<form:select cssClass="form-control" path="businessType"
															disabled="true" id="businessType">
															<form:option value=""><spring:message code="merchant.label.choosetype"/></form:option>
															<form:option value="Airline"><spring:message code="merchant.label.airline"/></form:option>
															<form:option value="Auto Rental"><spring:message code="merchant.label.autorental"/></form:option>
															<form:option value="Clothing Stores"><spring:message code="merchant.label.clothingstores"/></form:option>
															<form:option value="Department Stores"><spring:message code="merchant.label.departmentstores"/></form:option>
															<form:option value="Deposit Transactions"><spring:message code="merchant.label.deposittransactions"/></form:option>
															<form:option value="Discount Stores"><spring:message code="merchant.label.discountstores"/></form:option>
															<form:option value="Drug Stores"><spring:message code="merchant.label.drugstores"/></form:option>
															<form:option value="Education"><spring:message code="merchant.label.education"/></form:option>
															<form:option value="Electric-Appliance"><spring:message code="merchant.label.electricappliance"/></form:option>
															<form:option value="Food Stores-Warehouse"><spring:message code="merchant.label.foodstoreswarehouse"/></form:option>
															<form:option value="Gas Stations"><spring:message code="merchant.label.gasstations"/></form:option>
															<form:option value="Hardware"><spring:message code="merchant.label.hardware"/></form:option>
															<form:option value="Health Care"><spring:message code="merchant.label.healthcare"/></form:option>
															<form:option value="Hotel-Motel"><spring:message code="merchant.label.hotelmotel"/></form:option>
															<form:option value="Interior Furnishings"><spring:message code="merchant.label.interiorfurnishings"/></form:option>
															<form:option value="Other Retail"><spring:message code="merchant.label.otherretail"/></form:option>
															<form:option value="Other Services"><spring:message code="merchant.label.otherservices"/></form:option>
															<form:option value="Other Transport"><spring:message code="merchant.label.othertransport"/></form:option>
															<form:option value="Professional Services"><spring:message code="merchant.label.professionalservices"/></form:option>
															<form:option value="Recreation"><spring:message code="merchant.label.recreation"/></form:option>
															<form:option value="Repair Shops"><spring:message code="merchant.label.repairshops"/></form:option>
															<form:option value="Restaurants-Bars"><spring:message code="merchant.label.restaurantsbars"/></form:option>
															<form:option value="Sporting-Toy Stores"><spring:message code="merchant.label.sportingtoystores"/></form:option>
															<form:option value="Vehicles"><spring:message code="merchant.label.vehicles"/></form:option>
														</form:select>
														<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
															<span id="businessTypeEr" class="red-error">&nbsp;</span>
														</div>
													</fieldset>
												</fieldset>
												<!--Panel Action Button Start -->
												<div class="col-sm-12 button-content">
													<fieldset class="col-sm-7 pull-right">
														<input type="button"
															value='<spring:message code="common.label.continue"/>' class="form-control button pull-right acc-next"
															> <input type="button"
															class="form-control button pull-right marginL10"
															value='<spring:message code="common.label.cancel"/>' onclick="goToMerchantSearch()">
													</fieldset>
												</div>
												<!--Panel Action Button End -->
											</section>								
</body>