<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ page import="java.util.Arrays" %>
    <%@ page import="java.util.List" %>
    <title>Profile</title>
    <script>
        function showAlert(message) {
            alert(message);
        }
    </script>

<body>
    <h1>Profile</h1>
    <h2>Username</h2>
    <p id="username">${username}</p>
    <form method="post" action="changeUsername">
        <span>Change username</span>
        Change username to: <input type="text" name="newUsername" id="newUsername" required />
        <button type="submit" id="changeUsernameBtn">Change Username</button>
    </form>

    <h2>Profile Picture</h2>
    <p id="profilePicture">${profilePicture}</p>
    <form method="post" action="uploadProfilePicture">
        <label for="newProfilePicture">Upload a new profile picture:</label>
        <input type="text" name="newProfilePicture" id="newProfilePicture" required />
        <button type="submit" id="changeProfilePictureBtn">Change Profile Picture</button>
    </form>

    <h2>Banner Picture</h2>
    <p id="bannerPicture">${bannerPicture}</p>
    <form method="post" action="uploadBannerPicture">
        <label for="newProfilePicture">Upload a banner picture:</label>
        <input type="text" name="newBannerPicture" id="newBannerPicture" required />
        <button type="submit" id="changeBannerPictureBtn">Change Banner Picture</button>
    </form>

    <h2>Flags</h2>
    <form method="post" action="updateFlags">
        <p>Choose one or more flags:</p>
        <c:set var="flagsList" value="${flags}" />
        <input type="checkbox" name="flags" value="New Zealand" id="flagNZ" <c:if test="${flagsList != null && flagsList.contains('New Zealand')}">checked</c:if>>
        <label for="flagNZ">New Zealand</label><br>
        <input type="checkbox" name="flags" value="Australia" id="flagAustralia" <c:if test="${flagsList != null && flagsList.contains('Australia')}">checked</c:if>>
        <label for="flagAustralia">Australia</label><br>
        <input type="checkbox" name="flags" value="China" id="flagChina" <c:if test="${flagsList != null && flagsList.contains('China')}">checked</c:if>>
        <label for="flagChina">China</label><br>
        <input type="checkbox" name="flags" value="USA" id="flagUSA" <c:if test="${flagsList != null && flagsList.contains('USA')}">checked</c:if>>
        <label for="flagUSA">USA</label><br>
        <input type="checkbox" name="flags" value="UK" id="flagUK" <c:if test="${flagsList != null && flagsList.contains('UK')}">checked</c:if>>
        <label for="flagUK">UK</label><br>
        <button type="submit" id="changeFlagsBtn">Update Flags</button>
    </form>

    <h2>Status Message</h2>
    <form method="post" action="changeStatusMessage">
        Status: <input type="text" name="statusMessage" id="statusMessage" value="${statusMessage}" required />
        <button type="submit" id="changeStatusBtn">Change Status</button>
    </form>

    <h2>Choose a theme</h2>
    <form method="post" action="changeTheme">
        <label for="theme">Choose a theme:</label>
        <select name="theme" id="theme" required>
            <option value="light" <c:if test="${theme == 'Light'}">selected</c:if>>Light</option>
            <option value="dark" <c:if test="${theme == 'Dark'}">selected</c:if>>Dark</option>
        </select>
        <button type="submit" id="changeThemeBtn">Change Theme</button>
    </form>

    <c:if test="${not empty alertMessage}">
        <script type="text/javascript">
            showAlert("${alertMessage}");
        </script>
    </c:if>
</body>

</html>