<div class="dialog">
  <table>
      <tbody>

      <tr class="prop">
        <td valign="top" class="name">
          <label for="firstName"><g:message code="contact.firstName.label" default="First Name" /></label>
        </td>
        <td valign="top" class="value ${hasErrors(bean: personInstance, field: 'firstName', 'errors')}">
    <g:textField name="firstName" value="${personInstance?.firstName}" />
    </td>
    </tr>

    <tr class="prop">
      <td valign="top" class="name">
        <label for="lastName"><g:message code="contact.lastName.label" default="Last Name" /></label>
      </td>
      <td valign="top" class="value ${hasErrors(bean: personInstance, field: 'lastName', 'errors')}">
    	<g:textField name="lastName" value="${personInstance?.lastName}" />
    </td>
    </tr>

    <tr class="prop">
      <td valign="top" class="name">
        <label for="gender"><g:message code="contact.gender.label" default="Gender" /></label>
      </td>
      <td valign="top" class="value ${hasErrors(bean: personInstance, field: 'gender', 'errors')}">
    	<g:textField class="form-control" name="gender" value="${personInstance?.gender}"/>
		<span class="help-inline">${hasErrors(bean: personInstance, field: 'gender', 'error')}</span>
    </td>
    </tr>
	<tr class="prop">
      <td valign="top" class="name">
        <label for="email"><g:message code="contact.email.label" default="Email" /></label>
      </td>
      <td valign="top" class="value ${hasErrors(bean: personInstance, field: 'email', 'errors')}">
    	<g:textField name="email" value="${personInstance?.email}" />
    </td>
    </tr>
    <tr class="prop">
      <td valign="top" class="name">
        <label for="phones"><g:message code="contact.phones.label" default="Phones List" /></label>
      </td>
        <td valign="top" class="value ${hasErrors(bean: personInstance, field: 'phones', 'errors')}">

        <!-- Render the phones template (_phones.gsp) here -->
        <g:render template="phones" model="['personInstance':personInstance]" />
        <!-- Render the phones template (_phones.gsp) here -->

    </td>
    </tr>
    </tbody>
  </table>
</div>
