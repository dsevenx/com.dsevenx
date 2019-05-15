<html>
<body>
	<h2>Test von TUSER</h2>

	<p>
		<a
			href="webapi/myresource/readhighscore?stage=T&company=D7X&domain=BUCHSTABENAPP&offset=0&welche=E">Highscore
			lesen</a>
	<form method=post
		action="http://localhost:8080/D7XRestServiceTUser/webapi/myresource/updateuser?id=2&he=74&hges=75">
		<input type="submit" value="update user">
	</form>

	<form method=post
		action="http://localhost:8080/D7XRestServiceTUser/webapi/myresource/createuser?stage=T&company=D7X&domain=BUCHSTABENAPP&name=Frank">
		<input type="submit" value="create User">
	</form>


</body>
</html>
