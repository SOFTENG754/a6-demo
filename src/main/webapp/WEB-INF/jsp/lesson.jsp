<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Lesson</title>
    <script>
        function getDefinition() {
            var word = document.getElementById("word").innerText;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/lesson/getDefinition", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                    if (this.responseText === "Unable to find definition") {
                        alert("Unable to find definition");
                    }else if (this.responseText === "Connection error") {
                        alert("Connection error");
                    } else {
                        document.getElementById("definition").innerText = this.responseText;
                    }
                }
            }
            xhr.send("word=" + encodeURIComponent(word));
        }
        function getExample() {
            var word = document.getElementById("word").innerText;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/lesson/getExample", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                    if (this.responseText === "Unable to find any examples") {
                        alert("Unable to find any examples");
                    }else if (this.responseText === "Connection error") {
                        alert("Connection error");
                    } else {
                        document.getElementById("example").innerText = this.responseText;
                    }
                }
            }
            xhr.send("word=" + encodeURIComponent(word));
        }
        function getSynonymsAndAntonyms() {
            var word = document.getElementById("word").innerText;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/lesson/getSynonymsAndAntonyms", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                    if (this.responseText === "Unable to find any synonyms or antonyms") {
                        alert("Unable to find any synonyms or antonyms");
                    }else if (this.responseText === "Connection error") {
                        alert("Connection error");
                    } else {
                        document.getElementById("synonymsAndAntonyms").innerText = this.responseText;
                    }
                }
            }
            xhr.send("word=" + encodeURIComponent(word));
        }
        function getImage() {
            var word = document.getElementById("word").innerText;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/lesson/getImage", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                    if (this.responseText === "Unable to find image") {
                        alert("Unable to find image");
                    }else if (this.responseText === "Connection error") {
                        alert("Connection error");
                    } else {
                        document.getElementById("image").src = this.responseText;
                    }
                }
            }
            xhr.send("word=" + encodeURIComponent(word));
        }
        function pronounce() {
            var word = document.getElementById("word").innerText;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/lesson/getPronunciation", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                    if (this.responseText === "Unable to find pronunciation") {
                        alert("Unable to find pronunciation");
                    }else if (this.responseText === "Connection error") {
                        alert("Connection error");
                    } else {
                        document.getElementById("pronunciation").src = this.responseText;
                    }
                }
            }
            xhr.send("word=" + encodeURIComponent(word));
        }

        function getHint(taskId) {
            var statusElement = document.getElementById("status-" + taskId);
            if (statusElement.innerText.includes("Failed")) {
                document.getElementById("hint-" + taskId).innerText = "Hint for " + taskId;
            } else {
                document.getElementById("hint-" + taskId).innerText = "";
            }
        }

        function redoTask(taskId) {
            document.getElementById("status-" + taskId).innerText = "Uncompleted: " + taskId;
        }

        function submitTask(taskId, correctAnswer) {
            var userAnswer = document.getElementById("answer-" + taskId).value;
            var status = userAnswer === correctAnswer ? "Passed: " + taskId : "Failed: " + taskId;
            document.getElementById("status-" + taskId).innerText = status;
        }
    </script>
</head>

<body>
<BR/>
<h1>Course ID: ${courseid}</h1>
<h2>Lesson ID: ${lessonid}</h2>

<p>Welcome to the lesson page.</p>
<a href="${pageContext.request.contextPath}/course/${courseid}">Back to Course</a>
<p id="word">valid word</p>
<button id="definitionButton" onclick="getDefinition()">Get Definition</button>
<p id="definition">${definition}</p>
<button id="exampleButton" onclick="getExample()">Get Example</button>
<p id="example">${example}</p>
<button id="synonymsAndAntonymsButton" onclick="getSynonymsAndAntonyms()">Get Synonyms And Antonyms</button>
<p id="synonymsAndAntonyms">${synonymsAndAntonyms}</p>
<button id="showImageButton" onclick="getImage()">Show Image</button>
<img id="image" src="${image}" alt="Image">
<button id="pronounceButton" onclick="pronounce()">Pronounce</button>
<audio id="pronunciation" src="${pronunciation}"></audio>

<h2>Tasks</h2>
<div id="tasks">
    <c:forEach var="task" items="${tasks}">
        <div>
            <p id="status-${task.id}">${task.status}: ${task.id}</p>
            <p>${task.question}</p>
            <input type="text" id="answer-${task.id}" placeholder="Answer">
            <button id="submitTask-${task.id}" onclick="submitTask('${task.id}', '${task.correctAnswer}')">Submit</button>
            <button id="redoTask-${task.id}" onclick="redoTask('${task.id}')">Redo</button>
            <button id="getHint-${task.id}" onclick="getHint('${task.id}')">Get Hint</button>
            <p id="hint-${task.id}"></p>
        </div>
    </c:forEach>
</div>

</body>

</html>