<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
body {
	background-color: #fff;
	font-family: Arial, sans-serif;
}
.container {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}
.form {
	background-color: #f2f2f2;
	border-radius: 10px;
	padding: 40px;
	max-width: 500px;
	width: 100%;
	box-sizing: border-box;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	text-align: center;
}
.form__title {
	font-size: 30px;
	margin-bottom: 30px;
	display: flex;
	align-items: center;
	justify-content: center;
}
.form__icon {
	margin-right: 10px;
	height: 30px;
	width: 30px;
	fill: #333;
}
.form__field {
	margin-bottom: 20px;
}
.form__label {
	display: block;
	margin-bottom: 10px;
}
.form__input {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #fff;
	box-sizing: border-box;
	box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
}
.form__submit {
	background-color: #333;
	color: #fff;
	border: none;
	cursor: pointer;
	font-size: 16px;
	padding: 10px 20px;
	border-radius: 5px;
	margin-top: 20px;
}
.form__submit:hover {
	background-color: #111;
}
.form__error {
	color: #f00;
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<form class="form" action="<%=request.getContextPath()%>/LoginServ" method="post">
			<h2 class="form__title">
				<svg class="form__icon" xmlns="http://www.w3.org/2000/svg"
					viewBox="0 0 24 24">
					<path
						d="M21 1H3c-1.1 0-2 .9-2 2v18c0 1.1.9 2 2 2h18c1.1 0 2-.9 2-2V3c0-1.1-.9-2-2-2zM9 18H5v-2h4v2zm6 0h-4v-2h4v2zm6 0h-4v-2h4v2zm0-4h-4v-2h4v2zm0-4h-4v-2h4v2zm0-4h-4V6h4v2zm-6 8h-4v-2h4v2zm0-4h-4v-2h4v2zm0-4h-4V6h4v2zm6 8h-4v-2h4v2z" /></svg>
				Login
			</h2>
			<div class="form__field">
				<label class="form__label" for="login">Login :</label> <input
					class="form__input" type="text" name="login" id="login" required />
			</div>
			<div class="form__field">
				<label class="form__label" for="password">Password :</label> <input
					class="form__input" type="password" name="password" id="password"
					required />
			</div>
			<input class="form__submit" type="submit" value="Login" />
			<p class="form__error"></p>
		</form>
	</div>
</body>
</html>