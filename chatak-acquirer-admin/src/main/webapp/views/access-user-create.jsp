<!DOCTYPE html>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
  int year = Calendar.getInstance().get(Calendar.YEAR);
%>

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
<link href="../css/font-awesome.css" rel="stylesheet" type="text/css" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
<script src="../js/utils.js"></script>
	<script src="../js/admin-user.js"></script>
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Header Block Start -->

			<!--Header Block End -->
			<!--Navigation Block Start -->
			<nav class="col-sm-12 nav-bar" id="main-navigation">
			<%@include file="navigation-panel.jsp" %>
			<%-- <jsp:include page="header.jsp" /></nav> --%>
			<!--Navigation Block Start -->
			<!--Article Block Start-->
			<article>
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text"><spring:message code="setup.label.setup"/></span> 
						<span class="glyphicon glyphicon-play icon-font-size"></span> 
						<span class="breadcrumb-text" id="userType"><spring:message code="users.label.user"/></span>
						<span class="glyphicon glyphicon-play icon-font-size"></span> 
						<span class="breadcrumb-text"><spring:message code="common.label.create"/></span>
					</div>
					<!-- Breadcrumb End -->
					
					<form:form action="chatakUserTypeValue" name="roleTypeForm" method="post">
				      <input type="hidden" id="rolesType" name="rolesType" />
				      <input type="hidden" name="CSRFToken" value="${tokenval}">
			        </form:form>
					<!-- Tab Buttons Start -->
					<c:if test="${fn:contains(existingFeatures,usersDelete)||fn:contains(existingFeatures,usersEdit)||fn:contains(existingFeatures,usersCreate)||fn:contains(existingFeatures,usersView)}">
					<div class="tab-header-container-first">
						<a href="access-user-search"><spring:message code="common.label.search"/> </a>
					</div>
					</c:if>
					<c:if test="${fn:contains(existingFeatures,usersCreate)}">
					<div class="tab-header-container active-background">
						<a href="#"><spring:message code="common.label.create"/></a>
					</div>
					</c:if>
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<div class="main-content-holder">
						<div class="row">
							<div class="col-sm-12">
								<!--Success and Failure Message Start-->
								<div class="col-xs-12">
									<div class="discriptionMsg" data-toggle="tooltip" data-placement="top" title="">
										<span class="red-error">${error}</span> <span
											class="green-error">${sucess}</span>
									</div>
								</div>
								<!--Success and Failure Message End-->
								<form:form action="access-user-create" name="resubmitForm" method="get"></form:form>
								<!-- Page Form Start -->
								<form:form action="access-user-create" modelAttribute="userData" method="post">
								<input type="hidden" name="CSRFToken" value="${tokenval}">
									<form:hidden path="requestType" id="requestType" />
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">
											
											<fieldset class="col-md-3 col-sm-6"> 
														<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="users.label.usertype"/></label>
															<form:select  path="roleType" id="roleType" cssClass="form-control" onchange="return validateUserType(this.value);">
															<c:forEach items="${roleLevelList}" var="roleLevelList">
															         <form:option value="${roleLevelList.value}">${roleLevelList.value}</form:option>
														        </c:forEach>
														        
															</form:select>
															<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
																<span class="red-error" id="roleTypeError">&nbsp;</span>
															</div>
														</fieldset>
											<fieldset class="col-sm-3" id="entityNameDiv">
													<label data-toggle="tooltip" data-placement="top" title="" id="entityLabel"><spring:message code="access-user-create.label.entityname"/><span id="red-color" class="required-field">*</span></label>
													<form:select cssClass="form-control" path="entityId"
														id="entityId" onblur="this.value=this.value.trim();validEntityName()">
														<form:option value=""><spring:message code="reports.option.select" /></form:option>
														<c:forEach items="${entityList}" var="entity">
															<form:option value="${entity.key}">${entity.value}</form:option>
														</c:forEach>
													</form:select>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="entityIdDiv">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="roles.label.rolename"/><span class="required-field">*</span></label>
													<form:select cssClass="form-control" path="roleId"
														id="roleName" onblur="this.value=this.value.trim();validRoleName()">
														<form:option value=""><spring:message code="reports.option.select"/></form:option>
														<c:forEach items="${userRoleListData}" var="userRole">
															<form:option value="${userRole.roleId}">${userRole.roleName }</form:option>
														</c:forEach>
													</form:select>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="roleNameDiv">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""> <spring:message code="users.label.address"/></label>
													<form:input path="address" id="address"
														cssClass="form-control"  maxlength="30" />

													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="addressDiv">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="login.label.username"/><span class="required-field">*</span></label>
													<form:input path="userName" id="userName"
														cssClass="form-control" onblur="this.value=this.value.trim();validUserName()"
														maxlength="30"  />
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="userNameDiv">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="users.label.firstname"/><span class="required-field">*</span></label>
													<form:input path="firstName" id="firstName"
														cssClass="form-control" onblur="this.value=this.value.trim();validFirstName()"
														maxlength="30"  />
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="firstNameDiv">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="users.label.lastname"/><span class="required-field">*</span></label>
													<form:input path="lastName" id="lastName"
														cssClass="form-control" onblur="this.value=this.value.trim();validLastName()"
														maxlength="30" />
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="lastNameDiv">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="common.label.emailid"/><span class="required-field">*</span></label>
													<form:input path="emailId" id="emailId"
														cssClass="form-control" onblur="this.value=this.value.trim();validateUserEmail()"
														maxlength="50" />
													<input type="hidden" id="userMail" value=${isUserMailUnique}>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="emialDiv">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="users.label.phonenumber"/><span class="required-field">*</span></label>
													<form:input path="phone" id="phone" cssClass="form-control" onkeypress="return numbersonly(this,event)"
														onblur="this.value=this.value.trim();validPhone()" maxlength="10" />
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="phoneDiv">&nbsp;</span>
													</div>
												</fieldset>
													<fieldset class="col-sm-3" id="merchantDivId">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="reports.label.balancereports.merchantorsubmerchantcode"/><span class="required-field">*</span></label>
													<form:input cssClass="form-control" path="merchantId"
														id="merchantId" onblur="validMerchantId()" maxlength="15" onkeypress="return numbersonly(this,event)"/>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="merchantIdEr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3" id="merchantNameId">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message code="reports.label.balancereports.merchantorsubmerchantName"/></label>
													<form:input cssClass="form-control" 
														id="merchantName" path="merchantName" disabled="true"/>
													<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
														<span class="red-error" id="merchantNameDiv">&nbsp;</span>
													</div>
												</fieldset> 
											</div>
										</div>
										<!--Panel Action Button Start -->
										<div class="col-sm-12 form-action-buttons">
											<div class="col-sm-5"></div>
											<div class="col-sm-7">
												<input type="submit" class="form-control button pull-right" value='<spring:message code="common.label.create"/>' onclick="return validCreateUser()"> 
												<input type="button" class="form-control button pull-right" value='<spring:message code="common.label.cancel"/>' onclick="openCancelConfirmationPopup()">
												<input type="button" class="form-control button pull-right" value='<spring:message code="common.label.reset"/>' onclick="resetAll()">
											</div>
										</div>
										<!--Panel Action Button End -->
									</div>
								</form:form>
								<!-- Page Form End -->
							</div>
						</div>
					</div>
					<!-- Content Block End -->
				</div>
				<div id="my_popup1" class="popup-void-refund voidResult">
					<span class="glyphicon glyphicon-remove closePopupMes"
						onclick="closeCancelConfirmationPopup()"></span>
					<div class="fw-b-fs15" style="padding: 20px;">
						<spring:message code="cancle.conformation.lable.currency" />
					</div>
					<div class="col-sm-12">

						<input type="button"
							class="form-control button pull-right margin5 close-btn"
							value="<spring:message code="bin.label.no"/>"
							onclick="closeCancelConfirmationPopup()"> <input
							type="submit" class="form-control button pull-right margin5"
							value="<spring:message code="bin.label.yes"/>"
							onclick="cancelCreateUser()">
					</div>
				</div>
			</article>
			<!--Article Block End-->
			</div>
		<footer class="footer">
				<jsp:include page="footer.jsp"></jsp:include>
			</footer>
		
		<!--Container block End -->
	</div>
	<!--Body Wrapper block End -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/common-lib.js"></script>
	<script src="../js/jquery.cookie.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/utils.js"></script>
	<script src="../js/messages.js" type="text/javascript"></script>
	<script src="../js/admin-user.js"></script>
	<script type="text/javascript" src="../js/backbutton.js"></script>
	<script src="../js/jquery.popupoverlay.js"></script>
	<script type="text/javascript" src="../js/browser-close.js"></script>
	
	<script>
		
		/* function updateHref($this) {
			var href = $($this).attr('href');
			$($this).attr('href',href + "?requestType="+$('#requestType').val());
		} */

		$(document).ready(function() {
			$("#navListId2").addClass("active-background");
			
			if($('#roleType').val() == 'Admin'){
				$('#merchantDivId').hide();
				$('#merchantNameId').hide();
				$('#entityNameDiv').hide();
			} else if($('#roleType').val() == 'Program Manager' || $('#roleType').val() == 'ISO') {
				$('#merchantDivId').hide();
				$('#merchantNameId').hide();
				$('#entityNameDiv').show();
				if($('#roleType').val() == 'Program Manager') {
					document.getElementById("entityLabel").innerHTML=webMessages.entityProgramManager;
					$("#red-color").addClass("required-field");
				} else if($('#roleType').val() == 'ISO') {
					document.getElementById("entityLabel").innerHTML=webMessages.entityIso;
					$("#red-color").addClass("required-field");
				}
			} else if($('#roleType').val() == 'Merchant') {
				$('#entityNameDiv').hide();
			}
			if($('#roleType').val() == 'Tms'){
				$('#merchantDivId').hide();
				$('#entityNameDiv').hide();
			}
			if($('#roleType').val() == 'Reseller'){
				$('#merchantDivId').hide();
				$('#entityNameDiv').hide();
			}
			
			/* if($('#requestType').val() == 'ADMIN') {
				$('#userType').text('Admin User');
				$('#merchantDivId').hide();
				$('#userNameMerchant').hide();
				$('#merchantName').val("");
			} else {
				$('#userType').text('Merchant User');
				$('#merchantDivId').show();
			} */
		});
		$('#my_popup1').popup({
			blur:false
		});
	</script>
</body>
</html>