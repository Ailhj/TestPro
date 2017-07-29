<%--
  Created by IntelliJ IDEA.
  User: Real
  Date: 2017-07-27
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
test


<div id="app">
    <h4>User</h4>
    <div>
        <table border = 1>
            <tr>
                <th>
                    <%--<input type="checkbox" v-model="selectAll">--%>
                    Check to select
                </th>
                <th align="left" v-for="column in columns">{{ column }}</th>
            </tr>
            <tr v-for="user in users">
                <td>
                    <input v-if="user.status==0" type="checkbox" v-model="selected" :value="user.parent" >
                </td>
                <td>
                    {{user.id}}
                </td>
                <td>
                    {{user.kid}}
                </td>
                <td>
                    {{user.parent}}
                </td>
                <td>
                    {{user.emailAddress}}
                </td>
                <td>
                    <label v-if="user.status==1">Agreed</label>
                    <label v-else>Not Agreed</label>
                </td>
                <td>
                    <button v-if="user.status==0" type="button" v-on:click="changeStatus(user.parent)">Change to Agree</button>
                </td>
            </tr>
            <%--<tr v-for="user in users">--%>
                <%--<td>--%>
                    <%--<input type="checkbox" v-model="selected" :value="user.parent" >--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%----%>
                <%--</td>--%>
            <%--</tr>--%>
        </table>
    </div>
    <span>Checked names: {{ selected }} to send email</span>
    <%--<span>{{users}}</span>--%>
    <div>
        <%--<button onclick="sendEmail()">Send Email</button>--%>
        <button v-on:click="sendEmail">Send email</button>
    </div>

    <div>
        <button v-on:click="resetStatus">reset status back to 'Not Agree'</button>
    </div>


</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.4.0/vue.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script type="text/javascript">
    var tmp;
    var vjs = new Vue({
        el: '#app',
        data: {
            columns:['Id', 'Kid', 'Parent','Email','Status','Toggle Status'],
//            users:[{"id":8,"kid":"Aalexi","parent":"Beta","emailAddress":"Beta@yahoo.com","status":0}],
            users:[],
            selected: []
        },

        mounted: function () {
            this.fetchData()
        },
        methods:{
            fetchData () {
                $.ajax({
                    url: '/select'
                }).done(data => {
//                    this.users=["123"];
                    this.users=data;

                    //alert(this.users);
//                    alert(JSON.stringify(data));
                });
            },

            //I have no idea why this function is triggered by every event if i bind it to v-on:click; because it was in computed tag
            sendEmail: function (event) {
//                alert("Sending email to "+this.selected);
//                if (event) {
//                    alert(event.target.tagName)
//                }
                $.ajax({
                    url: '/email',
                    type: "POST",
                    data:{"parent":this.selected}
                }).done(data => {
                    alert(data);
                });
            },

            changeStatus: function (parent) {
//                alert("changing status of "+parent);
                $.ajax({
                    url: '/update',
                    data:{"parent":parent}
                }).done(data => {
                    this.fetchData();
                });

            },

            resetStatus: function () {
                $.ajax({
                    url: '/reset'
                }).done(data => {
                    this.fetchData();
                });

            }


        },
        computed: {
//            selectAll: {
//                get: function () {
//                    var selected = [];
//                    this.users.forEach(function (user) {
//                        if(selected.indexOf(user.parent)==-1)
//                            selected.push(user.parent);
//                    });
//                    return this.users ? this.selected.length == selected.length : false;
//                },
//                set: function (value) {
//                    var selected = [];
//
//                    if (value) {
//                        this.users.forEach(function (user) {
//                            if(selected.indexOf(user.parent)==-1)
//                                selected.push(user.parent);
//                        });
//                    }
//
//                    this.selected = selected;
//                }
//            }


        }
    });
    function sendEmail(){
        vjs.sendEmail();

//        vjs.users = tmp;
//        vjs.selected = ["3"];
//        $.ajax({
//            url: '/select',
//            type: 'POST',
//            success: function(data){
////                alert(this.users);
//                vjs.users=JSON.stringify(data);
//
//            }
//        });
    }
</script>
</body>
</html>
