
<%@ page import="com.cland.Person" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>

<section id="list-person" class="first">

	<table class="table table-bordered margin-top-medium">
		<thead>
			<tr>
				<g:sortableColumn property="firstName" title="${message(code: 'person.firstName.label', default: 'First Name')}" />
			
				<g:sortableColumn property="lastName" title="${message(code: 'person.lastName.label', default: 'Last Name')}" />
				
				<g:sortableColumn property="dateOfBirth" title="${message(code: 'person.dateOfBirth.label', default: 'Date Of Birth')}" />
			
				<g:sortableColumn property="email" title="${message(code: 'person.email.label', default: 'Email')}" />
			
				<g:sortableColumn property="gender" title="${message(code: 'person.gender.label', default: 'Gender')}" />
			
				
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${personInstanceList}" status="i" var="personInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				<td><g:link action="show" id="${personInstance.id}">${fieldValue(bean: personInstance, field: "firstName")}</g:link></td>
			
				<td><g:link action="show" id="${personInstance.id}">${fieldValue(bean: personInstance, field: "lastName")}</g:link></td>
				<td><g:link action="show" id="${personInstance.id}">${fieldValue(bean: personInstance, field: "dateOfBirth")}</g:link></td>
			
				<td>${fieldValue(bean: personInstance, field: "email")}</td>
			
				<td>${fieldValue(bean: personInstance, field: "gender")}</td>
			
				
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div>
		<bs:paginate total="${personInstanceCount}" />
	</div>
</section>

</body>

</html>
