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
    <form method="post" action="/profile">
        New Username: <input type="text" name="newUsername" id="newUsername" required />
        <button type="submit" id="changeUsernameBtn">Change Username</button>
    </form>

    <h2>Upload profile picture</h2>
    <form method="post" action="uploadProfilePicture">
        <label for="newProfilePicture">Choose a profile picture:</label>
        <input type="text" name="newProfilePicture" id="newProfilePicture" required />
        <button type="submit" id="changeProfilePictureBtn">Change Profile Picture</button>
    </form>


    <c:if test="${not empty alertMessage}">
        <script type="text/javascript">
            showAlert("${alertMessage}");
        </script>
    </c:if>
</body>

</html>