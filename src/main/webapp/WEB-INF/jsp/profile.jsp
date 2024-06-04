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

    <h2>Upload banner picture</h2>
    <form method="post" action="uploadBannerPicture">
        <label for="newProfilePicture">Choose a banner picture:</label>
        <input type="text" name="newBannerPicture" id="newBannerPicture" required />
        <button type="submit" id="changeBannerPictureBtn">Change Banner Picture</button>
    </form>

    <h2>Choose your flags</h2>
    <form method="post" action="updateFlags">
        <p>Choose one or more flags:</p>
        <input type="checkbox" name="flags" value="New Zealand" id="flagNZ">
        <label for="flagNZ">New Zealand</label><br>
        <input type="checkbox" name="flags" value="Australia" id="flagAustralia">
        <label for="flagAustralia">Australia</label><br>
        <input type="checkbox" name="flags" value="China" id="flagChina">
        <label for="flagChina">China</label><br>
        <input type="checkbox" name="flags" value="USA" id="flagUSA">
        <label for="flagUSA">USA</label><br>
        <input type="checkbox" name="flags" value="UK" id="flagUK">
        <label for="flagUK">UK</label><br>
        <button type="submit" id="changeFlagsBtn">Choose Flags</button>
    </form>


    <c:if test="${not empty alertMessage}">
        <script type="text/javascript">
            showAlert("${alertMessage}");
        </script>
    </c:if>
</body>

</html>