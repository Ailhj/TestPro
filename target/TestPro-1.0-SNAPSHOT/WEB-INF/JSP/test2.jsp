<%--
  Created by IntelliJ IDEA.
  User: Real
  Date: 2017-07-28
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.4.0/vue.js"></script>
<div id="example">
    <!-- `greet` is the name of a method defined below -->
    <button v-on:click="sendEmail">Greet</button>
</div>

<script>
    var example2 = new Vue({
        el: '#example',
        data: {
            selected : ['Vue.js']
        },
        // define methods under the `methods` object
        methods: {
            sendEmail: function (event) {
                alert("Sending email to "+this.selected);
                if (event) {
                    alert(event.target.tagName)
                }
            }
        }
    })
    // you can invoke methods in JavaScript too
</script>



<%--<div id="app">--%>
    <%--<h4>User</h4>--%>
    <%--<div>--%>
        <%--<table border = 1>--%>
            <%--<tr>--%>
                <%--<th><input type="checkbox" v-model="selectAll"></th>--%>
                <%--<th align="left" v-for="column in columns">{{ column }}</th>--%>
            <%--</tr>--%>
            <%--<tr v-for="user in users">--%>
                <%--<td>--%>
                    <%--<input type="checkbox" v-model="selected" :value="user.parent" >--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--{{user.id}}--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--{{user.kid}}--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--{{user.parent}}--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--{{user.email}}--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<label v-if="user.status">Agreed</label>--%>
                    <%--<label v-else>Not Agreed</label>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<input type="checkbox" v-model="user.status" value="user.status">--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</table>--%>
    <%--</div>--%>
    <%--<span>Checked names: {{ selected }} to send email</span>--%>
    <%--<button onclick="emailCheck()">EmailCheck</button>--%>
<%--</div>--%>
<%--</body>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.4.0/vue.js"></script>--%>
<%--<script>--%>
    <%--var vjs = new Vue({--%>
        <%--el: '#app',--%>
        <%--data: {--%>
            <%--columns:['Id', 'Kid', 'Parent','Email','Status','Toggle Status'],--%>
            <%--users: [--%>
                <%--{ "id": "1", "kid": "Aabbee","parent": "Alpha", "email": "Alpha@yahoo.com", "status": false },--%>
                <%--{ "id": "2", "kid": "Aabriella","parent": "Beta", "email": "Beta@yahoo.com", "status": false },--%>
                <%--{ "id": "3", "kid": "Aahana","parent": "Gamma", "email": "Gamma@hotmail.com", "status": false },--%>
                <%--{ "id": "4", "kid": "Aahliyah","parent": "Delta", "email": "Delta@hotmail.com", "status": false },--%>
                <%--{ "id": "5", "kid": "Aahna","parent": "Delta", "email": "Delta@hotmail.com", "status": false },--%>
                <%--{ "id": "6", "kid": "Aailiyah","parent": "Alpha", "email": "Alpha@yahoo.com", "status": false },--%>
                <%--{ "id": "7", "kid": "Aaleah","parent": "Delta", "email": "Delta@hotmail.com", "status": false },--%>
                <%--{ "id": "8", "kid": "Aalexi","parent": "Beta", "email": "Beta@yahoo.com", "status": false }--%>
            <%--],--%>
            <%--selected: []--%>
        <%--},--%>
        <%--computed: {--%>
            <%--selectAll: {--%>
                <%--get: function () {--%>
                    <%--var selected = [];--%>
                    <%--this.users.forEach(function (user) {--%>
                        <%--if(selected.indexOf(user.parent)==-1)--%>
                            <%--selected.push(user.parent);--%>
                    <%--});--%>
                    <%--return this.users ? this.selected.length == selected.length : false;--%>
                <%--},--%>
                <%--set: function (value) {--%>
                    <%--var selected = [];--%>

                    <%--if (value) {--%>
                        <%--this.users.forEach(function (user) {--%>
                            <%--if(selected.indexOf(user.parent)==-1)--%>
                                <%--selected.push(user.parent);--%>
                        <%--});--%>
                    <%--}--%>

                    <%--this.selected = selected;--%>
                <%--}--%>
            <%--}--%>
        <%--}--%>
    <%--});--%>
    <%--function emailCheck() {--%>
        <%--vjs.data.selected = ['123'];--%>
    <%--}--%>
<%--</script>--%>
</body>
</html>
