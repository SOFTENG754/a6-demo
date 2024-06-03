<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Profile</title>
    <script>
        function showAlert(message) {
            alert(message);
        }
    </script>

<body>
    <h1>Profile</h1>
    <h2>Enter new username to change username</h2>
    <form method="post">
        New Username: <input type="text" name="newUsername" id="newUsername" required />
        <button type="submit" id="changeUsernameBtn">Change Username</button>
    </form>

    <c:if test="${not empty alertMessage}">
        <script type="text/javascript">
            showAlert("${alertMessage}");
        </script>
    </c:if>
</body>

</html>