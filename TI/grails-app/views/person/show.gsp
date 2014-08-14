
<%@ page import="com.cland.Person" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-person" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="person.dateOfBirth.label" default="Date Of Birth" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${personInstance?.dateOfBirth}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="person.email.label" default="Email" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: personInstance, field: "email")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="person.gender.label" default="Gender" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: personInstance, field: "gender")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="person.firstName.label" default="First Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: personInstance, field: "firstName")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="person.lastName.label" default="Last Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: personInstance, field: "lastName")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="person.phones.label" default="Phones" /></td>
				
				<td valign="top" style="text-align: left;" class="value">
					<ul>
					<g:each in="${personInstance.phones}" var="p">
						<li><g:link controller="phone" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
					</g:each>
					</ul>
				</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
