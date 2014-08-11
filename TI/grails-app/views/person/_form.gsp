<%@ page import="com.cland.Person" %>



			<div class="${hasErrors(bean: personInstance, field: 'dateOfBirth', 'error')} ">
				<label for="dateOfBirth" class="control-label"><g:message code="person.dateOfBirth.label" default="Date Of Birth" /></label>
				<div>
					<bs:datePicker name="dateOfBirth" precision="day"  value="${personInstance?.dateOfBirth}" default="none" noSelection="['': '']" />
					<span class="help-inline">${hasErrors(bean: personInstance, field: 'dateOfBirth', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: personInstance, field: 'email', 'error')} ">
				<label for="email" class="control-label"><g:message code="person.email.label" default="Email" /></label>
				<div>
					<g:textField class="form-control" name="email" value="${personInstance?.email}"/>
					<span class="help-inline">${hasErrors(bean: personInstance, field: 'email', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: personInstance, field: 'gender', 'error')} ">
				<label for="gender" class="control-label"><g:message code="person.gender.label" default="Gender" /></label>
				<div>
					<g:textField class="form-control" name="gender" value="${personInstance?.gender}"/>
					<span class="help-inline">${hasErrors(bean: personInstance, field: 'gender', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: personInstance, field: 'firstName', 'error')} ">
				<label for="firstName" class="control-label"><g:message code="person.firstName.label" default="First Name" /></label>
				<div>
					<g:textField class="form-control" name="firstName" value="${personInstance?.firstName}"/>
					<span class="help-inline">${hasErrors(bean: personInstance, field: 'firstName', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: personInstance, field: 'lastName', 'error')} ">
				<label for="lastName" class="control-label"><g:message code="person.lastName.label" default="Last Name" /></label>
				<div>
					<g:textField class="form-control" name="lastName" value="${personInstance?.lastName}"/>
					<span class="help-inline">${hasErrors(bean: personInstance, field: 'lastName', 'error')}</span>
				</div>
			</div>

