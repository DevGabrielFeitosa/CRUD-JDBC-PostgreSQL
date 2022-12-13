<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Projeto em JSP</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>

<style>
form {
	position: absolute;
	top: 40%;
	left: 35%;
	right: 35%;
}

h1 {
	position: absolute;
	top: 30%;
	left: 35%;
	right: 35%;
}

h5 {
	position: absolute;
	top: 120%;
	left: 20%;
	right: 20%;
	color: red;
}
</style>

<body>
	<h1>Projeto JSP</h1>

	<form action="ServletLogin" method="post"
		class="row g-3 needs-validation" novalidate>

		<input type="hidden" value="<%=request.getParameter("url")%>"
			name="url">

		<div class="mb-3">
			<label class="form-label">Login</label> <input class="form-control"
				name="Login" type="text" required>
			<div class="valid-feedback">Ok</div>
			<div class="invalid-feedback">Preencha este campo.</div>
		</div>


		<div class="col-md-6">
			<label class="form-label">Senha</label> <input name="Senha"
				class="form-control" type="password" required>
			<div class="valid-feedback">Ok</div>
			<div class="invalid-feedback">Preencha este campo.</div>
		</div>

		<div class="col-12">
			<input type="submit" value="Login" class="btn btn-primary">
		</div>


		<h5>${msg}</h5>

	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
		integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
//Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()
</script>
</body>
</html>