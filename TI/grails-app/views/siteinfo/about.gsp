<html>

<head>
	<title><g:message code="default.about.title" args="[meta(name:'app.name')]"/></title>
	 <meta http-equiv='X-UA-Compatible' content='IE=Edge'>
	<meta name="layout" content="kickstart" />
	
	<r:require module="jquery-ui-dev"/>




</head>

<body>

	<section id="intro">
		<h1><g:message code="default.welcome.title" args="[meta(name:'app.name')]"/></h1>
	</section>

	<section id="additional">		
		<h1><g:message code="default.welcome.title" args="['Kickstart']"/></h1>
		<p>Kickstart is an extension for Grails in order to start with a
			good looking template for your project. It uses the Bootstrap web
			page template by Twitter and provides adapted scaffolding templates
			for standard web pages.</p>
	</section>
	
	<section id="findperson">
		<label for="firstName" class="control-label"><g:message code="person.firstName.label" default="First Name" /></label>
				<div>
					<input name="searchperson" id="person_textField" 
						style="float: right; margin: 0px 10px 10px 0px;" 
						type="text" 						
						value="" 
						placeholder="Enter name..." />
					<input type="hidden" id="person_id" name="person_id" value="" />	
					<input id="gender" value="" name="gender"/>
				</div>
	</section>
	<script>
		$(document).ready(function() {
			jQuery("#person_textField").autocomplete({
				source : function(request,response) {
					$.ajax({
								url : "person/personlist", // remote datasource
								data : request,
								success : function(data) {
									response(data); // set the response
								},
								error : function() { // handle server errors
									alert("Unable to retrieve People");
								}
							});
				},
				minLength : 2, // triggered only after minimum 2 characters have been entered.
				select : function(event, ui) { // event handler when user selects a company from the list.
					$("#person_id").val(ui.item.id); // update the hidden field.
					$("#gender").val(ui.item.gender) // populate the employee field with the nasdaq symbol.
				}
			});
			
	<%--			 $.ajax({--%>
<%--			        type: "GET",--%>
<%--			        url: "person/getAllPeople",--%>
<%--			        dataType: "json",--%>
<%--			        success : function(response) {--%>
<%--			            //Create a map.--%>
<%--			            var data = $.map(response, function(item){--%>
<%--			                  	console.log("id: " + item.id + " | firstname: " + item.firstName + " lastname: " + item.lastName);			                  --%>
<%--			                    return{--%>
<%--			                        id: item.id,--%>
<%--			                        firstname: item.firstname,--%>
<%--			                        lastname: item.lastname,--%>
<%--			                        fullname: item.firstname + " " + item.lastname,--%>
<%--			                        gender: item.gender			                        --%>
<%--			                    }--%>
<%--			                });--%>
<%--			 			var fldEl =$("#person_textField") --%>
<%--			            fldEl.autocomplete({--%>
<%--			                source: data,--%>
<%--			                select: function (event, ui){--%>
<%--			                    console.log("selected id:" + ui.item.id);--%>
<%--			                    console.log("selected firstname:" + ui.item.firstname);--%>
<%--			 --%>
<%--			                    //when a person is selected,--%>
<%--			                    //change the value of hidden field to the person's id.--%>
<%--			                    $('#person_id').val(ui.item.id);--%>
<%--			                }--%>
<%--			            });--%>
<%--			            --%>
<%--			 --%>
<%--			        }--%>
<%--			    });--%>
		 
		});
	</script>
</body>

</html>
