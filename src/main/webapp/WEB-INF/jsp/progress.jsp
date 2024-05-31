<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Progress</title>
</head>

<body>
<BR/>
<p>Progress Page</p>
<p id="my-progress">${ownProgress}</p>

<form method="post">
    Username : <input type="text" name="username" id="username-input" />
    <input type="submit" id="submit-button" />
</form>

<p id="other-user-progress">${otherProgress}</p>
</body>

</html>