<html>
<head>
   <title>SOFTENG754 Learn a new language!</title>
   <script>
      var screenTime = ${screenTime};
      var breakTime = ${breakTime};

      function updateNotification() {
         if (screenTime > 60) {
            var notification = "You have been learning for more than 60 minutes! " +
                    "You should take a break!";
            document.getElementById("notification").innerText = notification;
         }
         document.getElementById("notification").innerText = notification;
      }

      function updateBreakTime(newTime) {
         breakTime = newTime;
         document.getElementById("breakTime").innerText = breakTime;
         if (breakTime > 5) {
            updateScreenTime(0);
         }
      }

      function updateScreenTime(newTime) {
         screenTime = newTime;
         document.getElementById("screenTime").innerText = screenTime;
         updateNotification();
      }

   </script>
</head>
<body>
<p> SE754 Dev Web App! </p>
<label id="message">Welcome ${name}! <a href="/courses">Click here</a> to see your language quiz.</label>
<a href="${pageContext.request.contextPath}/progress">Go to Progress Page</a>

<h2>Digital Wellbeing</h2>
<p>Screen Time: <span id="screenTime">${screenTime}</span> minutes</p>
<p>Break Time: <span id="breakTime">${breakTime}</span> minutes</p>
<p id="notification">${notification}</p>
</body>
</html>
