<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery UI Autocomplete - Default functionality</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() {
	function log( message ) {

	      $( "<div>" ).text( message ).prependTo( "#log" );

	      $( "#log" ).scrollTop( 0 );

	    }

		
		var availableTags = [
		"ActionScript",
		"AppleScript",
		"Asp",
		"BASIC",
		"C",
		"C++",
		"Clojure",
		"COBOL",
		"ColdFusion",
		"Erlang",
		"Fortran",
		"Groovy",
		"Haskell",
		"Java",
		"JavaScript",
		"Lisp",
		"Perl",
		"PHP",
		"Python",
		"Ruby",
		"Scala",
		"Scheme"
		];

		
		$( "#tags" ).autocomplete({
			source: function(request,response) {
				$.ajax({
					url : "person/personlist", // remote datasource
					dataType: "json",
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
				 log( ui.item ? "Selected: " + ui.item.label + " aka " + ui.item.id : "Nothing selected, input was " + this.value );
			}
		});
});
</script>
 <style>

  .ui-autocomplete-loading {

    background: white url("images/ui-anim_basic_16x16.gif") right center no-repeat;

  }

  </style>



</head>
<body>
	<div class="ui-widget">
		<label for="tags">Tags: </label>
		<input id="tags">
		
		<BR/>
		Gender: <input name="gender" type="text" value="" id="gender"/>
	</div>
	<div class="ui-widget" style="margin-top:2em; font-family:Arial">
  		Result:
  		<div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>
	</div>

	
</body>
</html>